package poker;

import java.util.Random;

public class PokerMachine {

    int numOfCards = 52;
    int numOfPlayers = 4;

    public Card[] createDeck() {
        String[] suits = {"Hearts", "Clubs", "Diamonds","Spades"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        Card[] deck = new Card[numOfCards];

        int count = 0;
        for (String suit:suits) {
            for (String value:values) {
                deck[count++] = new Card(suit, value);
            }
        }
    return deck;
    }

    public void shuffleDeck(Card[] deck) {
        if (deck == null) {
            throw new NullPointerException("Exception: deck cannot be null");
        }
        Random random = new Random();
        for(int i= 0; i<100; i++) {
            int in = random.nextInt(numOfCards);
            int out = random.nextInt(numOfCards);

            Card card = deck[in];
            deck[in] = deck[out];
            deck[out] = card;
        }
    }

    public void serveCards(Card[] deck){
        if (deck == null) {
            throw new NullPointerException("Exception: deck cannot be null");
        }
            int count = 0;
            for (int round = 1; round < 6; round++) {
                System.out.printf("%d round%n", round);
                for (int player = 1; player <= numOfPlayers; player++) {
                    System.out.printf("Player %d gets %s%n", player, deck[count++]);
                }
                System.out.println("****");
            }

    }
}
