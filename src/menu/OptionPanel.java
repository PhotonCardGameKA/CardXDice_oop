package menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.MainFrame;
import main.MainGame;

public class OptionPanel extends JPanel{
	
	JPanel optionBox;
	JLabel optionBG;
	
	JButton muteTrack;
	JButton trackVolUp;
	JButton trackVolDown;
	JButton muteSFX;
	JButton sfxVolUp;
	JButton sfxVolDown;
	
	JButton back;
	JButton home;
	JButton option;
	
	int trackV = 5;
	int sfxV = 5;
	JLabel[] trackVol = new JLabel[10];
	JLabel[] sfxVol = new JLabel[10];
	
	ImageIcon muteTrackIcon = new ImageIcon(OptionPanel.class.getResource("/sprite/Button/muteTrack.png"));
	ImageIcon unmuteTrackIcon = new ImageIcon(OptionPanel.class.getResource("/sprite/Button/unmuteTrack.png"));
	ImageIcon muteSFXIcon = new ImageIcon(OptionPanel.class.getResource("/sprite/Button/muteSFX.png"));
	ImageIcon unmuteSFXIcon = new ImageIcon(OptionPanel.class.getResource("/sprite/Button/unmuteSFX.png"));
	ImageIcon volumeOn = new ImageIcon(OptionPanel.class.getResource("/sprite/Button/volumeOn.png"));
	ImageIcon volumeOff = new ImageIcon(OptionPanel.class.getResource("/sprite/Button/volumeOff.png"));
	
	public boolean isBack = false;
	public boolean isHome = false;

