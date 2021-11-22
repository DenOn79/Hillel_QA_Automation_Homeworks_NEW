package CardDealerApp;

import java.util.Random;

public class CardDealer3 {
    public static void main(String[] args) {

        int numOfCards = 52;

        int numOfPlayers = 4;

        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};

        String[] deck = new String[numOfCards];

        int count = 0;

        Card card = new Card();

        for (String suit : suits) {
            for (String value : values) {
                deck[count++] = card.getCard(suit, value);

            }
        }

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int in = random.nextInt(numOfCards);
            int out = random.nextInt(numOfCards);

            String tempCard = deck[in];
            deck[in] = deck[out];
            deck[out] = tempCard;
        }

        count = 0;

        Player player = new Player();

        for (int round = 1; round < 6; round++) {
            System.out.printf("Round %d%n", round);
            for (int playerNumber = 1; playerNumber <= numOfPlayers; playerNumber++) {
                System.out.printf(player.getPlayer() + " %d gets %s%n", playerNumber, deck[count++]);
            }
            System.out.println("");
        }

    }
}
