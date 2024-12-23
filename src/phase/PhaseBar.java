package phase;

import java.awt.Graphics;

import javax.swing.*;

public class PhaseBar extends JPanel{
	
	ImageIcon phaseBar;
	private final ImageIcon PHASE_1 = new ImageIcon(PhaseBar.class.getResource("/sprite/PhaseBar/phaseBar_p1.png"));
	private final ImageIcon PHASE_2 = new ImageIcon(PhaseBar.class.getResource("/sprite/PhaseBar/phaseBar_p2.png"));
	private final ImageIcon PHASE_3 = new ImageIcon(PhaseBar.class.getResource("/sprite/PhaseBar/phaseBar_p3.png"));
	private final ImageIcon PHASE_4 = new ImageIcon(PhaseBar.class.getResource("/sprite/PhaseBar/phaseBar_p4.png"));
	private final ImageIcon PHASE_5 = new ImageIcon(PhaseBar.class.getResource("/sprite/PhaseBar/phaseBar_p5.png"));
	
	public PhaseBar() {
		phaseBar = new ImageIcon();
		phaseBar = PHASE_1;
		this.setOpaque(false);
		this.setSize(phaseBar.getIconWidth(), phaseBar.getIconHeight());
		this.setLocation(800, 265);
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		phaseBar.paintIcon(this, g, 0, 0);
	}
	
	public void phaseSwitch(int phase) {
		switch(phase) {
		case 1:
			phaseBar = PHASE_1;
			repaint();
			break;
		case 2:
			phaseBar = PHASE_2;
			repaint();
			break;
		case 3:
			phaseBar = PHASE_3;
			repaint();
			break;
		case 4:
			phaseBar = PHASE_4;
			repaint();
			break;
		case 5:
			phaseBar = PHASE_5;
			repaint();
			break;
		}
		
	}
}
