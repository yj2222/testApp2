package testApp;

import java.util.Random;
import java.util.Scanner;

public class Main {

	String[] swordName = {"銅の剣", "炎の剣", "ひのきのぼう", "伝説の剣"};

	public static void main(String[] args) {
		
		//Heroの名前を決める。
		Hero h = inputHeroName();
		userOperation();

        //Swordのガチャメソッド呼び出し。
        Sword sw = gacha();
        h.setSw(sw);
        userOperation();

        //Maouの名前を決める。
        Maou m = inputMaouName();
        userOperation();

        // battle開始メソッド。
        battle(h, m);
        userOperation();
        
        //Maou進化メソッド呼び出し。
        DaiMaou dm = maouEvolution(m);
        userOperation();
        
        // finalBattle、最終決戦メソッド。
        finalBattle(h, dm);

	}

	// HeroNameを入力させるメソッド。
	public static Hero inputHeroName() {
		Scanner scan = new Scanner(System.in);
		Hero h = new Hero();
		System.out.println("勇者の名前を入力してください");
        boolean check = true;
        while (check) {
        	String heroName = scan.nextLine();
        	check = checkHeroName(heroName, h);
        }
		return h;		
	}
	
	// MaouNameを入力させるメソッド。
	private static Maou inputMaouName() {
		Scanner scan = new Scanner(System.in);
		Maou m = new Maou();
        System.out.println("魔王の名前を入力してください");
        boolean check = true;
        while (check) {
        	String maouName = scan.nextLine();
        	check = checkMaouName(maouName, m);
        }
		return m;
	}

	//enterを入力させる。処理を区切って確認するため。
	private static void userOperation() {
		System.out.println("■■■enterで次に進みます。■■■");
		new java.util.Scanner(System.in).nextLine();
	}

	//HeroName文字数チェック
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

	// Swordガチャメソッド。
	static Sword gacha() {
		Random rand = new Random();
	    int i = rand.nextInt(4);
	    System.out.println("info:ガチャ開始・・・" + i + "番を引きました。");
	    Sword sw = new Sword();

	    // Randomな番号を指定してコントラスタを呼び出し。
	    switch(i){
	    case 0:
	    	sw.sword("銅の剣", 100, 80);	    	
		break;
	    case 1:
			sw.sword("炎の剣", 200, 50);
		break;
	    case 2:
			sw.sword("ひのきのぼう", 40, 100);
		break;
	    case 3:
			sw.sword("伝説の剣", 400, 100);
		break;
	   }
	   return sw;
	}

	 // MaouNameの文字数チェック
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
	 
	 // battleメソッド。魔王HP200になるまで使用。
	 static void battle(Hero h, Maou m) {
		System.out.println("バトル開始！！！");

		int heroHp = h.getHp();
		int maouHp = m.getHp();

		int turn = 0;
		while(true) {
			userOperation();
			System.out.println("ターン：" + turn);
			turn++;
			h.attack(m);
			maouHp = m.getHp();
			if(maouHp == 200) {
				System.out.println("っっっっっっ魔王が進化する！！！！！！！！！爆風が吹き荒れる！");
				m.stormAttack(h);
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
	
	// DaiMaou進化メソッド。
	static DaiMaou maouEvolution(Maou m) {
		DaiMaou dm = new DaiMaou();
        dm.setHp(m.getHp() + 1000);
        String daiMaouName = "【大魔王】" + m.getName();
        dm.setName(daiMaouName);
        System.out.println(dm.getName() + "の残りHP＝" + dm.getHp());
        return dm;
	}

	// finalBattle、最終決戦メソッド。
	static void finalBattle(Hero h, DaiMaou dm) {
		System.out.println("最終決戦！！！");

		int heroHp = h.getHp();
		int maouHp = dm.getHp();

		int turn = 0;
		while(true) {
			userOperation();
			System.out.println("最終決戦ターン：" + turn);
			turn++;
			h.attack(dm);
			maouHp = dm.getHp();
			if(maouHp == 0) {
				System.out.println("★★★★★★★★★★");
				System.out.println("★勇者の勝利！★");
				System.out.println("★★★★★★★★★★");
				break;
			}
			dm.attack(h);
			heroHp = h.getHp();
			if(heroHp == 0) {
				System.out.println("♦♦♦♦♦♦♦♦♦♦");
				System.out.println("♦魔王の勝利♦");
				System.out.println("♦♦♦♦♦♦♦♦♦♦");
				break;
			}
		}
	}

}
