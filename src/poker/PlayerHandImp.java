package poker;

import java.util.*;

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
        List<Integer> result_three_of_a_kind = new ArrayList<>();
        List<Integer> result_four_of_a_kind = new ArrayList<>();
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
        for (Card card1 : combinedHand.getCards()) {
            for(Card card2 : combinedHand.getCards()) {
                if(card1.getNumber()==card2.getNumber()) {
                    counter += 1;
                }
            }
            if (counter ==3){
                result_pairs.add(card1.getNumber());
            }
        }
        if (result_pairs.size()>=3){
            isThreeOfAKind = true;
        }
        // check four of a kind
        for (Card card1 : combinedHand.getCards()) {
            for(Card card2 : combinedHand.getCards()) {
                if(card1.getNumber()==card2.getNumber()) {
                    counter += 1;
                }
            }
            if (counter ==4){
                result_pairs.add(card1.getNumber());
            }
        }
        if (result_pairs.size()>=4){
            isFourOfAKind = true;
        }
        // check straight
        // use number
        //カードを数字が大きい順にソートする。
        //配列の1番目から4番目（後ろから二番目）まで、差が１であるか判別する。（差が１でなければその時点でFalse.）例）８と８は０だからストレートの組み合わせは不可。KとAも不可。
        ArrayList<Integer> result_straight = new ArrayList<>();
        Collections.sort(combinedHand, Collections.reverseOrder());
        for(int i = 0; i < combinedHand.size(3); i++){
            if(card[i]-card[i+1] == 1){
                isStraight = true;
            }
            else if{
                if(カード[4] - カード[3] == 1 || カード[0] == 5 && カード[4] == "A");
                    isStraight = true;

            }
            //二個目のIFぶんはいらない感じがする。

        }
        // check flush
        Set <String> result_flush = new HashSet<>();
        for (Card card1 : combinedHand.getCards()) {
            for(Card card2 : combinedHand.getCards()) {
                if(card1.getSuit()!=card2.getSuit()) {
                    isFlush = false;
                }
                else{
                    isFlush = true;
                }
            }
        }
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
