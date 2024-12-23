package dice;

import java.util.ArrayList;
import javax.swing.JLayeredPane;

import main.MainFrame;
import main.MainGame;

public class DiceLayer extends JLayeredPane{
	
	public ArrayList<Dice> diceBag;
	
	public int diceNumber;
	
	public int getDiceNumber() {
		return this.diceNumber;
	}
	
	
	public DiceLayer() {
		diceBag = new ArrayList<Dice>();
				
		setBounds(0, 0, 1152, 648);
		setLayout(null);
		setOpaque(false);
		setVisible(true);
	}
	
	public void rollDice() {
		for(int i=0; i < 6; i++) {
			addDice();
		}
		diceNumber = diceBag.size();
		this.sortDice();
		
	}
	
	public void clearDice() {
		animationClearDice();
		while(diceBag.size()>0) {
			throwDice(diceBag.get(diceBag.size()-1));
		}
		this.repaint();
	}
	
	public void addDice() {
		diceBag.add(new Dice(diceBag.size()));
		this.add(diceBag.get(diceBag.size() - 1), Integer.valueOf(0)); 
		animationAddDice();
		this.sortDice();
	}
	public void addDice(int diceValue) {
		diceBag.add(new Dice(diceBag.size(), diceValue));
		this.add(diceBag.get(diceBag.size() - 1), Integer.valueOf(0));
		animationAddDice();
		this.sortDice();
	}
	public void addDice(char specialValue) {
		diceBag.add(new Dice(diceBag.size(), specialValue));
		this.add(diceBag.get(diceBag.size() - 1), Integer.valueOf(0));
		animationAddDice();
		this.sortDice();
	}
	
	public void throwDice(Dice dice) {
		this.remove(dice);
		diceBag.remove(dice);
		this.sortDice();
	}
	
	public void sortDice() {
        for(int i=0; i < diceBag.size(); i++) {
            diceBag.get(i).setDx((i/3*2)*30 + (i/3+2)*15);
            diceBag.get(i).setDy((i%3*2)*30 + (i%3)*15 + 360);
            diceBag.get(i).setLocation(diceBag.get(i).getDx(), diceBag.get(i).getDy());
        }
        this.repaint();
    }
	
	private void animationAddDice() {
		//Set up
		int l = diceBag.size() - 1;
		int dx = -50;
		diceBag.get(l).setDy((l%3*2)*30 + (l%3)*15 + 360);
		diceBag.get(l).setDx(dx);
		//Ani
		double delta = 0;
		long lastTime = System.nanoTime();
		double drawInterval = 1000000000/60;
		
		while(true) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			if(delta >= 1) {
				if(dx < ((l/3*2)*30 + (l/3+2)*15)) {
					dx += 10;
					diceBag.get(l).setDx(dx);
					diceBag.get(l).setLocation(diceBag.get(l).getDx(), diceBag.get(l).getDy());
					diceBag.get(l).updateDice();
					
				} else {
					sortDice();
					return;
				}
				
				delta--;
			}
		}
	}
	
	private void animationClearDice() {
		//Set up
		if(diceBag.size() > 0) {

			int dy[] = new int[diceBag.size()];
			for(int i=0; i<diceBag.size(); i++) {
				dy[i] =(i%3*2)*30 + (i%3)*15 + 360;
			}
			
			//Ani
			double delta = 0;
			long lastTime = System.nanoTime();
			double drawInterval = 1000000000/60;
			
			while(true) {
				long currentTime = System.nanoTime();
				delta += (currentTime - lastTime) / drawInterval;
				lastTime = currentTime;
				if(delta >= 1) {
					for(int i=0; i<diceBag.size(); i++) {
						if(dy[i] < 1000) {
							dy[i] += 10;
							
							diceBag.get(i).setDy(dy[i]);
							diceBag.get(i).setLocation(diceBag.get(i).getDx(), diceBag.get(i).getDy());
							diceBag.get(i).updateDice();
							
						}else {
							return;
						}
					}
					delta--;
				}
			}	
		}
	}
	
}
