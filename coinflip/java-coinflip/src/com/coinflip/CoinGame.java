package com.coinflip;

import java.util.Scanner;

public class CoinGame {
    public Player[] players;
    public Coin coin;

    public CoinGame(String player1Name, String player2Name) {
        players = new Player[2];
        players[0] = new Player(player1Name);
        players[1] = new Player(player2Name);
    }

    public void startGame() {
        String userInput;
        do {

            int randIndex = Math.random() < 0.5 ? 0 : 1;
            int otherIndex = randIndex == 0 ? 1 : 0;

            String playerPick = players[randIndex].getRandCoinOption();
            players[otherIndex].setCoinOption(playerPick);

            coin = new Coin();
            String winningFlip = coin.getCoinOption();

            players[0].didPlayerWin(winningFlip);
            players[1].didPlayerWin(winningFlip);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Play again? y/n");
            userInput = scanner.nextLine();
        } while ((userInput.startsWith("y")) || (userInput.startsWith("Y")));
    }
}
