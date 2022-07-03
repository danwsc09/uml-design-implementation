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

    public int getCardValue() {
        return switch (value) {
            case "A" -> 1;
            case "J", "Q", "K" -> 10;
            default -> Integer.parseInt(value);
        };
    }

    @Override
    public String toString() {
        return suit + " " + value;
    }
}

enum Suit {
    CLUBS, DIAMONDS, HEARTS, SPADES
}
