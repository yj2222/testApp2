package testApp;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	String[] swordName = {"銅の剣", "炎の剣", "ひのきのぼう", "伝説の剣"};

	public static void main(String[] args) {
		
		Hero h = new Hero();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("勇者の名前を入力してください");
        
        boolean check = true;
        while (check) {
        	String heroName = scan.next();
        	check = checkHeroName(heroName, h);
        }
        
        Sword sw = gacha();
        h.setSw(sw);
        
        
        Maou m = new Maou();
        System.out.println("魔王の名前を入力してください");
        
        check = true;
        while (check) {
        	String maouName = scan.next();
        	check = checkMaouName(maouName, m);
        }
        
        System.out.println("バトル開始！！！");
        
        int heroHp = h.getHp();
        int maouHp = m.getHp();
        
		while(heroHp <= 0) {
			h.attack(m);
			m.attack(h);
		}
        
//        while(!(heroHp <= 0) || !(maouHp <= 0)) {
//        	h.attack(m);
//        	m.attack(h);
//        }
        
//        if(heroHp >= 0 || maouHp >= 0) {
//        	h.attack(m);
//        	m.attack(h);
//        }
//        
        
        
		
        
	}
	
	 static boolean checkHeroName(String heroName, Hero h) {
		 if(heroName.length() >= 11) {
			 System.out.println("名前が⾧すぎます 10 文字以内で入力 してください");
			 return true;
		 } else if(heroName.length() <= 1) {
			 System.out.println("名前が短すぎます、もう一度入力 してください");
			 return true;
		 } else {
			 System.out.println("名前 を" + heroName + "にしました");
			 h.setName(heroName);
			 return false;
		 }
	 }
	 
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

	static Sword gacha() {
		Random rand = new Random();
	    int i = rand.nextInt(4);
	    System.out.println(i);
	    
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

}
