package testApp;

import java.util.Random;
import java.util.Scanner;

public class Main {

	String[] swordName = {"銅の剣", "炎の剣", "ひのきのぼう", "伝説の剣"};

	public static void main(String[] args) {

		Hero h = new Hero();
		Scanner scan = new Scanner(System.in);

		//ヒーローネームを決める。
		System.out.println("勇者の名前を入力してください");
        boolean check = true;
        while (check) {
        	String heroName = scan.next();
        	check = checkHeroName(heroName, h);
        }
        userOperation();

        //装備を決める。
        Sword sw = gacha();
        h.setSw(sw);
        userOperation();

        //魔王の名前を決める。
        Maou m = new Maou();
        System.out.println("魔王の名前を入力してください");
        check = true;
        while (check) {
        	String maouName = scan.next();
        	check = checkMaouName(maouName, m);
        }
        userOperation();

        // バトル開始メソッド。
        battle(h, m, scan);

        DaiMaou dm = new DaiMaou();
        dm.setHp(m.getHp() + 1000);
        dm.setName(m.getName());
        int daiMaouHp = dm.getHp();
        System.out.println("大魔王の残りHP＝" + daiMaouHp);

        secondBattle(h, dm, scan);

	}

	//処理を区切って確認するためユーザにenterを入力させる。
	private static void userOperation() {
		System.out.println("■■■enterで次に進みます。■■■");
		new java.util.Scanner(System.in).nextLine();
	}

	// ヒーローネームの文字数チェック
	static boolean checkHeroName(String heroName, Hero h) {
		if(heroName.length() >= 11) {
			System.out.println("名前が⾧すぎます 10 文字以内で入力 してください");
		return true;
		} else if(heroName.length() <= 1) {
			System.out.println("名前が短すぎます、もう一度入力 してください");
			return true;
		} else {
		h.setName(heroName);
		System.out.println("名前を" + h.getName() + "にしました");
			return false;
		}
	}

	// 装備ガチャメソッド。
	static Sword gacha() {
		Random rand = new Random();
	    int i = rand.nextInt(4);
	    System.out.println("info:ガチャ開始・・・" + i + "番を引きました。");
	    Sword sw = new Sword();

	    switch(i){
	    case 0:
			sw.setName("銅の剣");
			sw.setDmg(100);
			sw.setSuccessRate(80);
		break;
	    case 1:
			sw.setName("炎の剣");
			sw.setDmg(200);
			sw.setSuccessRate(50);
		break;
	    case 2:
			sw.setName("ひのきのぼう");
			sw.setDmg(40);
			sw.setSuccessRate(100);
		break;
	    case 3:
			sw.setName("伝説の剣");
			sw.setDmg(400);
			sw.setSuccessRate(100);
		break;
	   }
	   return sw;
	}

	 // 魔王ネームの文字数チェック
	 static boolean checkMaouName(String maouName, Maou m) {
		 if(maouName.length() >= 7) {
			 System.out.println("名前が⾧すぎます 6 文字以内で入力 してください");
			 return true;
		 } else if(maouName.length() <= 1) {
			 System.out.println("名前が短すぎます、もう一度入力 してください");
			 return true;
		 } else if(maouName.length() == 0) {
			 System.out.println("もう一度入力してください");
			 return true;
		 }else {
			 System.out.println("名前 を" + maouName + "にしました");
			 m.setName(maouName);
			 return false;
		 }
	 }

	 static void secondBattle(Hero h, DaiMaou dm, Scanner scan) {
		System.out.println("最終決戦！！！");

		int heroHp = h.getHp();
		int maouHp = dm.getHp();

		int turn = 0;
		while(true) {
			System.out.println("a + enterを押して下さい");
			String enter = scan.next();
			System.out.println("ターン：" + turn);
			turn++;
			h.attack(dm);
			maouHp = dm.getHp();
			if(maouHp == 0) {
				System.out.println("勇者の勝利！");
				break;
			}
			dm.attack(h);
			heroHp = h.getHp();
			if(heroHp == 0) {
				System.out.println("魔王の勝利！");
				break;
			}
		}
	}





	 static void battle(Hero h, Maou m, Scanner scan) {
		System.out.println("バトル開始！！！");

		int heroHp = h.getHp();
		int maouHp = m.getHp();

		int turn = 0;
		while(true) {
			System.out.println("a + enterを押して下さい");
			String enter = scan.next();
			System.out.println("ターン：" + turn);
			turn++;
			h.attack(m);
			maouHp = m.getHp();
			if(maouHp == 200) {
				System.out.println("魔王が進化する！");
				break;
			}
			m.attack(h);
			heroHp = h.getHp();
			if(heroHp == 0) {
				System.out.println("魔王の勝利！");
				break;
			}
		}
	}



}
