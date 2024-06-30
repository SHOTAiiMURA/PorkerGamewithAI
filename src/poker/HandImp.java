package poker;

import java.util.ArrayList;
import java.util.List;

public class HandImp implements Hand {
    protected List<Card> cards;


    public HandImp() {
        cards = new ArrayList<>();

    }
    @Override
    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public void addCards(List<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            this.cards.add(cards.get(i));
        }
    }

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public Card get(int index) {
        return cards.get(index);
    }

    @Override
    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    @Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       for (Card card : cards) {
           builder.append(card.toString());
           builder.append("\n");
       }
       return builder.toString();
    }

    public static void main(String []args){
        Hand hand = new HandImp();
        hand.addCard(new CardImp(0,CardSuit.DIAMONDS));
        hand.addCard(new CardImp(3,CardSuit.HEARTS));
        hand.addCard(new CardImp(5,CardSuit.HEARTS));
        System.out.println(hand);
    }
}

