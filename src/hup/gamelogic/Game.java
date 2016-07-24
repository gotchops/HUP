package hup.gamelogic;

import java.util.Random;

import model.network.Client;
import model.network.Server;

public class Game {
	private Player.which m_turn = Player.which.P1;	
	private int m_bbSize;
	private int m_smSize;
	private Player m_player1;
	private Player m_player2;
	
	public Game(int startCash, int bbSize) {
		m_player1 = new Player(Player.which.P1, startCash);
		m_player2 = new Player(Player.which.P2, startCash);
		
		m_bbSize = bbSize;
		m_smSize = bbSize / 2;
		
		m_startGame();
	}
	
	private void m_startGame() {
		Random r = new Random();
		if (r.nextInt(1) == 0) {
			m_turn = Player.which.P1;
			m_player1.makeDealer(true);
			m_player2.makeDealer(false);
		} else {
			m_turn = Player.which.P2;
			m_player1.makeDealer(false);
			m_player2.makeDealer(true);
		}
		
		
	}
	
	public void changeTurn() {
		if (m_turn == Player.which.P1) {
			m_turn = Player.which.P2;
			if (m_player1.isDealer()) {
				m_player1.makeDealer(false);
				m_player2.makeDealer(true);
			} else {
				m_player1.makeDealer(true);
				m_player2.makeDealer(false);
			}
		} else {
			m_turn = Player.which.P1;
			if (m_player1.isDealer()) {
				m_player1.makeDealer(false);
				m_player2.makeDealer(true);
			} else {
				m_player1.makeDealer(true);
				m_player2.makeDealer(false);
			}
		}
	}
	
	public void doubleBlinds() {
		m_bbSize *= 2;
		m_smSize *= 2;
	}

}
