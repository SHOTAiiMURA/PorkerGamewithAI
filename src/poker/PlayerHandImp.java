package poker;

import java.util.HashSet;
import java.util.Set;

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
        Set<Integer> result_pairs = new HashSet<>();
        int counter = 0;
        for (Card card1 : combinedHand.getCards()) {
            for(Card card2 : combinedHand.getCards()) {
                if(card1.getNumber()==card2.getNumber()) {
                    counter += 1;
                }
            }
            if (counter ==2){
                result_pairs.add(card1.getNumber());
            }
        }
        if (result_pairs.size()==1){
            isOnePair = true;
        }
        // check two pair
        if (result_pairs.size()>=2){
            isTwoPair = true;
        }
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
