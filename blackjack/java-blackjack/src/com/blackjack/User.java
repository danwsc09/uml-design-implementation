package com.blackjack;

import java.util.ArrayList;
import java.util.List;

public class User implements Player {

    public String name;
    public List<Card> hand;
    public PlayerStatus status;
    private Game game;

    public User(Game theGame, String theName) {
        this.game = theGame;
        this.hand = new ArrayList<>();
        this.status = PlayerStatus.READY;
        this.name = theName;
    }

    @Override
    public Card getCard() {
        return null;
    }

    @Override
    public PlayerStatus playHand() {
        return null;
    }
}
