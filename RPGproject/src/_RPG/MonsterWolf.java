package _RPG;

public class MonsterWolf extends Unit {
	String skill = "물어뜯기";

	MonsterWolf() {
		super("Wolf", 190, 30, 80, 50, 75);

	}

	@Override
	public String toString() {
		return name + " hp : " + hp + "/" + maxHp + "";
	}

	@Override
	void skill(Unit u) {
		double rdAtk = rd.nextInt(31) / 100.0 + 1; // 공격력 100~130%
		double atk = power * rdAtk - u.defend;
		u.hp -= atk;
		System.out.printf("[%s]가 [%s]에게 [%s] 사용 %.1f 의 데미지\n", name, u.name, skill, atk);
		System.out.printf("%s의 체력 [%d/%d]\n", u.name, u.hp, u.maxHp);
	}

}
