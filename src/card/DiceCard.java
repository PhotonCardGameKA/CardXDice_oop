package card;

public class DiceCard extends Card{
	private boolean evenCondition = false;
	private boolean oddCondition = false;
	
	public DiceCard() {
		super();
		this.type = DICE_CARD;
	}
	
	public void setEOCondition(int c) {
		if(c == 1) oddCondition = true;
		else if(c == 2) evenCondition = true;
		else {
			evenCondition = false;
			oddCondition = false;
		}
	}
	
	public boolean checkCondition(int diceValue) {
		if(oddCondition) {
			this.setCardCondition(1, 5);
			if((diceValue % 2 == 1) && (diceValue <= getConditionMax()) && (diceValue >= getConditionMin())) return true;
			else return false;
		}else if(evenCondition) {
			this.setCardCondition(0, 4);
			if((diceValue % 2 == 0) && (diceValue <= getConditionMax()) && (diceValue >= getConditionMin())) return true;
			else return false;
		}else {
			if(diceValue <= getConditionMax() && diceValue >= getConditionMin()) return true;
			else return false;
		}
	}
	
	
}
