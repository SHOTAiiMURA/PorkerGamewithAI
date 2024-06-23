package poker;

public interface PlayerHand extends Hand {
    Rank evalHandRank(TableHand hand);
}
