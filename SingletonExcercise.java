package codewithbrook;
  import java.util.ArrayList;
  import java.util.Collections;
  import java.util.List;
  import java.util.Random;

class SingletonExcercise {
    enum Suit {
        SPADES,
        HEARTS,
        CLUBS,
        DIAMONDS
    }

    static class Card {
        public Card(Suit s, int n) {
            suit = s;
            if ((n < 2) || (n > 14)) {
                throw new IllegalArgumentException();
            }
            number = n;
        }

        public void print() {
            switch (number) {
                case 11:
                    System.out.print("Jack");
                    break;
                case 12:
                    System.out.print("Queen");
                    break;
                case 13:
                    System.out.print("King");
                    break;
                case 14:
                    System.out.print("Ace");
                    break;
                default:
                    System.out.print(number);
                    break;
            }
            System.out.print(" of ");
            switch (suit) {
                case SPADES:
                    System.out.println("spades.");
                    break;
                case HEARTS:
                    System.out.println("hearts.");
                    break;
                case CLUBS:
                    System.out.println("clubs.");
                    break;
                case DIAMONDS:
                    System.out.println("diamonds.");
                    break;
            }
        }

        private Suit suit;
        private int number;
    }


    static class Deck {

        private static Deck instance = null;

        private Deck() {
            cards = new ArrayList<Card>();

            // build the deck
            Suit[] suits = {Suit.SPADES, Suit.HEARTS, Suit.CLUBS, Suit.DIAMONDS};
            for (Suit suit : suits) {
                for (int i = 2; i <= 14; i++) {
                    cards.add(new Card(suit, i));
                }
            }

            // shuffle it!
            Collections.shuffle(cards, new Random());
        }

        // create Singleton class
        public static Deck getInstance()
        {
            if (instance == null) {
                instance = new Deck();
            }

            return instance;
        }

        public void print() {
            for (Card card : cards) {
                card.print();
            }
        }

        private List<Card> cards;
    }

    public static void main(String[] args) {
        Deck deck = Deck.getInstance();
        deck.print();
    }
}
