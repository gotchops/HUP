package hup.gamelogic;

public class Quads extends Rank {
	public Quads(Card.value value)
    {
        m_category = category.QUADS;
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
