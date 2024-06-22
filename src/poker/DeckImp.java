package poker;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckImp implements Deck {
    //create fields
    static int SIZE = 52;
    private List<Card> cards;
    private int fillcards;
    private int shuffleInt;

    //create constructor
    public DeckImp() {
        this.cards = new ArrayList<>();
        fillDeck();


    }
    public void setShuffleInt() {
        shuffleInt = (int) (Math.random()*SIZE+1);
    }
    //create constructor
    @Override
    public Card drawCard() {
        return cards.remove(0);
    }

    @Override
    public void shuffle() {
        for (int i = 0; i < SIZE; i++) {
            Random r = new Random();
            int rand = r.nextInt(SIZE);
            Card temp = cards.get(rand);
            Card card = cards.get(i);
            cards.set(rand,card);
            cards.set(i,temp);
        }
    }

    @Override
    public void fillDeck() {
        for (int i = 0; i < SIZE; i++) {
            cards.add(new CardImp(i));
        }
    }


}
