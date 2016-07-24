package hup.gamelogic;

public class TwoPair extends Rank {
	Card.value m_secondValue;
    Card.value m_kicker;

    public TwoPair(Card.value val1, Card.value val2, Card.value kicker)
    {
        m_category = category.TWO_PAIR;
        if (val1.compareTo(val2) > 0)
        {
            m_value = val1;
            m_secondValue = val2;
        }
        else
        {
            m_value = val2;
            m_secondValue = val1;
        }
        m_kicker = kicker;
    }

    public Card.value getSecondValue()
    {
        return m_secondValue;
    }

    public Card.value getKicker()
    {
        return m_kicker;
    }

    @Override
    public int compareTo(Rank other)
    {
        if (other.getCategory() == category.TWO_PAIR)
        {
            if (this.getValue() == other.getValue())
            {
                if (this.getSecondValue() == ((TwoPair) other).getSecondValue())
                {
                    return this.getKicker().compareTo(((TwoPair) other).getKicker());
                }
                return this.getSecondValue().compareTo(((TwoPair) other).getSecondValue());
            }
            return this.getValue().compareTo(other.getValue());
        }
        else
        {
            return super.compareTo(other);
        }
    }
}
