package _RPG;

public class PlayerHunter extends Unit {

	String skill = "정조준";

	PlayerHunter() {
		super("Hunter", 240, 70, 95, 45, 85);
		this.item = 1;
	}

	@Override
	public String toString() {
		return name + " hp : " + hp + "/" + maxHp + "";
	}

	@Override
	void skill(Unit u) {
		double rdAtk = (rd.nextInt(20) + 21) / 100.0 + 1; // 공격력 120~140%
		double atk = power * rdAtk - u.defend;
		u.hp -= atk;
		System.out.printf("[%s]가 [%s]에게 [%s] 사용 %.1f 의 데미지\n", name, u.name, skill, atk);
		if (0 != rd.nextInt(3)) { // 66%
			System.out.println("!급소를 맞췄다 추가 데미지 +10");
			u.hp -= 10;
		}
		System.out.printf("%s의 체력 [%d/%d]\n", u.name, u.hp, u.maxHp);
	}

}
