package hup.gamelogic;

public class StraightFlush extends Rank
{
    public StraightFlush(Card.value value)
    {
        m_category = category.STRAIGHT_FLUSH;
        m_value = value;
    }

    @Override
    public int compareTo(Rank other)
    {
        if (this.getCategory() == other.getCategory())
        {
            return this.getValue().compareTo(other.getValue());
        }
        else
        {
            return super.compareTo(other);
        }
    }
}
