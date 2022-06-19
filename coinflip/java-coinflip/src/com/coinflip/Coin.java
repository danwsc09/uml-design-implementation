package com.coinflip;

public class Coin {
    public static final String[] coinOptions = new String[] {"Heads", "Tails"};
    private final String coinOption;

    public Coin() {
        int randIndex = Math.random() < 0.5 ? 0 : 1;
        coinOption = coinOptions[randIndex];
    }

    public String getCoinOption() { return coinOption; }
}
