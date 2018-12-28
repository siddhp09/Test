package schoolProjects;

public class PairOfDice {
	//data members 
	private Die d1;
	private Die d2;
	
	//constructor and overloaded constructor
	public PairOfDice() {
		d1 = new Die();
	    d2 = new Die();
	}

	public PairOfDice(int x, int y) {
		d1 = new Die(x);
	    d2 = new Die(y);
	}
	
	//getters
	public Die getDie1() {
		return d1;
	}

	public Die getDie2() {
		return d2;
	}
	
	//methods 
	public boolean isHSE() {
		// checks if only 1 dice rolls 1
		if (d1.getFaceValue() == 1 && d2.getFaceValue() != 1
				|| d1.getFaceValue() != 1 && d2.getFaceValue() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSE() {
		// checks if both dice roll 1
		if (d1.getFaceValue() == 1 && d2.getFaceValue() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void rollDice() {
		//rolls 2 dice
		d1.roll();
		d2.roll();
	}

	public int sumRoll() {
		// returns sum of roll on two dice
		return d1.getFaceValue() + d2.getFaceValue();
	}

	public String toString() {
		return "(" +d1.getFaceValue() +","+ d2.getFaceValue() + ")";
	}

}
