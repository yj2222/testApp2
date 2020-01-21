package testApp;

import java.util.Random;

public class Hero {
	
	private String name;
	private int hp = 1000;
	private Sword sw;
	
	// Getter
	public String getName() {
		return name;
	}
	
	public int getHp() {
		return hp;
	}
	
	public Sword getSw() {
		return sw;
	}
	
	// Setter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void setSw(Sword sw) {
		this.sw = sw;
		System.out.println(this.name + "は" + sw.getName() + "を装備した！");
	}
	
	public void attack(Maou m) {
		
		System.out.println(sw.getSuccessRate());
		
		Random rand = new Random();
	    int i = rand.nextInt(100);
	    System.out.println(i);
	    
		if(sw.getSuccessRate() > i) {
			int maouHp = m.getHp() - sw.getDmg();
			m.setHp(maouHp);
			System.out.println(name + "は" + sw.getName() + "で" + m.getName() + "に" + sw.getDmg() + "のダメージを与えた！");
		} else {
			System.out.println("ミス！" + name + "の攻撃は外れた・・・");
		}
		System.out.println(m.getName() + "の残りHP＝" + m.getHp());
	}
	
	

}
