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

	// Maou攻撃時のメソッド。
	public void attack(Maou m) {

		// Randomな数字を取得。
		int ramdomRate = ramdomRate();

		if(sw.getSuccessRate() > ramdomRate) {
			int maouHp = m.getHp() - sw.getDmg();
			m.setHp(maouHp);
			System.out.println(name + "は" + sw.getName() + "で" + m.getName() + "に" + sw.getDmg() + "のダメージを与えた！");
		} else {
			System.out.println("ミス！" + name + "の攻撃は外れた・・・");
		}
		checkZero(m);
	}

	// DaiMaou攻撃時のメソッド。
	public void attack(DaiMaou dm) {

		// Randomな数字を取得。
		int ramdomRate = ramdomRate();

		if(sw.getSuccessRate() > ramdomRate) {
			// DaiMaouに攻撃時はダメージ半減。
			int maouHp = dm.getHp() - (sw.getDmg() / 2);
			dm.setHp(maouHp);
			System.out.println(name + "は" + sw.getName() + "で" + dm.getName() + "に" + (sw.getDmg() / 2) + "のダメージを与えた！");
		} else {
			System.out.println("ミス！" + name + "の攻撃は外れた・・・");
		}
		checkZero(dm);
		
	}
	
	// Randomな数字を取得するメソッド。
	public int ramdomRate() {
		Random rand = new Random();
	    int i = rand.nextInt(100);
		System.out.println("info:SwordRate=" + sw.getSuccessRate());
	    System.out.println("info:RandomFlug=" + i);
		return i;		
	}

	// HPが0以下にならないよう0チェックをする。
	public void checkZero(Maou m) {
		if(m.getHp() <= 0) m.setHp(0);
		System.out.println("＊＊＊＊＊＊＊＊＊＊" + m.getName() + "の残りHP＝" + m.getHp() + "＊＊＊＊＊＊＊＊＊＊");
	}
	
	// HPが0以下にならないよう0チェックをする。こっちは大魔王。受け取る方が違うので別メソッドにしました。
	public void checkZero(DaiMaou dm) {
		if(dm.getHp() <= 0) dm.setHp(0);
		System.out.println("＊＊＊＊＊＊＊＊＊＊" + dm.getName() + "の残りHP＝" + dm.getHp() + "＊＊＊＊＊＊＊＊＊＊");
	}

}
