package hup.gamelogic;

public class Flush extends Rank {
    public Flush(Card.value val)
    {
        m_category = category.FLUSH;
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
