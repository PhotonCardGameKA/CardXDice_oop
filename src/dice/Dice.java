package dice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dice extends JPanel implements MouseListener, MouseMotionListener{
	private int diceValue;
	private char specialValue = 'n';
	private int diceType = 0;
	
	private ImageIcon diceIcon;
	private ImageIcon diceOn;
	private ImageIcon diceOff;
	
	private Point diceCorner = new Point(0,0);
	private Point prevPt;
	private Point currentPt;
	
	private int x;
	private int y;
	private int dx = -100;
	private int dy = -100;
	
	private int diceID;
	
	private static boolean enable = false;
	private boolean selected = false;
	private boolean isUsed = false;
	public boolean isWaitingToUse = false;
	
	
	public int typeDice() {
		return this.diceType;
	}
	public int getDiceValue() {
		return this.diceValue;
	}
	public void setDiceValue(int a) {
		this.diceValue = a;
	}
	
	// set location
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
		x = dx;
	}
	public int getDy() {
		return dy;
	}
	public void setDy(int dy) {
		this.dy = dy;
		y = dy;
	}
	
	// for listener
	public boolean getSelected() {
		return this.selected;
	}
	public boolean getIsUsed() {
		return this.isUsed;
	}
	public void setIsUsed(boolean a) {
		this.isUsed = a;
	}
	public static boolean isEnable() {
		return enable;
	}
	public static void setEnable(boolean enable) {
		Dice.enable = enable;
	}
	
	//Constructor
	public Dice(int diceID){
		this.diceID = diceID;
		diceValue = (int)((Math.random()*19)/3);
		this.setDiceImage();
		this.commonConstructor();
	}
	public Dice(int diceID, int diceValue) {
		this.diceID = diceID;
		this.diceValue = diceValue;
		this.setDiceImage();
		this.commonConstructor();
	}
	public Dice(int diceID, char specialValue) {
		this.diceID = diceID;
		this.specialValue = specialValue;
		this.setDiceImage();
		this.diceValue = 6;
		this.commonConstructor();
	}
	
	public void commonConstructor() {
		diceIcon = diceOff;
		this.setLocation(dx, dy);
		this.setSize(diceIcon.getIconWidth(),diceIcon.getIconHeight());
		this.setOpaque(false);
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		this.setOpaque(false);
		this.setVisible(true);
	}
	public void setDiceImage() {
		switch (diceValue) {
			case 0: diceOn = new ImageIcon(Dice.class.getResource("/sprite/Dice/onDice0.png"));
					diceOff = new ImageIcon(Dice.class.getResource("/sprite/Dice/offDice0.png"));
					break;
			case 1: diceOn = new ImageIcon(Dice.class.getResource("/sprite/Dice/onDice1.png"));
					diceOff = new ImageIcon(Dice.class.getResource("/sprite/Dice/offDice1.png"));
					break;
			case 2: diceOn = new ImageIcon(Dice.class.getResource("/sprite/Dice/onDice2.png"));
					diceOff = new ImageIcon(Dice.class.getResource("/sprite/Dice/offDice2.png"));
					break;
			case 3: diceOn = new ImageIcon(Dice.class.getResource("/sprite/Dice/onDice3.png"));
					diceOff = new ImageIcon(Dice.class.getResource("/sprite/Dice/offDice3.png"));
					break;
			case 4: diceOn = new ImageIcon(Dice.class.getResource("/sprite/Dice/onDice4.png"));
					diceOff = new ImageIcon(Dice.class.getResource("/sprite/Dice/offDice4.png"));
					break;
			case 5: diceOn = new ImageIcon(Dice.class.getResource("/sprite/Dice/onDice5.png"));
					diceOff = new ImageIcon(Dice.class.getResource("/sprite/Dice/offDice5.png"));
					break;
			case 6: if((int)((Math.random()*2)+1) == 2){
						specialValue = 'g';
					}else {
						specialValue = 's';
					}
					break;
		}
		switch (specialValue) {
			case 'g':
				diceOn = new ImageIcon(Dice.class.getResource("/sprite/Dice/onDiceGold.png"));
				diceOff = new ImageIcon(Dice.class.getResource("/sprite/Dice/offDiceGold.png"));
				diceType = 1;
				break;
			case 's':
				diceOn = new ImageIcon(Dice.class.getResource("/sprite/Dice/onDiceSilver.png"));
				diceOff = new ImageIcon(Dice.class.getResource("/sprite/Dice/offDiceSilver.png"));
				diceType = 2;
				break;
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		diceIcon.paintIcon(this, g, 0, 0);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
			
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(enable) {
			prevPt = e.getPoint();
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if(enable) {
			selected = false;
			if(((dx > 330) && (dx < 750)) && ((dy > -10) && (dy < 220))) {
				isWaitingToUse = true;
			}
			if(!isUsed) {
				this.setLocation(x, y);
				dx = x;
				dy = y;
			}
			repaint();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(enable) {
			diceIcon = diceOn;
			repaint();
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(enable) {
			diceIcon = diceOff;
			repaint();
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(enable) {
			selected = true;
			currentPt = e.getPoint();
			isWaitingToUse = false;
			diceCorner.translate(
					currentPt.x - prevPt.x,
					currentPt.y - prevPt.y
					);
			dx += diceCorner.x;
			dy += diceCorner.y;
			prevPt = currentPt;
			this.setLocation(dx,dy);
			repaint();
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
	public void updateDice() {
		repaint();
	}
	

}