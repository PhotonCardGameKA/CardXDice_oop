package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import main.MainFrame;
import main.MainGame;

public class MenuPanel extends JPanel implements Runnable{
	//TitleName
	JLabel titleName;
	ImageIcon titleNameImg =new ImageIcon(MainGame.class.getResource("/background/menuTitle.png"));
	//startButton
	JButton startButton;
	//deckListMenu
	JButton deckListMenu;
	//exitButton
	JButton exitButton;
	//optionButton
	JButton optionButton;
	ImageIcon optionButtonImg;
	
	private OptionPanel optionPanel;
	JLayeredPane layer;
	
	private boolean stop = false;
	
	
	JLabel menuBG;
	
	private final int START_GAME = 1;
	private final int DECK_LIST = 2;
	private final int EXIT = 3;
	private final int MENU = 0;
	
	public int state = MENU;
	
	private boolean isEnable;
	
	public MenuPanel() {
		//layer
		
		//optionPanel
		optionPanel = new OptionPanel();

		menuBG = new JLabel();
		menuBG.setIcon(new ImageIcon(MainGame.class.getResource("/background/backgroundMenu.png")));
		menuBG.setBounds(0, 0, 1152, 648);
		//Frame
		this.setVisible(true);
		this.setSize((int)(1280*0.9),(int) (720*0.9));
		this.setLayout(null);
		
		//layer
		layer = new JLayeredPane();
		layer.setSize(1152, 648);
		layer.setLocation(0, 0);
		layer.setLayout(null);
		layer.setOpaque(false);
		this.add(layer);
		
		//TitleName
		titleName = new JLabel();
		titleName.setIcon(titleNameImg);
		titleName.setLocation(650, 100);
		titleName.setSize(titleNameImg.getIconWidth(), titleNameImg.getIconHeight());
		this.add(titleName);
		
		//startButton
		startButton = new JButton("Start");
		startButton.setSize(220, 30);
		startButton.setLocation(240, 185);
		startButton.setIcon(new ImageIcon(MenuPanel.class.getResource("/sprite/Button/menuStartOut.png")));
		startButton.setRolloverIcon(new ImageIcon(MenuPanel.class.getResource("/sprite/Button/menuStartIn.png")));
		startButton.setPressedIcon(new ImageIcon(MenuPanel.class.getResource("/sprite/Button/menuStartIn.png")));
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(false);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.sound.playSFX(0);
				state = START_GAME;
			}
		});
		this.add(startButton);
		
		//deckListMenu
		deckListMenu = new JButton("Deck");
		deckListMenu.setSize(220, 30);
		deckListMenu.setLocation(240, 285);
		deckListMenu.setIcon(new ImageIcon(MenuPanel.class.getResource("/sprite/Button/menuDeckOut.png")));
		deckListMenu.setRolloverIcon(new ImageIcon(MenuPanel.class.getResource("/sprite/Button/menuDeckIn.png")));
		deckListMenu.setPressedIcon(new ImageIcon(MenuPanel.class.getResource("/sprite/Button/menuDeckIn.png")));
		deckListMenu.setContentAreaFilled(false);
		deckListMenu.setBorderPainted(false);
		deckListMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.sound.playSFX(0);
				state = DECK_LIST;
			}
		});
		this.add(deckListMenu);
		//exitButton
		exitButton = new JButton("Exit");
		exitButton.setSize(220, 30);
		exitButton.setLocation(240, 385);
		exitButton.setIcon(new ImageIcon(MenuPanel.class.getResource("/sprite/Button/menuExitOut.png")));
		exitButton.setRolloverIcon(new ImageIcon(MenuPanel.class.getResource("/sprite/Button/menuExitIn.png")));
		exitButton.setPressedIcon(new ImageIcon(MenuPanel.class.getResource("/sprite/Button/menuExitIn.png")));
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(false);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				state = EXIT;
			}
		});
		this.add(exitButton);
		
		//optionButton
		optionButton = new JButton();
		optionButton.setSize(60, 60);
		optionButton.setLocation(950, 500);
		optionButton.setIcon(new ImageIcon(MainGame.class.getResource("/sprite/Button/optionOut.png")));
		optionButton.setRolloverIcon(new ImageIcon(MainGame.class.getResource("/sprite/Button/optionIn.png")));
		optionButton.setDisabledIcon(new ImageIcon(MainGame.class.getResource("/sprite/Button/optionOut.png")));
		optionButton.setContentAreaFilled(false);
		optionButton.setBorderPainted(false);
		optionButton.setFocusable(false);
		optionButton.setHorizontalTextPosition(JButton.CENTER);
		optionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.sound.playSFX(0);
				startButton.setEnabled(false);
				deckListMenu.setEnabled(false);
				exitButton.setEnabled(false);
				optionButton.setEnabled(false);
				layer.add(optionPanel);
			}
		});
		this.add(optionButton);
		
		this.add(menuBG);
	}

	Thread menuThread;
	
	public void start() {
		stop = false;
		menuThread = new Thread(this);
		menuThread.start();                       
	}
	
	public void stop() {
		stop = true;
	}
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println(optionPanel.isHome);
			if(optionPanel.isHome) {
				layer.remove(optionPanel);
				optionPanel.isHome = false;
				startButton.setEnabled(true);
				deckListMenu.setEnabled(true);
				exitButton.setEnabled(true);
				optionButton.setEnabled(true);
			}
			if(optionPanel.isBack) {
				layer.remove(optionPanel);
				optionPanel.isBack = false;
				startButton.setEnabled(true);
				deckListMenu.setEnabled(true);
				exitButton.setEnabled(true);
				optionButton.setEnabled(true);
			}
		}
			
	}
}
