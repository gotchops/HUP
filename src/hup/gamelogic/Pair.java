package hup.gamelogic;

public class Pair extends Rank {
	Card.value m_kicker;

    public Pair(Card.value value, Card.value kicker)
    {
        m_category = category.PAIR;
        m_value = value;
        m_kicker = kicker;
    }

    public Card.value getKicker()
    {
        return m_kicker;
    }

    @Override
    public int compareTo(Rank other)
    {
        if (other.getCategory() == category.PAIR)
        {
            if (this.getValue() == other.getValue())
            {
                return this.getKicker().compareTo(((Pair) other).getKicker());
            }
            return this.getValue().compareTo(other.getValue());
        }
        else
        {
            return super.compareTo(other);
        }
    }
}
