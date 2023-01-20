package _RPG;

import java.util.Random;
import java.util.Scanner;

abstract public class Unit {

	Scanner sc = new Scanner(System.in);

	Random rd = new Random();
	String name;
	int level = 1;
	int maxHp;
	int maxMp;
	int hp;
	int mp;
	int power;
	int defend;
	int speed;
	int item;
	Element element;

	public Unit(String name, int hp, int mp, int power, int defend, int speed) {
		super();
		this.name = name;
		this.maxHp = hp;
		this.maxMp = mp;
		this.hp = hp;
		this.mp = mp;
		this.power = power;
		this.defend = defend;
		this.speed = speed;

	}

	void attack(Unit unit) {
		double rdAtk = (rd.nextInt(21) - 10) / 100.0 + 1; // 공격력 90~110%
		double atk = power * rdAtk - unit.defend;
		unit.hp -= atk;

		System.out.printf("[%s]가 [%s]에게 [%.1f] 데미지 공격\n", name, unit.name, atk);
		System.out.printf("%s의 체력 [%d/%d]\n", unit.name, unit.hp, unit.maxHp);
	}

	void useItem() {
		if (item == 0) {
			System.out.println("아이템이 없습니다.");
			return;
		} else {
			System.out.print("[1.사용][0.취소]\n");
			int itemSel = sc.nextInt();
			if (itemSel == 0) {
				return;
			} else if (itemSel == 1) {
				System.out.println("HP가 50% 회복되었다");
				item -= 1;
				hp += maxHp / 2;
				if (hp > maxHp) {
					hp = maxHp;
				}
			} else {

			}
		}
	}

	void levelUp() {
		level++;
		power++;
		defend++;
		speed++;
		maxHp += 10;
		maxMp += 5;
	}

	void boss() {
		name = "Boss_" + name;
		power += 40;
		defend += 40;
		speed += 20;
		maxHp *= 2;
		hp = maxHp;
		maxMp *= 2;
		mp = maxMp;
	}

	abstract void skill(Unit unit);

	boolean isDead() {
		if (hp <= 0) {
			System.out.printf("[%s]는 체력이 없습니다\n", name);
			return true;
		}
		return false;
	}

	public String UnitInfo() {
		return name + " : [Lv." + level + "] [HP:" + hp + "/" + maxHp + "] " + "[MP:" + mp + "/" + maxMp + "] "//
				+ "[ATT:" + power + "] " + "[DEF:" + defend + "] " + "[SPD:" + speed + "]";
	}
}
