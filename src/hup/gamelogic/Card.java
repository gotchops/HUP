package hup.gamelogic;

public class Card implements Comparable<Card> {
	
	public enum value {
		DEUCE, THREE, FOUR, FIVE, SIX, SEVEN,
        EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
	}
	
	public enum suit {
		CLUBS, DIAMONDS, HEARTS, SPADES
	}
	
	private value m_value;
	private suit m_suit;
	
	public Card(value v, suit s) {
		m_value = v;
		m_suit = s;
	}

	@Override
	public int compareTo(Card other) {
		return this.getValue().compareTo(other.getValue());
	}

	public value getValue() {
		return m_value;
	}

	public suit getSuit() {
		return m_suit;
	}
}
