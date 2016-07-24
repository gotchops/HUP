package hup.gamelogic;

import java.util.Arrays;

public class Hand {
	 private Card[] m_pocket;
     private Rank m_rank;

     public Hand(Card c0, Card c1)
     {
         m_pocket = new Card[] { c0, c1 };
     }

     private static void m_sort(Card[] cards)
     {
         Arrays.sort(cards);
     }
     
     public static Card[] getHighestOfCombo(
    		 Card pocket1,
    		 Card pocket2,
    		 Card c1,
    		 Card c2,
    		 Card c3,
    		 Card c4) {
    	 Rank r1 = getRank(pocket1, pocket2, c1, c2, c3);
    	 Rank r2 = getRank(pocket1, pocket2, c2, c3, c4);
    	 Rank r3 = getRank(pocket1, pocket2, c1, c3, c4);
    	 Rank r4 = getRank(pocket1, pocket2, c1, c2, c4);
    	 
    	 Rank[] ranks = new Rank[] { r1, r2, r3, r4 };
    	 Arrays.sort(ranks);
    	 
    	 Rank highest = ranks[3];
    	 if (r1.equals(highest)) {
    		 return new Card[] {pocket1, pocket2, c1, c2, c3};
    	 } else if (r2.equals(highest)) {
    		 return new Card[] {pocket1, pocket2, c2, c3, c4};
    	 } else if (r3.equals(highest)) {
    		 return new Card[] {pocket1, pocket2, c1, c3, c4};
    	 } else {
    		 return new Card[] {pocket1, pocket2, c1, c2, c4};
    	 }
     }
     
     public static Card[] getHighestOfCombo(
    		 Card pocket1,
    		 Card pocket2,
    		 Card c1,
    		 Card c2,
    		 Card c3,
    		 Card c4,
    		 Card c5) {
    	 Rank r1 = getRank(pocket1, pocket2, c1, c2, c3);
    	 Rank r2 = getRank(pocket1, pocket2, c2, c3, c4);
    	 Rank r3 = getRank(pocket1, pocket2, c3, c4, c5);
    	 Rank r4 = getRank(pocket1, pocket2, c1, c4, c5);
    	 Rank r5 = getRank(pocket1, pocket2, c1, c3, c4);
    	 Rank r6 = getRank(pocket1, pocket2, c2, c4, c5);
    	 Rank r7 = getRank(pocket1, pocket2, c1, c2, c4);
    	 Rank r8 = getRank(pocket1, pocket2, c1, c2, c5);
    	 Rank r9 = getRank(pocket1, pocket2, c2, c3, c5);
    	 Rank r10 = getRank(pocket1, pocket2, c1, c3, c5);
    	 
    	 Rank[] ranks = new Rank[] { r1, r2, r3, r4, r5, r6, r7, r8, r9, r10 };
    	 Arrays.sort(ranks);
    	 
    	 Rank highest = ranks[9];
    	 if (r1.equals(highest)) {
    		 return new Card[] {pocket1, pocket2, c1, c2, c3};
    	 } else if (r2.equals(highest)) {
    		 return new Card[] {pocket1, pocket2, c2, c3, c4};
    	 } else if (r3.equals(highest)) {
    		 return new Card[] {pocket1, pocket2, c3, c4, c5};
    	 } else if (r4.equals(highest)) {
    		 return new Card[] {pocket1, pocket2, c1, c4, c5};
    	 } else if (r5.equals(highest)) {
    		 return new Card[] {pocket1, pocket2, c1, c3, c4};
    	 } else if (r6.equals(highest)) {
    		 return new Card[] {pocket1, pocket2, c2, c4, c5};
    	 } else if (r7.equals(highest)) {
    		 return new Card[] {pocket1, pocket2, c1, c2, c4};
    	 } else if (r8.equals(highest)) {
    		 return new Card[] {pocket1, pocket2, c1, c2, c5};
    	 } else if (r9.equals(highest)) {
    		 return new Card[] {pocket1, pocket2, c2, c3, c5};
    	 } else {
    		 return new Card[] {pocket1, pocket2, c1, c3, c5};
    	 }
     }


     public static Rank getRank(Card c0, Card c1, Card c2, Card c3, Card c4)
     {
         Card[] cards = new Card[] { c0, c1, c2, c3, c4 };
         m_sort(cards);

         if (m_isStraightFlush(cards))
         {
             return m_getStraightFlushDegree(cards);
         }
         else if (m_isQuads(cards))
         {
             return m_getQuadsDegree(cards);
         }
         else if (m_isFullHouse(cards))
         {
             return m_getFullHouseDegree(cards);
         }
         else if (m_isFlush(cards))
         {
             return m_getFlushDegree(cards);
         }
         else if (m_isStraight(cards))
         {
             return m_getStraightDegree(cards);
         }
         else if (m_isTrips(cards))
         {
             return m_getTripsDegree(cards);
         }
         else if (m_isTwoPair(cards))
         {
             return m_getTwoPairDegree(cards);
         }
         else if (m_isPair(cards)) {
             return m_getPairDegree(cards);
         }
         else
         {
             return m_getHighCardDegree(cards);
         }
     }

     private static boolean m_isStraightFlush(Card[] cards)
     {
         return (m_isStraight(cards) && m_isFlush(cards));
     }

     private static Rank m_getStraightFlushDegree(Card[] cards)
     {
         StraightFlush r;

         if (cards[4].getValue() == Card.value.ACE &&
             cards[3].getValue() == Card.value.FIVE)
         {
             r = new StraightFlush(Card.value.FIVE);
         }
         else
         {
             r = new StraightFlush(cards[4].getValue());
         }
         return r;
     }

