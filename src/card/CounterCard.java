package card;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;

public class CounterCard extends Card{
	
	private JTextArea valueCounter; 
	
	private int counterValue;
	private int counterRemain;
	
	
	public CounterCard() {
		super();
		this.type = COUNTER_CARD;
		valueCounter = new JTextArea();
		valueCounter.setText("" + counterRemain);
		valueCounter.setBounds(2,1,20,20);
		valueCounter.setFont(new Font("Monospaced Bold",Font.PLAIN, 13));
		valueCounter.setOpaque(false);
		valueCounter.setForeground(new Color(0, 0, 0));
		valueCounter.setEnabled(false);
		valueCounter.setDisabledTextColor(Color.black);
		this.add(valueCounter);
	}
	
	public void decreaseCounter(int a) {
		this.counterRemain -= a;
		valueCounter.setText("" + counterRemain);
	}
	
	public int getCounterRemain() {
		return this.counterRemain;
	}
	
	public void setCounterRemain(int a) {
        this.counterValue = a;
        this.counterRemain = a;
        valueCounter.setText("" + counterRemain);
    }
	public void resetCounter() {
		counterRemain = counterValue;
		valueCounter.setText("" + counterRemain);
	}
}