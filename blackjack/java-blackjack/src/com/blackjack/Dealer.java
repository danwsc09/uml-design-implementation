package com.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player {

    public List<Card> hand;
    public PlayerStatus status;
    public String name;
    private Game game;

    public Dealer(Game theGame) {
        super(theGame, "");
        System.out.println("The name:" + name);
        this.game = theGame;
        this.hand = new ArrayList<>();
        this.status = PlayerStatus.IN_PLAY;
    }

    @Override
    public void playHand() {
        // TODO: implement
        System.out.println("hi");
    }

    @Override
    public void reset() {
        this.hand = new ArrayList<>();
        this.status = PlayerStatus.IN_PLAY;
    }
}
