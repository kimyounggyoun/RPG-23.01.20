package _RPG;

public class MonsterBat extends Unit {
	String skill = "흡혈";

	MonsterBat() {
		super("Bat", 110, 0, 70, 45, 90);
	}

	@Override
	public String toString() {
		return name + " hp : " + hp + "/" + maxHp + "";
	}

	@Override
	void skill(Unit u) {
		double rdAtk = (rd.nextInt(10) + 11) / 100.0 + 1; // 공격력 110~120%
		double atk = power * rdAtk - u.defend;
		u.hp -= atk;
		if (hp + 10 < maxHp) {
			hp += 10;
		} else {
			hp = maxHp;
		}
		System.out.printf("[%s]가 [%s]에게 [%s] 사용 %.1f 의 데미지\n", name, u.name, skill, atk);
		System.out.printf("%s의 체력 [%d/%d]\n", u.name, u.hp, u.maxHp);
		System.out.printf("%s의 체력 10 회복\n", name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
