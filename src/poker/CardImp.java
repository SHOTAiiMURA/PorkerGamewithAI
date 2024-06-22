package poker;

public class CardImp implements Card {
    //create fileds
    private int id;
    private int number;
    private CardSuit suit;
    //create constructor
    public CardImp(int id) {
        this.id = id;
        number = id % 13;
        suit = CardSuit.values()[id / 13];
    }
    public CardImp(int number, CardSuit suit) {
        this.number = number;
        this.suit = suit;
        //find out id when number and card suit are given.
        id = suit.ordinal()*13 + number;
    }
    @Override
    public int getCardID() {
        return id;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public CardSuit getSuit() {
        return suit;
    }
}
