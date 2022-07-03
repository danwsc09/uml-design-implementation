package com.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Dealer implements Player {

    public List<Card> hand;
    public PlayerStatus status;
    private Game game;

    public Dealer(Game theGame) {
        this.game = theGame;
        this.hand = new ArrayList<>();
        this.status = PlayerStatus.IN_PLAY;
    }

    @Override
    public Card getCard() {
        return null;
    }

    @Override
    public PlayerStatus playHand() {
        return null;
    }

    @Override
    public void reset() {
        this.hand = new ArrayList<>();
        this.status = PlayerStatus.IN_PLAY;
    }
}
