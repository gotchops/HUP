package hup.gamelogic;

public class Community {
	Card[] m_cards;

    public Community(Card c0, Card c1, Card c2)
    {
        Card[] m_cards = new Card[5];
        m_cards[0] = c0;
        m_cards[1] = c1;
        m_cards[2] = c2;
        m_cards[3] = null;
        m_cards[4] = null;
    }

    public Card[] getFlop()
    {
        return new Card[] { m_cards[0], m_cards[1], m_cards[2] };
    }

    public void setTurn(Card c)
    {
        m_cards[3] = c;
    }

    public Card getTurn()
    {
        return m_cards[3];
    }

    public void setRiver(Card c)
    {
        m_cards[4] = c;
    }

    public Card getRiver()
    {
        return m_cards[4];
    }
}
