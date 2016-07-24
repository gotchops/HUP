package hup.gamelogic;

public class FullHouse extends Rank {
    public FullHouse(Card.value value)
    {
        m_category = category.FULL_HOUSE;
        m_value = value;
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
