package main;


import dice.*;
import character.*;
import menu.DeckListPanel;
import menu.OptionPanel;
import phase.*;
import card.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class MainGame extends JPanel implements Runnable{
	
	public ArrayList<Card> cardUseInGame;
	
	ImageIcon win = new ImageIcon(MainGame.class.getResource("/sprite/PhaseBar/victory.png"));
	ImageIcon lose = new ImageIcon(MainGame.class.getResource("/sprite/PhaseBar/defeat.png"));
	ImageIcon endIn = new ImageIcon(MainGame.class.getResource("/sprite/Button/endIn.png"));
	ImageIcon endOut = new ImageIcon(MainGame.class.getResource("/sprite/Button/endOut.png"));
	ImageIcon endOn = new ImageIcon(MainGame.class.getResource("/sprite/Button/endOn.png"));
	
	JLabel loseImg;
	JLabel winImg;
	JLabel mainBG;
	JLabel diceBG;
	JPanel loseGame;
	JPanel winGame;
	
	EnemyMoveSet enemy;
	private int bossStack;
	
	private int diceInTurn;
	private int cardInTurn;
	private int dmgInTurn;
	
	private int numberCardLeft = 0;
	
	JTextField numberCard;
	JPanel numberCardPanel;
	
	public static JTextField shieldTxt;
	JPanel shieldPanel;
	
	Card cardTemp;
	Dice diceTemp;
	
	public static int shield = 0;
	
	GamePanel game;
	
	Deck deck;
	DeckListPanel deckList;
	
	CounterCard card5 = new CounterCard();
	
	CardLayer cardLayer = new CardLayer();
	DiceLayer diceLayer = new DiceLayer();
	
	public final int FPS = 60;
	private long lastTime;
	int sec;
	private long currentTime;
	
	boolean start = false;
	
	JLayeredPane layer = new JLayeredPane();
	
	private final int START_GAME = 1;
	//private final int DECK_LIST = 2;
	//private final int EXIT = 3;
	private final int MENU = 0;
	
	public int state = START_GAME;
	
	private final int STAND_BY = 0;
	private final int ROLL_PHASE = 1;
	private final int DRAW_PHASE = 2;
	private final int ACTION_PHASE = 3;
	private final int END_PHASE = 4;
	private final int ENERMY_PHASE = 5;
	private final int LOSE_GAME = 6;
	private final int WIN_GAME = 7;
	
	private int phase = 0;
	PhaseBar phaseBar;
	PhaseMessage phaseMessage;
	
	JButton endPhase;
	private boolean end = false;
	
	JButton exit;
	public static boolean isOn = false;
	
	private OptionPanel optionPanel;
	
	
	public MainGame() {
		
		optionPanel = new OptionPanel();
		
		shieldTxt = new JTextField("" + shield);
		shieldTxt.setSize(40, 30);
		shieldTxt.setLocation(0, 0);
		shieldTxt.setFont(new Font("Monospaced",Font.BOLD, 30));
		shieldTxt.setBackground(null);
		shieldTxt.setForeground(Color.WHITE);
		shieldTxt.setDisabledTextColor(Color.white);
		shieldTxt.setEnabled(false);
		shieldTxt.setOpaque(false);
		shieldTxt.setBorder(null);
		
		shieldPanel = new JPanel();
		shieldPanel.setSize(40, 30);
		shieldPanel.setLocation(230, 10);
		shieldPanel.add(shieldTxt);
		shieldPanel.setLayout(null);
		shieldPanel.setOpaque(false);
		
		cardUseInGame = new ArrayList<Card>();
		
		mainBG = new JLabel();
		mainBG.setIcon(new ImageIcon(MainGame.class.getResource("/background/backgroundMain.png")));
		mainBG.setBounds(0, 0, 1152, 648);
		
		diceBG = new JLabel();
		diceBG.setIcon(new ImageIcon(DiceLayer.class.getResource("/background/backgroundDice.png")));
		diceBG.setBounds(0, 270, 270, 340);
		
		winImg = new JLabel(win);
		winImg.setSize(win.getIconWidth(), win.getIconHeight());
		winImg.setLocation(300, 150);
		winImg.setOpaque(false);
		
		loseImg = new JLabel(lose);
		loseImg.setSize(lose.getIconWidth(), lose.getIconHeight());
		loseImg.setLocation(300, 150);
		loseImg.setOpaque(false);
		
		winGame = new JPanel();
		winGame.setSize(1152, 648);
		winGame.setLocation(0, 0);
		winGame.setBackground(new Color(0, 255, 255, 120));
		
		
		
		loseGame = new JPanel();
		loseGame.setSize(1152, 648);
		loseGame.setLocation(0, 0);
		loseGame.setBackground(new Color(255, 0, 0, 120));
		
		
		numberCard = new JTextField("" + 30);
		numberCard.setSize(40, 30);
		numberCard.setLocation(0, 0);
		numberCard.setFont(new Font("Monospaced",Font.BOLD, 20));
		numberCard.setBackground(null);
		numberCard.setForeground(Color.WHITE);
		numberCard.setEnabled(false);
		numberCard.setDisabledTextColor(Color.white);
		numberCard.setOpaque(false);
		numberCard.setBorder(null);
	
		numberCardPanel = new JPanel();
		numberCardPanel.setSize(40, 30);
		numberCardPanel.setLocation(1080, 370);
		numberCardPanel.add(numberCard);
		numberCardPanel.setLayout(null);
		numberCardPanel.setOpaque(false);
		
		endPhase = new JButton();
		endPhase.setIcon(endOut);
		endPhase.setRolloverIcon(endIn);
		endPhase.setPressedIcon(endOn);
		endPhase.setDisabledIcon(endOn);
		endPhase.setBounds(1000, 265, 120, 50);
		endPhase.setEnabled(false);
		endPhase.setContentAreaFilled(false);
		endPhase.setBorderPainted(false);
		endPhase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.sound.playSFX(0);
				end = true;
			}
		});
		
		shield = 0;
		
		deck = new Deck();
		
		game = new GamePanel();
	
		layer.setBounds(0, 0, 1152, 648);
		
		this.setSize(1152, 648);
		this.setLocation(0,0);
		this.setVisible(true);
		this.setLayout(null);
		
		phaseMessage = new PhaseMessage();
		
		phaseBar = new PhaseBar();
		
		exit = new JButton();
		exit.setSize(60, 60);
		exit.setLocation(105, 273);
		exit.setIcon(new ImageIcon(MainGame.class.getResource("/sprite/Button/optionOut.png")));
		exit.setRolloverIcon(new ImageIcon(MainGame.class.getResource("/sprite/Button/optionIn.png")));
		exit.setDisabledIcon(new ImageIcon(MainGame.class.getResource("/sprite/Button/optionOut.png")));
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setFocusable(false);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.sound.playSFX(0);
				Card.setIsListened(false);
				Dice.setEnable(false);
				layer.add(optionPanel, Integer.valueOf(20));	
			}			
		});
		
		layer.add(cardLayer, Integer.valueOf(3));
		layer.add(diceLayer, Integer.valueOf(3));
		layer.add(shieldPanel, Integer.valueOf(3));

		//new things here
		this.add(layer);
		this.add(exit);
		this.add(phaseBar);
		
		this.add(numberCardPanel);
		this.add(deck);
		this.add(game);
		this.add(phaseMessage);
		this.add(endPhase);
		this.add(diceBG);
		this.add(mainBG);
		
		enemy = new EnemyMoveSet(game);
	}
	
	Thread FrameThread;
	
	public void startGame() {
		FrameThread = new Thread(this);
		FrameThread.start();
		start = true;
	}
	
	
	public void stopGame() {
		start = false;
		Card.setIsListened(false);
		Dice.setEnable(false);
		while(!cardLayer.cardInHand.isEmpty()) {
			cardLayer.discard(cardLayer.cardInHand.get(cardLayer.cardInHand.size()-1));
		}
	}
	
	public void run() {
		exit.setEnabled(false);
		bossStack = 0;
		dmgInTurn = 0;
		diceInTurn = 0;
		cardInTurn = 0;
		MainFrame.sound.stopTrack();
		MainFrame.sound.playTrack(1);
		/*
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		lastTime = System.nanoTime();
		*/
		while(MainFrame.Deck.Deck.size() > 0) {
			
			deck.addCard(MainFrame.Deck.drawFromDeck());
		}
		
		deck.shuffle();
		
		numberCardLeft = deck.Deck.size();
		
		for(int i=0; i<4; i++) {
			cardLayer.drawCard(deck.drawFromDeck());
			cardUseInGame.add(cardLayer.cardInHand.get(i));
			numberCard.setText("" + deck.Deck.size());
		}
		
		cardLayer.repaint();
		this.repaint();
		sec = 0;
		while(start == true) {/*
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			if(delta >= 1) {*/
			
			
			if(optionPanel.isHome) {
				optionPanel.isHome = false;
				layer.remove(optionPanel);
				state = MENU;
			}
			if(optionPanel.isBack) {
				optionPanel.isBack = false;
				layer.remove(optionPanel);
				Card.setIsListened(true);
				Dice.setEnable(true);
			}
				switch (phase) {
				case STAND_BY:
					phaseBar.phaseSwitch(STAND_BY);
					if(phaseMessage.isDraw == false) {
						phaseMessage.drawPhaseMessage(STAND_BY);
					}
					phase = ROLL_PHASE;
					phaseMessage.isDraw = false;
					break;
					
				case ROLL_PHASE:
					
					dmgInTurn = 0;
					diceInTurn = 0;
					cardInTurn = 0;
					bossStack++;
					
					phaseBar.phaseSwitch(ROLL_PHASE);
					if(phaseMessage.isDraw == false) {
						phaseMessage.drawPhaseMessage(ROLL_PHASE);
						if(isOn) MainFrame.sound.playSFX(10);
						else MainFrame.sound.stopSFX();
					}
					roll_phase();
					phase = DRAW_PHASE;
					phaseMessage.isDraw = false;
					break;
					
				case DRAW_PHASE:
					exit.setEnabled(false);
					phaseBar.phaseSwitch(DRAW_PHASE);
					if(phaseMessage.isDraw == false) {
						phaseMessage.drawPhaseMessage(DRAW_PHASE);
						if(isOn) MainFrame.sound.playSFX(2);
						else MainFrame.sound.stopSFX();
					}
					draw_phase();
					if(phase != LOSE_GAME && phase != WIN_GAME) {
						phase = ACTION_PHASE;
					}
					phaseMessage.isDraw = false;
					exit.setEnabled(true);
					break;
					
				case ACTION_PHASE:
					phaseBar.phaseSwitch(ACTION_PHASE);
					if(phaseMessage.isDraw == false) {
						phaseMessage.drawPhaseMessage(ACTION_PHASE);	
					}
					endPhase.setEnabled(true);
					Card.setIsListened(true);
					Dice.setEnable(true);
					action_phase();	
					if(game.Enemy_Hp() <= 0) {
						Card.setIsListened(false);
						Dice.setEnable(false);
						
						phase = WIN_GAME;
					}
					if(game.Character_Hp() <= 0) {
						Card.setIsListened(false);
						Dice.setEnable(false);
						phase = LOSE_GAME;
					}
					if(dmgInTurn > 10 && bossStack >= 0) {
						bossStack--;
					}
					if(end) {
						Card.isAlreadyUsed = false;
						for(int i=0; i<cardLayer.cardInHand.size(); i++) {
							cardLayer.cardInHand.get(i).setIsUsed(false);
							cardLayer.cardInHand.get(i).setImageSmall();
						}
						cardLayer.sortCard();
						endPhase.setEnabled(false);
						phase = END_PHASE;
						end = false;
						phaseMessage.isDraw = false;
						Card.setIsListened(false);
						Dice.setEnable(false);
					}
					break;
					
				case END_PHASE:
					phaseBar.phaseSwitch(END_PHASE);
					if(phaseMessage.isDraw == false) {
						phaseMessage.drawPhaseMessage(END_PHASE);
					}
					phase = ENERMY_PHASE;
					phaseMessage.isDraw = false;
					break;
				
				case ENERMY_PHASE:
					phaseBar.phaseSwitch(ENERMY_PHASE);
					if(phaseMessage.isDraw == false) {
						phaseMessage.drawPhaseMessage(ENERMY_PHASE);
					}
					if(game.Enemy_Hp() > 70) {
						boss_phase();
					} else if(game.Enemy_Hp() > 40) {
						boss_phase();
						boss_phase();
					} else if(game.Enemy_Hp() > 0) {
						boss_phase();
						boss_phase();
						boss_phase();
					}
					if(game.Character_Hp() <= 0) {
						game.turn = 1;
						game.Die();
						phase = LOSE_GAME;
					}
					if(phase != LOSE_GAME && phase != WIN_GAME ) {
						phase = STAND_BY;
						phaseMessage.isDraw = false;
					}
					break;
					
				case LOSE_GAME:
					MainFrame.sound.stopTrack();
					defeat();
					state = MENU;
					break;
					
				case WIN_GAME:
					MainFrame.sound.stopTrack();
					victory();
					state = MENU;
					break;
				}
				
			//delta--;
			}
		}
	//}
		
	
	private void roll_phase() {
		diceLayer.clearDice();
		diceLayer.rollDice();
	}
	
	private void draw_phase() {
		if(deck.Deck.size() == 0) {
			phase = LOSE_GAME;
		} else {
			cardLayer.drawCard(deck.drawFromDeck());
			cardUseInGame.add(cardLayer.cardInHand.get(cardLayer.cardInHand.size()-1));
			numberCard.setText("" + deck.Deck.size());
		}
		if(deck.Deck.size() == 0) {
			phase = LOSE_GAME;
		} else {
			cardLayer.drawCard(deck.drawFromDeck());
			cardUseInGame.add(cardLayer.cardInHand.get(cardLayer.cardInHand.size()-1));
			numberCard.setText("" + deck.Deck.size());
		}
	}
	
	private void action_phase() {
		for(int i=0; i<diceLayer.diceBag.size(); i++) {
			//new things here
			if(diceLayer.diceBag.get(i).getSelected() == true) {
				diceLayer.setLayer(diceLayer.diceBag.get(i), Integer.valueOf(1));
				layer.moveToFront(diceLayer);
			}
			if(diceLayer.diceBag.get(i).getSelected() == false) {
				diceLayer.setLayer(diceLayer.diceBag.get(i), Integer.valueOf(0));
			}
		}
		
		for(int i=0; i<cardLayer.cardInHand.size(); i++) {
			if(Card.isLetSort()) {
				cardLayer.sortCard();
				Card.setLetSort(false); 
			}
		
			if(cardLayer.cardInHand.get(i).layerNumber == 10) {
				cardLayer.setLayer(cardLayer.cardInHand.get(i), Integer.valueOf(10));
				layer.moveToFront(cardLayer);
			}
			if(cardLayer.cardInHand.get(i).layerNumber == 0) {
				cardLayer.setLayer(cardLayer.cardInHand.get(i), Integer.valueOf(i));
			}
			if(cardLayer.cardInHand.get(i).getIsUsed()) {
				for(int j=0; j<diceLayer.diceBag.size(); j++) {
					if(diceLayer.diceBag.get(j).isWaitingToUse) {
						//DiceCard
						if(cardLayer.cardInHand.get(i).type == 1) {
							if(((DiceCard) cardLayer.cardInHand.get(i)).checkCondition(diceLayer.diceBag.get(j).getDiceValue())
									|| diceLayer.diceBag.get(j).getDiceValue() == 6) {
								diceLayer.diceBag.get(j).setIsUsed(true);
								cardLayer.cardInHand.get(i).setIsUsed(false);
								diceLayer.diceBag.get(j).isWaitingToUse = false;
								cardTemp = cardLayer.cardInHand.get(i);
								diceTemp = diceLayer.diceBag.get(j);
								diceLayer.throwDice(diceLayer.diceBag.get(j));
								cardLayer.useCard(cardLayer.cardInHand.get(i));
								action_DiceCard(cardTemp, diceTemp);
								Card.setAlreadyUsed(false);
								diceInTurn++;
								cardInTurn++;
							} else {
								diceLayer.diceBag.get(j).isWaitingToUse = false;
							}		
						}
						// End DiceCard
						
						//CounterCard
						else if(cardLayer.cardInHand.get(i).type == 0) {
							diceLayer.diceBag.get(j).setIsUsed(true);
							diceLayer.diceBag.get(j).isWaitingToUse = false;
							diceTemp = diceLayer.diceBag.get(j);
							diceLayer.throwDice(diceLayer.diceBag.get(j));
							((CounterCard)cardLayer.cardInHand.get(i)).decreaseCounter(diceTemp.getDiceValue());
							diceInTurn++;
							
							if(((CounterCard) cardLayer.cardInHand.get(i)).getCounterRemain() <= 0) {
								cardLayer.cardInHand.get(i).setIsUsed(false);
								cardTemp = cardLayer.cardInHand.get(i);
								cardLayer.useCard(cardLayer.cardInHand.get(i));
								action_CounterCard(cardTemp);
								Card.setAlreadyUsed(false);
								cardInTurn++;
							}
						}
						// End CounterCard
					}
				}
				
			}
		}
	}
	
	
	//CounterCard
	private void action_CounterCard(Card card) {
		if(card.needDiscard) {
			if(card.getAmountDiscard() > cardLayer.cardInHand.size()) {
				cardLayer.clearHand();
			} else {
				for(int i=0; i< card.getAmountDiscard(); i++) {
					int rad = (int)(Math.random()*cardLayer.cardInHand.size());
					cardLayer.discard(cardLayer.cardInHand.get(rad));
				}
			} 
			
			cardLayer.sortCard();	
		}
		
		if(card.needThrow) {
			if(diceLayer.diceBag.size()<card.getAmountThrow()) {
				for(int i=0; i< diceLayer.diceBag.size(); i++) {
					int rad = (int)(Math.random()*diceLayer.diceBag.size());
					diceLayer.throwDice(diceLayer.diceBag.get(rad));
				}
			} else {
				for(int i=0; i< card.getAmountThrow(); i++) {
					int rad = (int)Math.random()*diceLayer.diceBag.size();
					diceLayer.throwDice(diceLayer.diceBag.get(rad));
				}
			}
			
			diceLayer.sortDice();
			
		}
		
		if(card.needDraw) {
			for(int i=0; i<card.getAmountDraw(); i++) {
				if(deck.Deck.size() == 0) {
					phase = LOSE_GAME;
					return;
				} else {
					exit.setEnabled(false);
					cardLayer.drawCard(deck.drawFromDeck());
					cardUseInGame.add(cardLayer.cardInHand.get(cardLayer.cardInHand.size()-1));
					numberCard.setText("" + deck.Deck.size());
				}
			}
			cardLayer.sortCard();
			exit.setEnabled(true);
		}
		
		if(card.needRoll) {
			MainFrame.sound.playSFX(1);
			switch (card.getDiceAtValue1()){
			case -1:
				for(int i=0; i<card.getAmountRollDice1(); i++) {
					diceLayer.addDice();
				}
				break;
			case 6:
				for(int i=0; i<card.getAmountRollDice1(); i++) {
					diceLayer.addDice('g');
				}
				break;
			case 7:
				for(int i=0; i<card.getAmountRollDice1(); i++) {
					diceLayer.addDice('s');
				}
				break;
			default:
				for(int i=0; i<card.getAmountRollDice1(); i++) {
					diceLayer.addDice(card.getDiceAtValue1());
				}
			}
			diceLayer.sortDice();
			
		}
		
		if(card.needAttack) {
			int s = 0;
			if(card.isUseDiceInTurn) s+= diceInTurn;
			if(card.isUseCardInTurn) s+= cardInTurn;
			game.turn = 1;
			game.Run();
			game.Attack();
			game.Character_damage(card.getAmountAttack() + s);
			dmgInTurn += card.getAmountAttack();
			
		}
		
		if(card.needHeal) {
			MainFrame.sound.playSFX(6);
			int s = 0;
			if(card.isUseDiceInTurn) s+= diceInTurn;
			if(card.isUseCardInTurn) s+= cardInTurn;
			game.Enemy_damege(-card.getAmountHeal()-s);
			
		}
		
		if(card.needShield) {
			MainFrame.sound.playSFX(7);
			int s = 0;
			if(card.isUseDiceInTurn) s+= diceInTurn;
			if(card.isUseCardInTurn) s+= cardInTurn;
			shield += (card.getAmountShield()+s); 
			shieldTxt.setText("" + shield);
		}
		
		if(card.needHurt) {
			int dmg = card.getAmountHurt() - shield;
			if(dmg < 0) {
				shield = - dmg;
				dmg = 0;
			} else {
				shield = 0;
			}
			game.Enemy_damege(dmg);
			shieldTxt.setText("" + shield);
		}
	}
	// End CounterCard
	
	
	//DiceCard
	private void action_DiceCard(Card card, Dice dice){
		if(dice.typeDice() == 1) {
			dice.setDiceValue(card.getConditionMax());
			
		} else if(dice.typeDice() == 2) {
			dice.setDiceValue(card.getConditionMin());
		}
		
		if(card.needDiscard) {
			card.setAmountDiscard(dice.getDiceValue());
			if(card.getAmountDiscard() > cardLayer.cardInHand.size()) {
				cardLayer.clearHand();
			} else {
				for(int i=0; i< card.getAmountDiscard(); i++) {
					int rad = (int)(Math.random()*cardLayer.cardInHand.size());
					cardLayer.discard(cardLayer.cardInHand.get(rad));
				}
			} 
			
			cardLayer.sortCard();	
			
		} 
		
		if(card.needThrow) {
			card.setAmountThrow(dice.getDiceValue());
			if(diceLayer.diceBag.size()<card.getAmountThrow()) {
				for(int i=0; i< diceLayer.diceBag.size(); i++) {
					int rad = (int)(Math.random()*diceLayer.diceBag.size());
					diceLayer.throwDice(diceLayer.diceBag.get(rad));
				}
			} else {
				for(int i=0; i< card.getAmountThrow(); i++) {
					int rad = (int)Math.random()*diceLayer.diceBag.size();
					diceLayer.throwDice(diceLayer.diceBag.get(rad));
				}
			}
			
			diceLayer.sortDice();
			
		}
		
		if(card.needDraw) {
			card.setAmountDraw(dice.getDiceValue());
			for(int i=0; i<card.getAmountDraw(); i++) {
				if(deck.Deck.size() == 0) {
					phase = LOSE_GAME;
					return;
				} else {
					exit.setEnabled(false);
					cardLayer.drawCard(deck.drawFromDeck());
					cardUseInGame.add(cardLayer.cardInHand.get(cardLayer.cardInHand.size()-1));
					numberCard.setText("" + deck.Deck.size());
				}
			}
			cardLayer.sortCard();
			exit.setEnabled(true);
		}
		
		if(card.needRoll) {
			MainFrame.sound.playSFX(1);
			switch (card.getDiceAtValue1()){
			case -3:
				for(int i=0; i<2; i++) {
					diceLayer.addDice((dice.getDiceValue()/2));
				}
				break;
			case -2:
				for(int i=0; i<card.getAmountRollDice1(); i++) {
					diceLayer.addDice(dice.getDiceValue());
				}
				break;
			case -1:
				for(int i=0; i<card.getAmountRollDice1(); i++) {
					diceLayer.addDice();
				}
				break;
			case 6:
				for(int i=0; i<card.getAmountRollDice1(); i++) {
					diceLayer.addDice('g');
				}
				break;
			case 7:
				for(int i=0; i<card.getAmountRollDice1(); i++) {
					diceLayer.addDice('s');
				}
				break;
			default:
				for(int i=0; i<card.getAmountRollDice1(); i++) {
					diceLayer.addDice(card.getDiceAtValue1());
				}
			}
			
			diceLayer.sortDice();
			
		}
		
		if(card.needAttack) {
			card.setAmountAttack(dice.getDiceValue());
			game.turn = 1;
			game.Run();
			game.Attack();
			game.Character_damage(card.getAmountAttack());
			dmgInTurn += card.getAmountAttack();
			
		}
		
		if(card.needHeal) {
			MainFrame.sound.playSFX(6);
			card.setAmountHeal(dice.getDiceValue());
			game.Enemy_damege(-card.getAmountHeal());
			
		}
		
		if(card.needShield) {
			MainFrame.sound.playSFX(7);
			card.setAmountShield(dice.getDiceValue());
			shield += card.getAmountShield(); 
			shieldTxt.setText("" + shield);
		}
		
		if(card.needHurt) {
			card.setAmountHurt(dice.getDiceValue());
			
			int dmg = card.getAmountHurt() - shield;
			if(dmg < 0) {
				shield = - dmg;
				dmg = 0;
			} else {
				shield = 0;
			}
			game.Enemy_damege(dmg);
			shieldTxt.setText("" + shield);
		}
		
	}
	// End DiceCard
	
	public void boss_phase() {
		if(bossStack == 3) {
			enemy.StrongHit();
			shieldTxt.setText("" + shield);
			bossStack = -1;
		}
		else {
			int rad = (int)(Math.random()*2);
			if(game.Enemy_Hp() >= 25  && game.Enemy_Hp() <= 70) {
				switch(rad) {
				case 0: enemy.Heal();
						break;
				case 1: enemy.MultiAttack();
						shieldTxt.setText("" + shield);
						break;
				
				}
			}else {
				enemy.MultiAttack();
				shieldTxt.setText("" + shield);
			}
		}
	}
	
	public void defeat() {
		layer.add(loseGame, Integer.valueOf(2));
		loseGame.setBackground(new Color(0, 0, 0, 50));
		int alpha = 50;
		
		double delta = 0;
		long lastTime = System.nanoTime();
		double drawInterval = 1000000000/60;
		int sec = 0;
		boolean flag = false;
		while(true) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			if(delta >= 1) {
				if(sec < 200) {
					sec++;
					if(sec % 2 == 0) {
						alpha += 1;
						loseGame.setBackground(new Color(0, 0, 0, alpha));
					}
					if(sec > 120) {
						if(!flag) {
							if(isOn) {
								MainFrame.sound.playSFX(8);
							}
							loseGame.add(loseImg);
						}
					}
				} else {
					layer.remove(loseGame);
					return;
				}
				
				delta--;
			}
		}
	}
	
	public void victory() {
		layer.add(winGame, Integer.valueOf(2));
		int alpha = 0;
		winGame.setBackground(new Color(255, 242, 204, alpha));
		
		double delta = 0;
		long lastTime = System.nanoTime();
		double drawInterval = 1000000000/60;
		int sec = 0;
		int flag = 0;
		while(true) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			if(delta >= 1) {
				if(sec < 200) {
					sec++;
					if(sec > 80) {
						
						if(sec % 2 == 0) {
							alpha += 1;
							winGame.setBackground(new Color(255, 242, 204, alpha));
						}
					}
					
					if(sec > 120) {
						if(flag == 0) {
							if(isOn) {
								MainFrame.sound.playSFX(9);
							}
							winGame.add(winImg);
							flag = 1;
						}
					}
				} else {
					winGame.remove(winImg);
					layer.remove(winGame);
					return;
				}
				
				delta--;
			}
		}
	}
}