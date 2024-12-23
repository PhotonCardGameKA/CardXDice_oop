package card;

import javax.swing.*;
import java.awt.Graphics;
import java.util.*;

public class Deck extends JPanel{
	
	ImageIcon deckIcon = new ImageIcon(Deck.class.getResource("/sprite/Card/Deck.png"));
	private int x = 960;
	private int y = 360;
	
	public ArrayList<Card> cards = new ArrayList<Card>();
	public ArrayList<Integer> check = new ArrayList<Integer>();
	
	public Stack<Card> Deck = new Stack<Card>();
	public Stack<Card> deckInGame = new Stack<Card>();
	public Stack<Integer> Check = new Stack<Integer>();
	
	public int deckSize = 30;
	public int countcard = 0 ;
	
	public Deck(){
		this.setLocation(x,y);
		this.setSize(deckIcon.getIconWidth(),deckIcon.getIconHeight());
		this.setOpaque(false);
		this.setVisible(true);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		deckIcon.paintIcon(this, g, 0, 0);
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
		this.Deck.push(card);
		this.countcard++;
	}
	
	public void shuffle() {
		for (int i=0;i<cards.size();i++)
		{
			this.check.add(i);
			this.Check.push(i);
		}
		Collections.shuffle(cards);
		Collections.shuffle(check);
		for (int i=0;i<cards.size();i++){
			this.Deck.pop();
			this.Check.pop();
		}
		for (int i=0;i<cards.size();i++){
			this.Deck.push(cards.get(i));
			this.Check.push(check.get(i));
		}
		
	}
	
	public Card drawFromDeck() {
		Card topcard;
		topcard = this.Deck.pop();
		cards.remove(cards.size()-1);
		return topcard;
	}
}
