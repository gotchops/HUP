package hup.gamelogic;

public class Straight extends Rank {
    public Straight(Card.value val)
    {
        m_category = category.STRAIGHT;
        m_value = val;
    }

    @Override
    public int compareTo(Rank other)
    {
        if (other.getCategory() == this.getCategory())
        {
            return this.getValue().compareTo(other.getValue());
        }
        else
        {
            return super.compareTo(other);
        }
    }
}
