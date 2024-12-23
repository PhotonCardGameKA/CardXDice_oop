package menu;

import card.*;
import main.MainFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class DeckListPanel extends JPanel implements Runnable{
	
	private JPanel cardLib;
	private JScrollPane cardLibPane;
	public JPanel deckPanel;
	private JScrollPane deckPane;
	private JTextArea textCard;
	private TextField deckTxt;
	private TextField libraryTxt;
	
	//Menu Button
	private JButton reset;
	private JButton sortDeck;
	private JButton exit;
	private JButton save;
	
	private boolean stop = false;
	private boolean cannotSaveDeck = false;
	private boolean letReset = false;
	
	public ArrayList<Card> deckInGame;
	public ArrayList<Card> deckTemp;
	public ArrayList<Card> cardSort;
	
	//
	
	String cannotSaveStr = " Không thể lưu vì không đủ 40 lá";
	JTextField cannotSave;
	
	CardLibrary cardLibrary;
	
	public int state = 2;
	/*
	private final int START_GAME = 1;
	private final int DECK_LIST = 2;
	private final int EXIT = 3;
	private final int MENU = 0;
	*/
	public DeckListPanel() {
		
		//CardLib
		cardLibrary = new CardLibrary();
		
		deckInGame = new ArrayList<Card>();
		for(int i=0; i<cardLibrary.cardList.size(); i++) {
			deckInGame.add(cardLibrary.cardList.get(i));

		}
		//
		//Deck
		deckTemp = new ArrayList<Card>();
		
		cannotSave = new JTextField("");
		cannotSave.setLocation(90, 250);
		cannotSave.setFont(new Font("Monospaced",Font.BOLD, 15));
		cannotSave.setBackground(new Color(255, 0, 0, 0));
		cannotSave.setSize(300, 100);
		
		this.setSize(1152, 648);
		this.setVisible(true);
		this.setLocation(0, 0);
		this.setBackground(new Color(125, 125, 125));
		this.setLayout(null);
		
		cardLib = new JPanel();
		cardLib.setPreferredSize(new Dimension(10000, 280));
		cardLib.setLocation(0, 0);
		cardLib.setBackground(new Color(0, 0, 100));
		cardLib.setLayout(null);
		
		cardLibPane = new JScrollPane(cardLib, 
				JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		cardLibPane.setSize(1110, 280);
		cardLibPane.setLocation(10, 330);
		
		libraryTxt = new TextField("Library");
		libraryTxt.setSize(80, 20);
		libraryTxt.setLocation(10, 310);
		libraryTxt.setEnabled(false);
		
		deckPanel = new JPanel();
		deckPanel.setPreferredSize(new Dimension(6010, 280));
		deckPanel.setLocation(0, 0);
		deckPanel.setBackground(Color.BLUE);
		deckPanel.setLayout(null);
		
		deckPane = new JScrollPane(deckPanel, 
				JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		deckPane.setSize(768, 280);
		deckPane.setLocation(10, 0);
		
		deckTxt = new TextField("Deck");
		deckTxt.setSize(80,20);
		deckTxt.setLocation(10, 280);
		deckTxt.setEnabled(false);
		
		textCard = new JTextArea();
		textCard.setSize(340, 320);
		textCard.setLocation(780, 0);
		textCard.setForeground(Color.BLACK);
		textCard.setDisabledTextColor(Color.BLACK);
		textCard.setLineWrap(true);
		textCard.setWrapStyleWord(true);
		textCard.setEnabled(false);
		
		//Menu Button
		reset = new JButton("Reset");
		reset.setSize(80, 40);
		reset.setLocation(390, 285);
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.sound.playSFX(0);
				letReset = true;
			}
		});
		
		sortDeck = new JButton("Sort Deck");
		sortDeck.setSize(80, 40);
		sortDeck.setLocation(490, 285);
		
		save = new JButton("Save");
		save.setSize(80, 40);
		save.setLocation(590, 285);
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.sound.playSFX(0);
				if(deckTemp.size() < 40) {
					cannotSaveDeck = true;
				} else {
					if(deckTemp.size() == 40) {
						deckInGame = new ArrayList<Card>();
						for(int i=0; i<deckTemp.size(); i++) {
							deckInGame.add(deckTemp.get(i));
						}
					}
					
				}
			}
		});
		
		exit = new JButton("Exit");
		exit.setSize(80, 40);
		exit.setLocation(690, 285);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.sound.playSFX(0);
				state = 0;
				Card.isInDeckList = false;
			}
		});
		
		this.add(deckPane);
		this.add(deckTxt);
		this.add(cardLibPane);
		this.add(libraryTxt);
		this.add(textCard);
		
		//Menu Button
		this.add(reset);
		this.add(sortDeck);
		this.add(save);
		this.add(exit);
		this.add(cannotSave);
		for(int i=0; i<cardLibrary.cardList.size(); i++) {
			cardLibrary.cardList.get(i).setCx(10+(i/3)*160);
			cardLibrary.cardList.get(i).setCy(10);
			cardLibrary.cardList.get(i).setLocation(cardLibrary.cardList.get(i).getCx(),
													cardLibrary.cardList.get(i).getCy());
			cardLib.add(cardLibrary.cardList.get(i));
		}
	}
	
	Thread deckListThread;
	
	public void start() {
		deckListThread = new Thread(this);
		deckListThread.start();
		Card.isInDeckList = true;
		this.stop = false;
	}
	public void stop() {
		Card.isInDeckList = false;
		for(int i=0; i<cardLibrary.cardList.size(); i++) {
			cardLibrary.cardList.get(i).isEnter = false;
		}
		this.stop = true;
	}
	@Override
	
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<MainFrame.Deck.Deck.size(); i++) {
			if(MainFrame.Deck.Deck.get(i).isUsedInGame) {
				if(MainFrame.Deck.Deck.get(i).isAddedToDeck) {
					deckPanel.add(MainFrame.Deck.Deck.get(i));
				} else {
					cardLib.add(MainFrame.Deck.Deck.get(i));
				}
				MainFrame.Deck.Deck.get(i).setImageSmall();
				MainFrame.Deck.Deck.get(i).isUsedInGame = false;
			}
		}
		
		while(!stop) {
			for(int i=0; i<cardLibrary.cardList.size(); i++) {
				if(cardLibrary.cardList.get(i).isEnter) {
					textCard.setText("" + cardLibrary.cardList.get(i).cardTxt);
				}
					if(cardLibrary.cardList.get(i).isAddToDeck) {
						if(deckTemp.size() < 40) {
							int p = 0;
							for(int j=0; j<deckTemp.size(); j++) {
								if(cardLibrary.cardList.get(i).getCardID() > deckTemp.get(j).getCardID()) {
									p++;
								}
							}
							deckTemp.add(p, cardLibrary.cardList.get(i));
							deckPanel.add(cardLibrary.cardList.get(i));
						}
						cardLibrary.cardList.get(i).isAddToDeck = false;
						cardLibrary.cardList.get(i).isAddedToDeck = true;
					}
					if(cardLibrary.cardList.get(i).isAddedToDeck) {
						if(cardLibrary.cardList.get(i).isWaitingToRemove) {
							deckTemp.remove(cardLibrary.cardList.get(i));
							cardLib.add(cardLibrary.cardList.get(i));
							cardLibrary.cardList.get(i).setCx(10+(i/3)*160);
							cardLibrary.cardList.get(i).setCy(10);
							cardLibrary.cardList.get(i).setLocation(cardLibrary.cardList.get(i).getCx(),
																	cardLibrary.cardList.get(i).getCy());
							cardLibrary.cardList.get(i).isWaitingToRemove = false;
							cardLibrary.cardList.get(i).isAddedToDeck = false;
						}
					} else {
						if(!cardLibrary.cardList.get(i).isAddedToDeck) {
							cardLibrary.cardList.get(i).setCx(10+(i/3)*160);
							cardLibrary.cardList.get(i).setCy(10);
							cardLibrary.cardList.get(i).setLocation(cardLibrary.cardList.get(i).getCx(),
																	cardLibrary.cardList.get(i).getCy());
							}
						}
					
				}
				
			
			
			for(int i=0; i<deckTemp.size(); i++) {
				deckTemp.get(i).setCx(10+(i)*150);
				deckTemp.get(i).setCy(10);
				deckTemp.get(i).setLocation(deckTemp.get(i).getCx(),
														deckTemp.get(i).getCy());
			}
			
			if(cannotSaveDeck) {
				notEnoughCard();
				cannotSaveDeck = false;
			}
			if(letReset) {
				int i=deckTemp.size()-1;
				while(i>=0) {
					if(deckTemp.get(i).isAddedToDeck) {
							deckTemp.get(i).isWaitingToRemove = true;
					}
					i--;
				}
				letReset = false;
			}
		}
	}
		
	private void notEnoughCard() {
		double delta = 0;
		long lastTime = System.nanoTime();
		double drawInterval = 1000000000/60;
		int sec = 0;
		boolean flag = false;
		int alpha = 50;
		while(true) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			if(delta >= 1) {
				if(sec < 100) {
					sec++;
					if(!flag) {
						cannotSave.setText(cannotSaveStr);
						flag = true;
					}
					if(sec % 20 == 0) {
						alpha = 50;
					}
					cannotSave.setBackground(new Color(255, 0, 0, alpha));
					alpha+=5;
				} else {
					cannotSave.setBackground(new Color(255, 0, 0, 0));
					cannotSave.setText("");
					return;
				}
				
				delta--;
			}
		}
	}
	
}
