package testApp;

import java.util.Random;

public class Maou {

	private String name;
	private int hp = 1000;

	// Getter
	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	// Setter
	public void setName(String name) {
		this.name = name;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	// Normalアタックメソッド。確率は1/2に設定。
	public void attack(Hero h) {

		Random rand = new Random();
	    int num = rand.nextInt(2);
	    System.out.println("info:魔王atackFlug=" + num);

		if(num == 0) {
			int heroHp = h.getHp() - 50;
			h.setHp(heroHp);
 			System.out.println(name + "は" + h.getName() + "に50のダメージを与えた！");
		} else {
			System.out.println("ミス！" + name + "の攻撃は外れた・・・");
		}
		checkZero(h);
	}
	
	// Maouが進化時の爆風攻撃。回避不能。
	public void stormAttack(Hero h) {
		int heroHp = h.getHp() - 100;
		h.setHp(heroHp);
		System.out.println("爆風により、" + h.getName() + "は100のダメージを受けた！");
		checkZero(h);
	}

	// HPが0以下にならないよう0チェックをする。
	public void checkZero(Hero h) {
		if(h.getHp() <= 0) {
			h.setHp(0);
		}
		System.out.println("＊＊＊＊＊＊＊＊＊＊" + h.getName() + "の残りHP＝" + h.getHp() + "＊＊＊＊＊＊＊＊＊＊");
	}



}
