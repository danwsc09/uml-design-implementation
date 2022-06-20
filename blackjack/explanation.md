# Blackjack

## Note
- A dealer and 1 player
- No betting
- No splitting or doubling down (for now)

## Steps of Execution
1. Shuffle cards
2. Deal two cards (both face up) to each player and the dealer (1 face up and 1 face down)
3. Each player can choose to hit or stand until he/she wishes to stop or goes over 21 (bust)
4. If the player busts, he/she loses. Otherwise, the game continues.
5. Dealer must hit if 16 or below and stand if 17 or above.
    i. If the dealer has an ace and the cards add up to 17 or higher, the dealer must stand.
    ii. When the dealer is done, reveal dealer's face down card.
6. Compare the values; higher value wins. Same value ties.

## Features that may be added
In the order of likelihood:
- support up to 4 players (not counting the dealer)
- add in chips
- add splitting mechanism
- add doubling down mechanism
- add side bets
- play with multiple decks (6) and without shuffling each time