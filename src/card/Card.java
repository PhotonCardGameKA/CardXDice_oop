package card;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public abstract class Card extends JPanel implements MouseListener, MouseMotionListener{
	
	ImageIcon cardImage = new ImageIcon(Card.class.getResource("/sprite/Card/CardBack.png"));
	ImageIcon smallCardImage;
	ImageIcon bigCardImage;
	Point cardCorner;
	
	protected final int COUNTER_CARD = 0;
	protected final int DICE_CARD = 1;
	
	public int layerNumber = 0;
	
	private int x;
	private int y;
	private int cx = 984;
	private int cy = 360;
	
	
	public int type;
	public boolean needDiscard = false;
	public boolean needThrow = false;
	public boolean needDraw = false;
	public boolean needRoll = false;
	public boolean needAttack = false;
	public boolean needHeal = false;
	public boolean needShield = false;
	public boolean needHurt = false;
	public boolean isUseDiceInTurn = false;
	public boolean isUseCardInTurn = false;
	
	private int amountDiscard = 0;
	private int scaleAmountDiscard1 = 1;
	private int scaleAmountDiscard2 = 0;
	
	private int amountThrow = 0;
	private int scaleAmountThrow1 = 1;
	private int scaleAmountThrow2 = 0;
	
	private int amountDraw = 0;
	private int scaleAmountDraw1 = 1;
	private int scaleAmountDraw2 = 0;
	
	private int amountRoll = 0;
	private int scaleAmountRoll1 = 1;
	private int scaleAmountRoll2 = -1;
	private int scaleAmountRoll3 = 0;
	private int scaleAmountRoll4 = 0;
	
	private int amountAttack = 0;
	private int scaleAmountAttack1 = 1;
	private int scaleAmountAttack2 = 0;
	
	private int amountHeal = 0;
	private int scaleAmountHeal1 = 1;
	private int scaleAmountHeal2 = 0;
	
	private int amountShield = 0;
	private int scaleAmountShield1 = 1;
	private int scaleAmountShield2 = 0;
	
	private int amountHurt = 0;
	private int scaleAmountHurt1 = 1;
	private int scaleAmountHurt2 = 0;
	
	
	private boolean isUsed = false;
	private static boolean isListened = false;
	public static boolean isAlreadyUsed = false;
	private static boolean letSort = false;
	public boolean isDrag = false;
	public boolean isUsedInGame = false;
    public static boolean isInDeckList = false;
    public boolean isAddToDeck = false;
    public boolean isAddedToDeck = false;
    public boolean isWaitingToRemove = false;
    public boolean isEnter = false;
    private int conditionMax = 5;
	private int conditionMin = 0;
	
	private int cardID;
	public String cardTxt;
	
	
	public int getCardID() {
		return cardID;
	}
	public void setCardID(int id) {
		cardID = id;
	}
	
	// set Image
    public void setCardImage(ImageIcon small, ImageIcon big) {
    	smallCardImage = small;
    	bigCardImage = big;
    	cardImage = smallCardImage;
    	repaint();
    }
    
    // set and check condition
	public int getConditionMax() {
		return conditionMax;
	}
	public int getConditionMin() {
		return conditionMin;
	}
	public void setCardCondition(int conditionMin, int conditionMax) {
		this.conditionMin = conditionMin;
		this.conditionMax = conditionMax;
	}
	
	// set location
    public int getCx() {
		return cx;
	}
	public void setCx(int cx) {
		this.cx = cx;
		x = cx;
	}
	public int getCy() {
		return cy;
	}
	public void setCy(int cy) {
		this.cy = cy;
		y = cy;
	}
	
	
	// for listener
	public static boolean isAlreadyUsed() {
		return isAlreadyUsed;
	}
	public static void setAlreadyUsed(boolean isAlreadyUsed) {
		Card.isAlreadyUsed = isAlreadyUsed;
	}
    public boolean getIsUsed() {
    	return this.isUsed;
    }
    public void setIsUsed(boolean isUsed) {
    	this.isUsed = isUsed;
    }
    public boolean getIsListened() {
    	return Card.isListened;
    }
    public static void setIsListened(boolean a) {
    	Card.isListened = a;
    }
    public static boolean isLetSort() {
		return letSort;
	}
	public static void setLetSort(boolean letSort) {
		Card.letSort = letSort;
	}
	
	// for action
	public int getAmountDiscard() {
		return amountDiscard;
	}
	public void setAmountDiscard(int amountDiscard) {
		this.amountDiscard = this.scaleAmountDiscard1*amountDiscard + this.scaleAmountDiscard2;
	}
	public void setScaleDiscard(int s1, int s2) {
		this.scaleAmountDiscard1 = s1;
		this.scaleAmountDiscard2 = s2;
	}
	
	public int getAmountThrow() {
		return amountThrow;
	}
	public void setAmountThrow(int amountThrow) {
		this.amountThrow = this.scaleAmountThrow1*amountThrow + this.scaleAmountThrow2;
	}
	public void setScaleThrow(int s1, int s2) {
		this.scaleAmountThrow1 = s1;
		this.scaleAmountThrow2 = s2;
	}
	
	public int getAmountDraw() {
		return amountDraw;
	}
	public void setAmountDraw(int amountDraw) {
		this.amountDraw = this.scaleAmountDraw1*amountDraw + this.scaleAmountDraw2;
	}
	public void setScaleDraw(int s1, int s2) {
		this.scaleAmountDraw1 = s1;
		this.scaleAmountDraw2 = s2;
	}
	
	public int getAmountRollDice1() {
		return this.scaleAmountRoll1;
	}
	public void setAmountRoll(int amountRoll) {
		this.amountRoll = this.scaleAmountRoll1;
	}
	public void setValueRoll1(int valueRoll) {
		scaleAmountRoll2 = valueRoll;
	}
	public int getDiceAtValue1() {
		return scaleAmountRoll2;
	}
	public void setScaleRoll(int s1, int s2, int s3, int s4) {//0-5 dice 0-5; 6-g 7-s -1-random -2 dice mimic
		this.scaleAmountRoll1 = s1;
		this.scaleAmountRoll2 = s2;
		this.scaleAmountRoll3 = s3;
		this.scaleAmountRoll4 = s4;
	}
	
	public int getAmountAttack() {
		return amountAttack;
	}
	public void setAmountAttack(int amountAttack) {
		this.amountAttack = this.scaleAmountAttack1*amountAttack + this.scaleAmountAttack2;
	}
	public void setScaleAttack(int s1, int s2) {
		this.scaleAmountAttack1 = s1;
		this.scaleAmountAttack2 = s2;
	}
	
	public int getAmountHeal() {
		return amountHeal;
	}
	public void setAmountHeal(int amountHeal) {
		this.amountHeal = this.scaleAmountHeal1*amountHeal + this.scaleAmountHeal2;
	}
	public void setScaleHeal(int s1, int s2) {
		this.scaleAmountHeal1 = s1;
		this.scaleAmountHeal2 = s2;
	}
	
	public int getAmountShield() {
		return amountShield;
	}
	public void setAmountShield(int amountShield) {
		this.amountShield = this.scaleAmountShield1*amountShield + this.scaleAmountShield2;
	}
	public void setScaleShield(int s1, int s2) {
		this.scaleAmountShield1 = s1;
		this.scaleAmountShield2 = s2;
	}
	
	public int getAmountHurt() {
		return amountHurt;
	}
	public void setAmountHurt(int amountHurt) {
		this.amountHurt = this.scaleAmountHurt1*amountHurt + this.scaleAmountHurt2;
	}
	public void setScaleHurt(int s1, int s2) {
		this.scaleAmountHurt1 = s1;
		this.scaleAmountHurt2 = s2;
	}
	
	// Constructor
	public Card() {
		this.setLocation(cx, cy);
		this.setSize(cardImage.getIconWidth(),cardImage.getIconHeight());
		this.setLayout(null);
		this.setOpaque(false);
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		cardImage.paintIcon(this, g, 0, 0);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(isListened) {
			if(isUsed) {
				if(isAlreadyUsed) {
					isAlreadyUsed = false;
					letSort = true;
				}
				isUsed = false;
				layerNumber = 10;
				this.setLocation(cx,cy);
				cardImage = smallCardImage;
				this.setSize(cardImage.getIconWidth(),cardImage.getIconHeight());
				repaint();
			}
			
		}
		if(isInDeckList) {
			if(!isAddedToDeck) {
				if(!isAddToDeck) {
					isAddToDeck = true;
				}
			}
			if(isAddedToDeck) {
				isWaitingToRemove = true;
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if(isListened) {
			layerNumber = 0;
			if(!isAlreadyUsed) {
				if(((cx<=840)&&(cx>=300))&&((cy>=0)&&(cy<180))) {
					isUsed = true;
					layerNumber = 11;
					cx=360;
					cy=0;
					cardImage = bigCardImage; // big
					this.setSize(cardImage.getIconWidth(),cardImage.getIconHeight());
					this.setLocation(cx, cy);
					isAlreadyUsed = true;
				}else {
					cardImage = smallCardImage; // smsall
					this.setSize(cardImage.getIconWidth(),cardImage.getIconHeight());
					this.setLocation(x, y);
					cx = x;
					cy = y;
					isUsed = false;
				}
			}else {
				
				cardImage = smallCardImage; // smsall
				this.setSize(cardImage.getIconWidth(),cardImage.getIconHeight());
				this.setLocation(x, y);
				cx = x;
				cy = y;
				isUsed = false;
			}
			repaint();
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(isListened) {
			if(!isUsed) {
				layerNumber = 0;
				cy = cy-60;
				this.setLocation(cx, cy);
			}
			repaint();
		}
		
		if(isInDeckList) {
			isEnter = true;
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(isListened) {
			if(!isUsed) {
				layerNumber = 0;
				cy = 360;
				this.setLocation(cx, cy);
			}
			repaint();
		}
		if(isInDeckList) {
			isEnter = false;
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	public void mouseDragged(MouseEvent e) {
		if(isListened) {
			if(!isAlreadyUsed) {
				isUsed = false;
				layerNumber = 10;
				cardCorner = e.getPoint();
				cx+=(cardCorner.x-cardImage.getIconWidth()/2);
				cy+=(cardCorner.y-cardImage.getIconHeight()/2);
				this.setLocation(cx,cy);
				this.setSize(cardImage.getIconWidth(),cardImage.getIconHeight());
				repaint();
			}
			
		}
	}
	
	public void actionCard(boolean dc, boolean td, boolean dr, boolean rl, boolean atk, boolean hl, boolean shd, boolean ht) {
		this.needDiscard = dc;
		this.needThrow = td;
		this.needDraw = dr;
		this.needRoll = rl;
		this.needAttack = atk;
		this.needHeal = hl;
		this.needShield = shd;
		this.needHurt = ht;
	}
	
	public void updateCard() {
		repaint();
	}
	
	public void setImageSmall() {
		cardImage = smallCardImage;
		this.setSize(cardImage.getIconWidth(),cardImage.getIconHeight());
		repaint();
	}

	


	
	
}

