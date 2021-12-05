package poker;

public class PokerGame {
    public static void main(String[] args) throws NullPointerException{

        PokerMachine pokerMachine = new PokerMachine();

        Card[] deck= pokerMachine.createDeck();
        try {
            pokerMachine.shuffleDeck(deck);
        } catch (NullPointerException e) {
            System.out.println("No deck was shuffled");
        }
        pokerMachine.serveCards(deck);
    }
}
