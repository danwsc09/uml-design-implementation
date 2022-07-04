package com.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User extends Player {

//    public String name;
//    public List<Card> hand;
//    public PlayerStatus status;
//    private Game game;

    public User(Game theGame, String theName) {
        super(theGame, theName);
    }

    @Override
    public void playHand() {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        System.out.println(name + "'s status: " + status);
        while (status == PlayerStatus.IN_PLAY) {
            System.out.println("Your cards:");
            for (Card card : hand)
                System.out.print(card + " ");
            System.out.println();

            System.out.println("Hit or stand? (h/s)");
            userInput = scanner.nextLine();
            if (userInput.startsWith("s") || userInput.startsWith("S")) {
                System.out.println("You've chosen to stand.");
                break;
            } else if (userInput.startsWith("h") || userInput.startsWith("H")) {
                Card newCard = this.getCard(true);
                hand.add(newCard);
                System.out.println("new card: " + newCard);
                int userHandValue = game.evaluateHand(hand);

                if (userHandValue == 21) {
                    status = PlayerStatus.BLACKJACK;
                } else if (userHandValue > 21) {
                    status = PlayerStatus.BUST;
                }
            } else {
                System.out.println("Invalid input. Let's try again.");
            }
        }
        switch (status) {
            case IN_PLAY -> System.out.println(name + "'s best value: " + evaluateHand(hand));
            case BLACKJACK -> System.out.println(name + ": BLACKJACK!");
            default -> System.out.println(name + " is BUST.");
        }

    }

    @Override
    public void reset() {
        this.hand = new ArrayList<>();
        this.status = PlayerStatus.IN_PLAY;
    }
}
