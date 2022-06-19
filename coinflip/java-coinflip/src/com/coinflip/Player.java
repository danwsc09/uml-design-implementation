package com.coinflip;

public class Player {
    private final String name;
    private String coinOption;

    public Player(String theName) {
        this.name = theName;
    }

    public String getRandCoinOption() {
        int randIndex = Math.random() < 0.5 ? 0 : 1;
        coinOption = Coin.coinOptions[randIndex];
        return coinOption;
    }

    public void setCoinOption(String opponentOption) {
        coinOption = opponentOption == "Heads" ? "Tails" : "Heads";
    }

    public void didPlayerWin(String winningFlip) {
        if (winningFlip == coinOption) {
            System.out.println(name + " won with a flip of " + coinOption);
        } else {
            System.out.println(name + " lost with a flip of " + coinOption);
        }
    }
}
