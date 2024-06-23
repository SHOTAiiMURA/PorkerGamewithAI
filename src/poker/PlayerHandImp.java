package poker;

public class PlayerHandImp extends HandImp implements PlayerHand{
    @Override
    public Rank evalHandRank(TableHand hand) {
        Hand combinedHand = new HandImp();
        combinedHand.addCards(hand.getCards());
        combinedHand.addCards(cards);

        boolean isOnePair = false;
        boolean isTwoPair = false;
        boolean isThreeOfAKind = false;
        boolean isFourOfAKind = false;
        boolean isStraight = false;
        boolean isFlush = false;


        // check one pair

        // check two pair

        // check three of a kind

        // check four of a kind

        // check straight

        // check flush

        // DONT RETURN TILL HERE

        if(isFlush && isStraight)
        {
            // CHECK Royal
            return Rank.STRAIGHT_FLUSH;
        }

        if(isOnePair && isThreeOfAKind)
            return Rank.FULL_HOUSE;


        return Rank.HIGH_CARD;
    }
}