     private static boolean m_isQuads(Card[] cards)
     {
         if ((cards[0].getValue() == cards[3].getValue()) ||
             cards[1].getValue() == cards[4].getValue())
         {
             return true;
         }
         return false;
     }

     private static Rank m_getQuadsDegree(Card[] cards)
     {
         return new Quads(cards[2].getValue());
     }

     private static boolean m_isFullHouse(Card[] cards)
     {
         if (((cards[0].getValue() == cards[2].getValue()) &&
                 (cards[3].getValue() == cards[4].getValue())) ||
             ((cards[1].getValue() == cards[3].getValue()) &&
                 (cards[0].getValue() == cards[4].getValue())) ||
             ((cards[2].getValue() == cards[4].getValue()) &&
                 (cards[0].getValue() == cards[1].getValue())))
         {
             return true;
         }
         return false;
     }

     private static Rank m_getFullHouseDegree(Card[] cards)
     {
         return new FullHouse(cards[2].getValue());
     }

     private static boolean m_isFlush(Card[] cards)
     {
         Card.suit suit = cards[0].getSuit();
         boolean sameSuit = true;
         for (Card card : cards)
         {
             if (card.getSuit() != suit)
             {
                 sameSuit = false;
             }
         }

         return sameSuit;
     }

     private static Rank m_getFlushDegree(Card[] cards)
     {
         return new Flush(cards[4].getValue());
     }

     private static boolean m_isStraight(Card[] cards)
     {
         boolean isStraight = true;
         int countTo = cards.length;
         
         if (cards[4].getValue() == Card.value.ACE &&
             cards[3].getValue() == Card.value.FIVE)
         {
             countTo--;
         } 

         for (int i = 1; i < countTo; i++)
         {
             if (cards[i].getValue().ordinal() != cards[i - 1].getValue().ordinal() + 1)
             {
                 isStraight = false;
             }
         }

         return isStraight;
     }

     private static Rank m_getStraightDegree(Card[] cards)
     {
         Straight r;

         if (cards[4].getValue() == Card.value.ACE &&
             cards[3].getValue() == Card.value.FIVE)
         {
             r = new Straight(Card.value.FIVE);
         }
         else
         {
             r = new Straight(cards[4].getValue());
         }

         return r;
     }

     private static boolean m_isTrips(Card[] cards)
     {
         if (cards[0].getValue() == cards[2].getValue() ||
             cards[1].getValue() == cards[3].getValue() ||
             cards[2].getValue() == cards[4].getValue())
         {
             return true;
         }
         return false;
     }

     private static Rank m_getTripsDegree(Card[] cards)
     {
         Trips r;

         if (cards[0].getValue() == cards[2].getValue())
         {
             r = new Trips(cards[0].getValue());
         }
         else if (cards[1].getValue() == cards[3].getValue())
         {
             r = new Trips(cards[1].getValue());
         }
         else
         {
             r = new Trips(cards[2].getValue());
         }

         return r;
     }

     private static boolean m_isTwoPair(Card[] cards)
     {
         if (((cards[0].getValue() == cards[1].getValue()) &&
                 (cards[2].getValue() == cards[3].getValue())) ||
            ((cards[0].getValue() == cards[1].getValue()) &&
                 (cards[3].getValue() == cards[4].getValue())) ||
            ((cards[1].getValue() == cards[2].getValue()) &&
                 (cards[3].getValue() == cards[4].getValue())))
         {
             return true;
         }
         return false;
     }

     private static Rank m_getTwoPairDegree(Card[] cards)
     {
         TwoPair r;

         if (cards[0].getValue() == cards[1].getValue())
         {
             if (cards[2].getValue() == cards[3].getValue())
             {
                 if (cards[0].getValue().compareTo(cards[2].getValue()) > 0)
                 {
                     r = new TwoPair(cards[0].getValue(), cards[2].getValue(), cards[4].getValue());
                 }
                 else
                 {
                     r = new TwoPair(cards[2].getValue(), cards[0].getValue(), cards[4].getValue());
                 }
             }
             else
             {
                 if (cards[0].getValue().compareTo(cards[3].getValue()) > 0)
                 {
                     r = new TwoPair(cards[0].getValue(), cards[3].getValue(), cards[2].getValue());
                 }
                 else
                 {
                     r = new TwoPair(cards[3].getValue(), cards[0].getValue(), cards[2].getValue());
                 }
             }
         }
         else
         {
             if (cards[1].getValue().compareTo(cards[3].getValue()) > 0)
             {
                 r = new TwoPair(cards[1].getValue(), cards[3].getValue(), cards[0].getValue());
             }
             else
             {
                 r = new TwoPair(cards[3].getValue(), cards[1].getValue(), cards[0].getValue());
             }
         }

         return r;
     }

     private static boolean m_isPair(Card[] cards)
     {
         if ((cards[0].getValue() == cards[1].getValue()) ||
             (cards[1].getValue() == cards[2].getValue()) ||
             (cards[2].getValue() == cards[3].getValue()) ||
             (cards[3].getValue() == cards[4].getValue()))
         {
             return true;
         }
         return false;
     }

     private static Rank m_getPairDegree(Card[] cards)
     {
         Pair r;

         if (cards[0].getValue() == cards[1].getValue())
         {
             r = new Pair(cards[0].getValue(), cards[4].getValue());
         }
         else if (cards[1].getValue() == cards[2].getValue())
         {
             r = new Pair(cards[1].getValue(), cards[4].getValue());
         }
         else if (cards[2].getValue() == cards[3].getValue())
         {
             r = new Pair(cards[2].getValue(), cards[4].getValue());
         }
         else
         {
             r = new Pair(cards[4].getValue(), cards[2].getValue());
         }

         return r;
     }

     private static Rank m_getHighCardDegree(Card[] cards)
     {
         return new HighCard(cards[4].getValue());
     }

}
