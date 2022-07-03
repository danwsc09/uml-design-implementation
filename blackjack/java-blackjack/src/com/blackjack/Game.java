package com.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    public List<User> users;
    public Dealer dealer;
    public Deck deck;
    private Scanner scanner;

    public Game(List<String> names) {
        // FUTURE: implement multi-player mode (with multiple users)
        this.users = new ArrayList<>();
        for (String name : names) {
            this.users.add(new User(this, name));
        }

        this.dealer = new Dealer(this);
        this.deck = new Deck();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        String userInput;

        do {
            this.reset();
            this.dealCardToPlayers();
            this.dealCardToDealer();
            this.playPlayersHands();
            boolean didHouseWin = this.checkIfHouseWins();
            if (!didHouseWin) {
                this.playDealersHand();
            }
            this.displayResult();
            System.out.println("Play again? (y/n)");
            userInput = scanner.nextLine();
        } while (userInput.startsWith("y") || userInput.startsWith("Y"));
    }

    private void reset() {
        deck.reset();
        for (User user : users) {
            user.reset();
        }
        dealer.reset();
    }

    private void dealCardToPlayers() {
        for (User user : users) {
            user.hand.add(deck.dealCard(true));
            user.hand.add(deck.dealCard(true));
            if (evaluateHand(user.hand) == 21) {
                user.status = PlayerStatus.BLACKJACK;
            }
        }
    }

    private void dealCardToDealer() {
        dealer.hand.add(deck.dealCard(false));
        dealer.hand.add(deck.dealCard(true));
    }

    private void playPlayersHands() {
        String userInput;
        for (User user : users) {
            System.out.println(user.name + "'s status: " + user.status);
            while (user.status == PlayerStatus.IN_PLAY) {
                System.out.println("Your cards:");
                for (Card card : user.hand)
                    System.out.print(card + " ");
                System.out.println();

                System.out.println("Hit or stand? (h/s)");
                userInput = scanner.nextLine();
                if (userInput.startsWith("s") || userInput.startsWith("S")) {
                    System.out.println("You've chosen to stand.");
                    break;
                } else if (userInput.startsWith("h") || userInput.startsWith("H")) {
                    Card newCard = deck.dealCard(true);
                    System.out.println("Here's a card for you: " + newCard);
                    user.hand.add(newCard);
                    int userHandValue = evaluateHand(user.hand);
                    if (userHandValue == 21) {
                        user.status = PlayerStatus.BLACKJACK;
                    } else if (userHandValue > 21) {
                        user.status = PlayerStatus.BUST;
                    }
                } else {
                    System.out.println("Invalid input. Let's try again.");
                }
            }
            switch (user.status) {
                case IN_PLAY -> System.out.println(user.name + "'s best value: " + evaluateHand(user.hand));
                case BLACKJACK -> System.out.println(user.name + ": BLACKJACK!");
                default -> System.out.println(user.name + " is BUST.");
            }
        }
    }

    public int evaluateHand(List<Card> cards) {
        List<Integer> values = new ArrayList<>();
        int first = cards.get(0).getCardValue();
        values.add(first);
        if (first == 1)
            values.add(11);

        for (int i = 1; i < cards.size(); i++) {
            int theCard = cards.get(i).getCardValue();
            int n = values.size();
            for (int j = 0; j < n; j++) {
                values.set(j, values.get(j) + theCard);
                if (theCard == 1) {
                    values.add(values.get(j) + 10);
                }
            }
        }

        int max = 0;
        for (int handValue : values)
            if (handValue <= 21 && handValue > max) {
                max = handValue;
            }

        return max == 0 ? Collections.min(values) : max;
    }

    private boolean checkIfHouseWins() {
        for (User user : users)
            if (user.status == PlayerStatus.IN_PLAY || user.status == PlayerStatus.BLACKJACK)
                return false;
        return true;
    }

    private void playDealersHand() {
        System.out.println("Dealer's turn to play");
        for (Card card : dealer.hand) {
            System.out.print(card + " ");
        }
        System.out.println();

        while (evaluateHand(dealer.hand) <= 16) {
            Card newCard = deck.dealCard(true);
            System.out.println("Dealer gets a card: " + newCard);
            dealer.hand.add(newCard);
            for (Card card : dealer.hand) {
                System.out.print(card + " ");
            }
            System.out.println();
        }

        int dealerValue = evaluateHand(dealer.hand);
        if (dealerValue > 21) {
            System.out.println("Dealer is bust.");
        } else if (dealerValue == 21) {
            System.out.println("Dealer gets a blackjack");
        } else {
            System.out.println("Dealer's value: " + dealerValue);
        }
    }

    private void displayResult() {
        for (User user : users) {
            String message = String.format("%s: %s. Cards: %s\n", user.name, user.status, user.hand);
            System.out.println(message);
        }
        String message = String.format("dealer: %s. Cards: %s\n", dealer.status, dealer.hand);
        System.out.println(message);
    }

}
