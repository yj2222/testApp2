package testApp;

public class Sword {

	private String name;
	private int dmg;
	private int successRate;

	// Getter
	public String getName() {
		return name;
	}

	public int getDmg() {
		return dmg;
	}

	public int getSuccessRate() {
		return successRate;
	}

	void sword(String name, int dmg, int rate){
		this.name = name;
		this.dmg = dmg;
		this.successRate = rate;
	}

}
