package poker;

import java.util.List;

public interface Hand {
    void addCard(Card card);
    void addCards(List<Card> cards);
    int size();
    Card get(int index);
}
