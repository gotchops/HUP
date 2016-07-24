package hup.gamelogic;

public class Player {		
	public enum action {
		FOLDED, BET, RAISED, CHECKED
	}
	
	public enum which { P1, P2 };
	
	private which m_which;
	private boolean m_isDealer = false;
	private Hand m_hand;
	private int m_cash;
	private action m_action;

	public Player(which w, int cash) {
		m_which = w;
		m_cash = cash;
	}
	
	public void setHand(Hand hand) {
		m_hand = hand;
	}
	
	public Hand getHand() {
		return m_hand;
	}
	
	public which whichPlayer() {
		return m_which;
	}
	
	public void addCash(float amount) {
		m_cash += amount;
	}
	
	public void subtractCash(float amount) {
		if (m_cash - amount < 0) {
			m_cash = 0;
		} else {
			m_cash -= amount;
		}
	}
	
	public float getCash() {
		return m_cash;
	}
	
	public void makeDealer(boolean b) {
		m_isDealer = b;
	}
	
	public boolean isDealer() {
		return m_isDealer;
	}
	
	public action getAction() {
		return m_action;
	}
	
	public void fold() {
		m_action = action.FOLDED;
	}
	
	public void check() {
		m_action = action.CHECKED;
	}
	
	public float bet(float amount) {
		m_action = action.BET;
		subtractCash(amount);
		return amount;
	}
	
	public float raise(float amount) {
		m_action = action.RAISED;
		subtractCash(amount);
		return amount;
	}
}
