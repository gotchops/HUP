package hup.gamelogic;

public class HighCard extends Rank
{   
    public HighCard(Card.value value)
    {
        this.m_category = category.HIGH_CARD;
        m_value = value;
    }

    @Override
    public int compareTo(Rank other)
    {
        if (other.getCategory() == category.HIGH_CARD)
        {
            return this.getValue().compareTo(other.getValue());
        }
        else
        {
            return super.compareTo(other);
        }
    }
}

