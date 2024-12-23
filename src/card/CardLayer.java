package card;

import java.util.ArrayList;
import javax.swing.JLayeredPane;

import main.MainFrame;

public class CardLayer extends JLayeredPane{
	public ArrayList<Card> cardInHand = new ArrayList<Card>();
	
	private final int MAX_NUMBER_IN_HAND = 8;
	
	private int numberCardInHand = 0;
	
	public int getNumberCardInHand() {
		return this.numberCardInHand;
	}
	
	public CardLayer() {
		setBounds(0, 0, 1152, 648);
		setLayout(null);
		setOpaque(false);
		setVisible(true);
	}
	
	public void drawCard(Card card) {
		
        cardInHand.add(card);
        numberCardInHand++;
        this.add(cardInHand.get(cardInHand.size()-1), Integer.valueOf(0));
        card.isUsedInGame = true;
        MainFrame.sound.playSFX(2);
        animationAddCard();
        this.sortCard();
        if(cardInHand.size() > MAX_NUMBER_IN_HAND ) {
            discard(card);
        }
	}
	
	public void discard(Card card) {
        animationDiscard(card);
        card.isUsedInGame = false;
        this.remove(card);
        cardInHand.remove(card);
        numberCardInHand--;
        this.sortCard();
	}
	
	public void useCard(Card card) {
        animationUseCard(card);
        this.remove(card);
        cardInHand.remove(card);
        card.setImageSmall();
        numberCardInHand--;
        this.sortCard();
    }
	
	public void clearHand() {
        while(cardInHand.size()>0) {
            discard(cardInHand.get(cardInHand.size()-1));
        }
        this.repaint();
    }
	
	public void sortCard() {
        for(int i=0; i < cardInHand.size(); i++) {
        	cardInHand.get(i).setCx(300 + i*72);
        	cardInHand.get(i).setCy(360);
        	cardInHand.get(i).setLocation(cardInHand.get(i).getCx(), cardInHand.get(i).getCy());
        	this.setLayer(cardInHand.get(i), Integer.valueOf(i));
        }
        this.repaint();
    }
	
	private void animationAddCard() {
		//Set up
		int l = cardInHand.size() - 1;
		int cx = 984;
		cardInHand.get(l).setCy(360);
		cardInHand.get(l).setCx(cx);
		//Ani
		double delta = 0;
		long lastTime = System.nanoTime();
		double drawInterval = 1000000000/60;
		
		while(true) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			if(delta >= 1) {
				if(cx > (300 + l*72)) {
					cx -= 36;
					cardInHand.get(l).setCx(cx);
					cardInHand.get(l).setLocation(cardInHand.get(l).getCx(), cardInHand.get(l).getCy());
					cardInHand.get(l).updateCard();
					
				} else {
					sortCard();
					return;
				}
				delta--;
			}
		}
	}
	
	private void animationDiscard(Card card) {
		//Set up
		int cy = 360;
		//Ani
		double delta = 0;
		long lastTime = System.nanoTime();
		double drawInterval = 1000000000/60;
		
		while(true) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			if(delta >= 1) {
				if(cy < 648) {
					cy += 30;
					card.setCy(cy);
					card.setLocation(card.getCx(), card.getCy());
					card.updateCard();
					
				} else {
					return;
				}
				delta--;
			}
		}
	}
	
	private void animationUseCard(Card card) {
		//Set up
		boolean rv = true;
		int cy = 0;
		//Ani
		double delta = 0;
		long lastTime = System.nanoTime();
		double drawInterval = 1000000000/60;
		
		while(true) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			if(delta >= 1) {
				if(rv) {
					cy += 4;
					card.setCy(cy);
					card.setLocation(card.getCx(), card.getCy());
					card.updateCard();
					if(cy == 52) rv = false;
				}else if(cy > -240) {
					cy -= 30;
					card.setCy(cy);
					card.setLocation(card.getCx(), card.getCy());
					card.updateCard();
				}else {
					return;
				}
				delta--;
			}
		}
	}
}
