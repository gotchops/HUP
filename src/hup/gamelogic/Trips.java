package hup.gamelogic;

public class Trips extends Rank {
	
	
	public Trips(Card.value value)
    {
        m_category = category.TRIPS;
        m_value = value;
    }

	@Override
    public int compareTo(Rank other)
    {
        if (other.getCategory() == category.TRIPS)
        {
            return this.getValue().compareTo(other.getValue());
        }
        else
        {
            return super.compareTo(other);
        }
    }
}
