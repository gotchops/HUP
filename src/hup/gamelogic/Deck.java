package hup.gamelogic;

import java.util.Random;

public class Deck {
	private final int DECK_SIZE = 52;
    private int m_index = 0;

    private Card[] m_cards;

    public Deck()
    {
        m_initCards(m_cards);
        this.shuffle();
    }

    private void m_initCards(Card[] cards)
    {
        cards = new Card[] {
            new Card(Card.value.DEUCE, Card.suit.CLUBS),
            new Card(Card.value.THREE, Card.suit.CLUBS),
            new Card(Card.value.FOUR, Card.suit.CLUBS),
            new Card(Card.value.FIVE, Card.suit.CLUBS),
            new Card(Card.value.SIX, Card.suit.CLUBS),
            new Card(Card.value.SEVEN, Card.suit.CLUBS),
            new Card(Card.value.EIGHT, Card.suit.CLUBS),
            new Card(Card.value.NINE, Card.suit.CLUBS),
            new Card(Card.value.TEN, Card.suit.CLUBS),
            new Card(Card.value.JACK, Card.suit.CLUBS),
            new Card(Card.value.QUEEN, Card.suit.CLUBS),
            new Card(Card.value.KING, Card.suit.CLUBS),
            new Card(Card.value.ACE, Card.suit.CLUBS),
            new Card(Card.value.DEUCE, Card.suit.DIAMONDS),
            new Card(Card.value.THREE, Card.suit.DIAMONDS),
            new Card(Card.value.FOUR, Card.suit.DIAMONDS),
            new Card(Card.value.FIVE, Card.suit.DIAMONDS),
            new Card(Card.value.SIX, Card.suit.DIAMONDS),
            new Card(Card.value.SEVEN, Card.suit.DIAMONDS),
            new Card(Card.value.EIGHT, Card.suit.DIAMONDS),
            new Card(Card.value.NINE, Card.suit.DIAMONDS),
            new Card(Card.value.TEN, Card.suit.DIAMONDS),
            new Card(Card.value.JACK, Card.suit.DIAMONDS),
            new Card(Card.value.QUEEN, Card.suit.DIAMONDS),
            new Card(Card.value.KING, Card.suit.DIAMONDS),
            new Card(Card.value.ACE, Card.suit.DIAMONDS),
            new Card(Card.value.DEUCE, Card.suit.HEARTS),
            new Card(Card.value.THREE, Card.suit.HEARTS),
            new Card(Card.value.FOUR, Card.suit.HEARTS),
            new Card(Card.value.FIVE, Card.suit.HEARTS),
            new Card(Card.value.SIX, Card.suit.HEARTS),
            new Card(Card.value.SEVEN, Card.suit.HEARTS),
            new Card(Card.value.EIGHT, Card.suit.HEARTS),
            new Card(Card.value.NINE, Card.suit.HEARTS),
            new Card(Card.value.TEN, Card.suit.HEARTS),
            new Card(Card.value.JACK, Card.suit.HEARTS),
            new Card(Card.value.QUEEN, Card.suit.HEARTS),
            new Card(Card.value.KING, Card.suit.HEARTS),
            new Card(Card.value.ACE, Card.suit.HEARTS),
            new Card(Card.value.DEUCE, Card.suit.SPADES),
            new Card(Card.value.THREE, Card.suit.SPADES),
            new Card(Card.value.FOUR, Card.suit.SPADES),
            new Card(Card.value.FIVE, Card.suit.SPADES),
            new Card(Card.value.SIX, Card.suit.SPADES),
            new Card(Card.value.SEVEN, Card.suit.SPADES),
            new Card(Card.value.EIGHT, Card.suit.SPADES),
            new Card(Card.value.NINE, Card.suit.SPADES),
            new Card(Card.value.TEN, Card.suit.SPADES),
            new Card(Card.value.JACK, Card.suit.SPADES),
            new Card(Card.value.QUEEN, Card.suit.SPADES),
            new Card(Card.value.KING, Card.suit.SPADES),
            new Card(Card.value.ACE, Card.suit.SPADES)
        };
    }

    public Card dealCard()
    {
        try
        {
            Card card = m_cards[m_index];
            m_cards[m_index] = null;
            m_index++;
            return card;
        }
        catch (IndexOutOfBoundsException e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    public int cardsLeft()
    {
        return DECK_SIZE - m_index;
    }

    public void shuffle()
    {
        Random rand = new Random();
        m_shuffle(m_cards, DECK_SIZE, rand);
    }

    private void m_shuffle(Card[] cards, int n, Random r)
    {
        if (n == 0)
        {
            return;
        } else
        {
            m_shuffle(cards, n - 1, r);
            int i = r.nextInt(n - 1);
            Card temp = cards[i];
            cards[i] = cards[n - 1];
            cards[n - 1] = temp;
        }
    }
}

