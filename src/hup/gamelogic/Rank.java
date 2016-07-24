package hup.gamelogic;

public abstract class Rank implements Comparable<Rank> {
	protected category m_category;
    protected Card.value m_value;

    public enum category
    {
        HIGH_CARD, PAIR, TWO_PAIR, TRIPS,
        STRAIGHT, FLUSH, FULL_HOUSE, QUADS, STRAIGHT_FLUSH
    }

    public category getCategory()
    {
        return m_category;
    }

    public Card.value getValue()
    {
        return m_value;
    }

    @Override
    public int compareTo(Rank other)
    {
    	return this.getCategory().compareTo(other.getCategory());
    }
}