	public OptionPanel() {
		isHome = false;
		isBack = false;
		
		this.setSize(1152, 648);
		this.setLocation(0, 0);
		this.setBackground(new Color(0, 0, 0, 150));
		this.setLayout(null);
		
		//optionBox
		optionBox = new JPanel();
		optionBox.setBounds(441,174,275,310);
		optionBox.setLayout(null);
		optionBox.setOpaque(false);
		
		// track Volume Bar
		for(int i=0; i < 10; i++) {
			trackVol[i] = new JLabel();
			trackVol[i].setSize(5, 20);
			trackVol[i].setLocation(116 + 6*i, 76);
			if(i < trackV) {
				trackVol[i].setIcon(volumeOn);
			}else {
				trackVol[i].setIcon(volumeOff);
			}
			optionBox.add(trackVol[i]);
		}
		
		// sfx Volume Bar
		for(int i=0; i < 10; i++) {
			sfxVol[i] = new JLabel();
			sfxVol[i].setSize(5, 20);
			sfxVol[i].setLocation(116 + 6*i, 103);
			if(i < sfxV) {
				sfxVol[i].setIcon(volumeOn);
			}else {
				sfxVol[i].setIcon(volumeOff);
			}
			optionBox.add(sfxVol[i]);
		}
		
		// Track volume changes
		muteTrack = new JButton();
		muteTrack.setSize(18, 20);
		muteTrack.setLocation(76, 76);
		muteTrack.setIcon(unmuteTrackIcon);
		muteTrack.setPressedIcon(muteTrackIcon);
		muteTrack.setContentAreaFilled(false);
		muteTrack.setBorderPainted(false);
		muteTrack.setFocusable(false);
		muteTrack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.sound.playSFX(0);
				MainFrame.sound.trackMute();
				if(MainFrame.sound.trackMuted) {
					muteTrack.setIcon(muteTrackIcon);
					muteTrack.setPressedIcon(unmuteTrackIcon);
				}else {
					muteTrack.setIcon(unmuteTrackIcon);
					muteTrack.setPressedIcon(muteTrackIcon);
				}
			}		
		});
		
		trackVolUp = new JButton();
		trackVolUp.setSize(10, 20);
		trackVolUp.setLocation(179, 76);
		trackVolUp.setIcon(new ImageIcon(OptionPanel.class.getResource("/sprite/Button/volumeUpOut.png")));
		trackVolUp.setPressedIcon(new ImageIcon(OptionPanel.class.getResource("/sprite/Button/volumeUpOn.png")));
		trackVolUp.setContentAreaFilled(false);
		trackVolUp.setBorderPainted(false);
		trackVolUp.setFocusable(false);
		trackVolUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.sound.playSFX(0);
				MainFrame.sound.trackVolumeUp();
				if(trackV <= 9) {
					trackVol[trackV].setIcon(volumeOn);
					trackV++;
				}else {
					trackV = 10;
				}
			}		
		});
		
		trackVolDown = new JButton();
		trackVolDown.setSize(10, 20);
		trackVolDown.setLocation(102, 76);
		trackVolDown.setIcon(new ImageIcon(OptionPanel.class.getResource("/sprite/Button/volumeDownOut.png")));
		trackVolDown.setPressedIcon(new ImageIcon(OptionPanel.class.getResource("/sprite/Button/volumeDownOn.png")));
		trackVolDown.setContentAreaFilled(false);
		trackVolDown.setBorderPainted(false);
		trackVolDown.setFocusable(false);
		trackVolDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.sound.playSFX(0);
				MainFrame.sound.trackVolumeDown();
				if(trackV > 0) {
					trackV--;
					trackVol[trackV].setIcon(volumeOff);
					
				}else {
					trackV = 0;
				}
			}		
		});
		
		// SFX volume changes
		muteSFX = new JButton();
		muteSFX.setSize(18, 20);
		muteSFX.setLocation(76, 103);
		muteSFX.setIcon(unmuteSFXIcon);
		muteSFX.setPressedIcon(muteSFXIcon);
		muteSFX.setContentAreaFilled(false);
		muteSFX.setBorderPainted(false);
		muteSFX.setFocusable(false);
		muteSFX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.sound.sfxMute();
				if(MainFrame.sound.sfxMuted) {
					muteSFX.setIcon(muteSFXIcon);
					muteSFX.setPressedIcon(unmuteSFXIcon);
				}else {
					muteSFX.setIcon(unmuteSFXIcon);
					muteSFX.setPressedIcon(muteSFXIcon);
				}
				MainFrame.sound.playSFX(0);
			}		
		});
		
		sfxVolUp = new JButton();
		sfxVolUp.setSize(10, 20);
		sfxVolUp.setLocation(179, 103);
		sfxVolUp.setIcon(new ImageIcon(OptionPanel.class.getResource("/sprite/Button/volumeUpOut.png")));
		sfxVolUp.setPressedIcon(new ImageIcon(OptionPanel.class.getResource("/sprite/Button/volumeUpOn.png")));
		sfxVolUp.setContentAreaFilled(false);
		sfxVolUp.setBorderPainted(false);
		sfxVolUp.setFocusable(false);
		sfxVolUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(sfxV <= 9) {
					sfxVol[sfxV].setIcon(volumeOn);
					sfxV++;
				}else {
					sfxV = 10;
				}
				MainFrame.sound.sfxVolumeUp();
				MainFrame.sound.playSFX(0);
			}		
		});
		
		sfxVolDown = new JButton();
		sfxVolDown.setSize(10, 20);
		sfxVolDown.setLocation(102, 103);
		sfxVolDown.setIcon(new ImageIcon(OptionPanel.class.getResource("/sprite/Button/volumeDownOut.png")));
		sfxVolDown.setPressedIcon(new ImageIcon(OptionPanel.class.getResource("/sprite/Button/volumeDownOn.png")));
		sfxVolDown.setContentAreaFilled(false);
		sfxVolDown.setBorderPainted(false);
		sfxVolDown.setFocusable(false);
		sfxVolDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(sfxV > 0) {
					sfxV--;
					sfxVol[sfxV].setIcon(volumeOff);
					
				}else {
					sfxV = 0;
				}
				MainFrame.sound.sfxVolumeDown();
				MainFrame.sound.playSFX(0);
			}		
		});
		
		//back
		back = new JButton();
		back.setSize(24, 24);
		back.setLocation(100, 132);
		back.setIcon(new ImageIcon(OptionPanel.class.getResource("/sprite/Button/backOut.png")));
		back.setPressedIcon(new ImageIcon(OptionPanel.class.getResource("/sprite/Button/backOn.png")));
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setFocusable(false);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.sound.playSFX(0);
				isBack = true;
			}		
		});
		
		
		//home
		home = new JButton();
		home.setSize(24, 24);
		home.setLocation(135, 132);
		home.setIcon(new ImageIcon(OptionPanel.class.getResource("/sprite/Button/homeOut.png")));
		home.setPressedIcon(new ImageIcon(OptionPanel.class.getResource("/sprite/Button/homeOn.png")));
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.setFocusable(false);
		home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MainGame.isOn) {
					MainFrame.sound.stopSFX();
					MainFrame.sound.stopTrack();
					MainFrame.sound.playTrack(0);
				}
				MainFrame.sound.playSFX(0);
				isHome = true;
			}			
		});
		
		//option
		option = new JButton();
		option.setSize(60, 60);
		option.setLocation(101,233);
		option.setIcon(new ImageIcon(OptionPanel.class.getResource("/sprite/Button/optionOut.png")));
		option.setRolloverIcon(new ImageIcon(OptionPanel.class.getResource("/sprite/Button/optionIn.png")));
		option.setContentAreaFilled(false);
		option.setBorderPainted(false);
		option.setFocusable(false);
		option.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.sound.playSFX(0);
				isBack = true;
			}		
		});
		
		//Background
		optionBG = new JLabel();
		optionBG.setIcon(new ImageIcon(OptionPanel.class.getResource("/background/backgroundOption.png")));
		optionBG.setBounds(0,0,275,310);
		
		// adding
		optionBox.add(muteTrack);
		optionBox.add(muteSFX);
		optionBox.add(trackVolUp);
		optionBox.add(trackVolDown);
		optionBox.add(sfxVolUp);
		optionBox.add(sfxVolDown);
		optionBox.add(back);
		optionBox.add(home);
		optionBox.add(option);
		optionBox.add(optionBG);
		this.add(optionBox);
		
	}


}