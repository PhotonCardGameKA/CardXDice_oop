package main;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import java.awt.Image;

import javax.swing.ImageIcon;

import card.*;
import menu.*;

public class MainFrame extends JFrame implements Runnable{
	
	private final int START_GAME = 1;
	private final int DECK_LIST = 2;
	private final int EXIT = 3;
	private final int MENU = 0;
	
	MenuPanel menuPanel;
	DeckListPanel deckMenu;
	MainGame mainGame;
	JLayeredPane layer;
	public static Sound sound;
	
	boolean addDeck = false;
	
	public static Deck Deck = new Deck();
	
	private int state = MENU;
	private int play = 0;
	private int deck = 0;
	
	Image icon;
	
	public MainFrame() {
		super("Card x Dice");
		ImageIcon iCon = new ImageIcon(MainFrame.class.getResource("/background/gameIcon.png"));
		icon = iCon.getImage();
		
		sound = new Sound();
		menuPanel = new MenuPanel();
		mainGame = new MainGame();
		deckMenu = new DeckListPanel();
		this.setSize(1152, 648);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setIconImage(icon);
		layer = new JLayeredPane();
		
		layer.add(menuPanel);
		layer.add(deckMenu);
		layer.add(mainGame);
		
		this.setLayeredPane(layer);
		this.setLocationRelativeTo(null);
	}
	
	Thread frameThread;
	
	public void startGame() {
		frameThread = new Thread(this);
		frameThread.start();
	}
	@Override
	public void run() {
		/*
		if(musicPlayInMenu == 0) {
			musicPlayInMenu = 1;
			
			musicPlayInMenu = 0;
		}*/
		sound.stopTrack();
		sound.playTrack(0);
		while(frameThread != null) {
			switch (state) {
			case MENU:
				layer.moveToFront(menuPanel);
				
				if(!addDeck) {
					int i = deckMenu.deckInGame.size() - 1;
					Deck = new Deck();
					while(i >= 0) {
						Deck.addCard(deckMenu.deckInGame.get(i));
						deckMenu.deckInGame.get(i).setLocation(960, 360);
						i--;
						
					}
					for(int c=0; c<deckMenu.deckInGame.size(); c++) {
						if(deckMenu.deckInGame.get(c).type == 0) {
							((CounterCard)deckMenu.deckInGame.get(c)).resetCounter();
						}
					}
					addDeck = true;
					Card.isAlreadyUsed = false;
					menuPanel.start();
					
				}
				state = menuPanel.state;
				if(state != MENU) {
					menuPanel.state = MENU;
					addDeck = false;
					menuPanel.stop();
				}
				break;
			case DECK_LIST:
				
				layer.moveToFront(deckMenu);
				if(deck == 0) {
					Card.isInDeckList = true;
					deckMenu.start();
					deck = 1;
				}
				state = deckMenu.state;
				if(state != DECK_LIST) {
					deckMenu.stop();
					deck = 0;
				}
				deckMenu.state = DECK_LIST;
				break;
			case START_GAME:
				MainGame.isOn = true;
				layer.moveToFront(mainGame);
				if(play == 0) {
					mainGame.startGame();
					play = 1;
				}
				state = mainGame.state;
				if(state != START_GAME) {
					MainGame.isOn = false;
					mainGame.stopGame();
					while(!mainGame.cardUseInGame.isEmpty()) {
						deckMenu.deckPanel.add(mainGame.cardUseInGame.get(mainGame.cardUseInGame.size()-1));
						mainGame.cardUseInGame.get(mainGame.cardUseInGame.size()-1).repaint();
						if(!mainGame.cardUseInGame.get(mainGame.cardUseInGame.size()-1).isAddedToDeck) {
							deckMenu.deckTemp.add(mainGame.cardUseInGame.get(mainGame.cardUseInGame.size()-1));
							mainGame.cardUseInGame.get(mainGame.cardUseInGame.size()-1).isAddedToDeck = true;
						}
						mainGame.cardUseInGame.remove(mainGame.cardUseInGame.size()-1);
					}
					
					mainGame = new MainGame();
					layer.add(mainGame);
					
					play = 0;
					
				}
				mainGame.state = START_GAME;
				break;
			case EXIT:
				System.exit(0);
			}
		}
		
	}
}
