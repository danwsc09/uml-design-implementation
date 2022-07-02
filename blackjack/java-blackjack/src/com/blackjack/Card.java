package com.blackjack;

public class Card {
    public Suit suit;
    public String value;
    public boolean isFaceUp;

    public Card(Suit theSuit, String theValue, boolean isFaceUp) {
        this.suit = theSuit;
        this.value = theValue;
        this.isFaceUp = isFaceUp;
    }
}

enum Suit {
    CLUBS, DIAMONDS, HEARTS, SPADES
}
