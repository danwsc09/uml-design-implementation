package com.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    public List<Card> cards;

    public Deck() {
        cards = generateDeck();
        shuffle();
    }

    public List<Card> generateDeck() {
        List<Card> theCards = new ArrayList<>();
        Suit[] suits = new Suit[]{Suit.CLUBS, Suit.SPADES, Suit.DIAMONDS, Suit.HEARTS};
        String[] values = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (Suit suit : suits) {
            for (String value : values) {
                theCards.add(new Card(suit, value, false));
            }
        }

        return theCards;
    }

    public void shuffle() {
        cards.sort((c1, c2) -> Double.compare(Math.random(), 0.5));
    }

    public void reset() {
        cards = generateDeck();
        shuffle();
    }

    public Card dealCard(boolean isFaceUp) {
        Card card = cards.remove(cards.size() - 1);
        card.isFaceUp = isFaceUp;
        return card;
    }
}
