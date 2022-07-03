package com.blackjack.test;

import com.blackjack.Card;
import com.blackjack.Game;
import com.blackjack.Suit;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    static Game game;
    static List<Card> cards;

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Dan");
        game = new Game(names);

        cards = new ArrayList<>();
        System.out.println("START");

        testEvaluateHand1();
        testEvaluateHand2();
        testEvaluateHand3();

        System.out.println("DONE");
    }

    public static void testEvaluateHand1() {
        cards.clear();
        cards.add(new Card(Suit.CLUBS, "6", false));
        cards.add(new Card(Suit.CLUBS, "7", false));
        int value = game.evaluateHand(cards);
        System.out.println("excepted: 13, actual: " + value);
    }

    public static void testEvaluateHand2() {
        cards.clear();
        cards.add(new Card(Suit.CLUBS, "6", false));
        cards.add(new Card(Suit.CLUBS, "7", false));
        cards.add(new Card(Suit.CLUBS, "A", false));
        int value = game.evaluateHand(cards);
        System.out.println("excepted: 14, actual: " + value);
    }

    public static void testEvaluateHand3() {
        cards.clear();
        cards.add(new Card(Suit.CLUBS, "6", false));
        cards.add(new Card(Suit.CLUBS, "7", false));
        cards.add(new Card(Suit.CLUBS, "A", false));
        cards.add(new Card(Suit.CLUBS, "K", false));
        int value = game.evaluateHand(cards);
        System.out.println("excepted: 0, actual: " + value);
    }
}
