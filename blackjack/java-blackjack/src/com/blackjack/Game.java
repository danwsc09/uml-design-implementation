package com.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public List<User> users;
    public Dealer dealer;
    public Deck deck;

    public Game(List<String> names) {
        // FUTURE: implement multi-player mode (with multiple users)
        this.users = new ArrayList<>();
        for (String name : names) {
            this.users.add(new User(this, name));
        }

        this.dealer = new Dealer(this);
        this.deck = new Deck();
    }

    public void startGame() {
        String userInput;
        Scanner sc = new Scanner(System.in);

        do {
            // TODO
            this.reset();
            this.dealCardToPlayers();
            this.dealCardToDealer();
            this.playPlayersHands();
            boolean didHouseWin = this.checkIfHouseWins();
            if (!didHouseWin) {
                this.playDealersHand();
            }
            this.displayResult();
            userInput = sc.nextLine();
        } while (userInput.startsWith("y"));
    }

    private void reset() {
        // TODO
    }

    private void dealCardToPlayers() {
        // TODO
    }

    private void dealCardToDealer() {
        // TODO
    }

    private void playPlayersHands() {
        // TODO
    }

    public int evaluateHand(List<Card> cards) {
        // TODO
        return 0;
    }

    private boolean checkIfHouseWins() {
        // TODO
        return false;
    }

    private void playDealersHand() {
        // TODO
    }

    private void displayResult() {
        // TODO
    }

}
