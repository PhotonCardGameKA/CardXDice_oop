package phase;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class PhaseMessage extends JPanel{
	
	ImageIcon phaseMsg;
	
	public boolean isDraw = false;;
	
	private final ImageIcon NONE = new ImageIcon();
	
	private final ImageIcon PHASE_0 = new ImageIcon(PhaseMessage.class.getResource("/anim/PhaseMsg/stand_by_phase.gif"));
	private final ImageIcon PHASE_1 = new ImageIcon(PhaseMessage.class.getResource("/anim/PhaseMsg/roll_phase.gif"));
	private final ImageIcon PHASE_2 = new ImageIcon(PhaseMessage.class.getResource("/anim/PhaseMsg/draw_phase.gif"));
	private final ImageIcon PHASE_3 = new ImageIcon(PhaseMessage.class.getResource("/anim/PhaseMsg/action_phase.gif"));
	private final ImageIcon PHASE_4 = new ImageIcon(PhaseMessage.class.getResource("/anim/PhaseMsg/end_phase.gif"));
	private final ImageIcon PHASE_5 = new ImageIcon(PhaseMessage.class.getResource("/anim/PhaseMsg/enemy_phase.gif"));
	
	public PhaseMessage() {
		phaseMsg = new ImageIcon();
		phaseMsg = PHASE_1;
		this.setSize(phaseMsg.getIconWidth(), phaseMsg.getIconHeight());
		phaseMsg = NONE;
		this.setLocation(350, 270);
		this.setOpaque(false);
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		phaseMsg.paintIcon(this, g, 0, 0);
	}

	private Image img;
	
	
	
	public void setPhaseMessage(int a) {
		switch(a) {
		case 0:
			img = PHASE_0.getImage();
			img.flush();
			phaseMsg = new ImageIcon(img);
			break;
		case 1:
			img = PHASE_1.getImage();
			img.flush();
			phaseMsg = new ImageIcon(img);
			repaint();
			break;
		case 2:
			img = PHASE_2.getImage();
			img.flush();
			phaseMsg = new ImageIcon(img);
			repaint();
			break;
		case 3:
			img = PHASE_3.getImage();
			img.flush();
			phaseMsg = new ImageIcon(img);
			repaint();
			break;
		case 4:
			img = PHASE_4.getImage();
			img.flush();
			phaseMsg = new ImageIcon(img);
			repaint();
			break;
		case 5:
			img = PHASE_5.getImage();
			img.flush();
			phaseMsg = new ImageIcon(img);
			repaint();
			break;
		}
		
	}
	
	public void drawPhaseMessage(int a) {
		isDraw = false;
		boolean done = false;
		double delta = 0;
		long lastTime = System.nanoTime();
		double drawInterval = 1000000000/60;
		int sec = 0;
		setPhaseMessage(a);
		repaint();
		while(!done) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			if(delta >= 1) {
				repaint();
				sec++;
				if(sec == 80) {
					phaseMsg = NONE;
					repaint();
					done = true;
					isDraw = true;
					return;
				}
				delta--;
			}
		}
	}	
}
