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
		System.out.println(h.getName() + "の残りHP＝" + h.getHp());

	}

	public void checkZero(Hero h) {
		if(h.getHp() <= 0) {
			h.setHp(0);
//			System.out.println(h.getName() + "のHPが０になりました。");
		}
	}



}
