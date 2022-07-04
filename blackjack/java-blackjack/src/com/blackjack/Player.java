package com.blackjack;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    public List<Card> hand;
    public PlayerStatus status;
    public String name;
    protected final Game game;

    protected Player(Game theGame, String theName) {
        game = theGame;
        name = theName;
        hand = new ArrayList<>();
        status = PlayerStatus.IN_PLAY;
    }

    public void playHand() throws Exception {
        throw new Exception("playHand() must be overriden by the child class");
    }

    public void reset() {
        hand.clear();
        status = PlayerStatus.IN_PLAY;
    }

    protected Card getCard(boolean isFaceUp) {
        return game.deck.dealCard(isFaceUp);
    }

    protected int evaluateHand(List<Card> cards) {
        return game.evaluateHand(cards);
    }
}
