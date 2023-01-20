package _RPG;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameBattle extends Game_Manager_TEST {

	Scanner sc = new Scanner(System.in);
	Random rd = new Random();

	boolean firstAtk(int p, int m) {
		if (p > m) {
			return true;
		} else {
			System.out.printf("몬스터의 스피드가 더 빠르다 [몬스터의 선공] \n\n");
			return false;
		}
	}
	
	void Battle(Unit p, Unit m) {
		
		if (boss) {
			System.out.println("[보스 몬스터를 만났다]");
		} else {
			System.out.println("[몬스터를 만났다]");
		}

//		boolean turn = p1.speed > m1.speed ? true : false;
		boolean turn = firstAtk(p.speed, m.speed);

		while (true) {
			if (turn) {
				System.out.println(p.UnitInfo());
				System.out.println(m.UnitInfo() + "\n");

				System.out.println("[플레이어 차례]");
				System.out.println("[1]공격 [2]스킬 [3]아이템");
				int sel = sc.nextInt();
				if (sel == 1) {
					p.attack(m);
				} else if (sel == 2) {
					p.skill(m);
				} else if (sel == 3) {
					p.useItem();
					continue;
				} else {

				}
				turn = false;
				System.out.println();
			} else {
				if (0 != rd.nextInt(3)) {
					m.attack(p);
				} else {
					m.skill(p);
				}
				turn = true;
				System.out.println();
			}
			if (m.isDead()) {
				if (boss == true) {
					System.out.println(m.name + "는 쓰러졌습니다.");
					System.out.println("[스테이지클리어]");
					boss = false;
					win = true;
					break;
				} else {
					System.out.println(m.name + "는 쓰러졌습니다.");
					p.levelUp();
					p.item++;
					break;
				}
			}
			if (p.isDead()) {
				System.out.println(p.name + "는 쓰러졌습니다.");
				life = false;
				break;
			}

		}
	}

}
