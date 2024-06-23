package poker;

import java.util.List;

public interface Hand {
    void addCard(Card card);
    void addCards(List<Card> cards);
    void size();
    void get(int index);
}
