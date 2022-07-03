package com.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Dan");
        Game theGame = new Game(names);
        theGame.startGame();
    }
}
