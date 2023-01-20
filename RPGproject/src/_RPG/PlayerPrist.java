package _RPG;

public class PlayerPrist extends Unit {
	String skill = "회복";

	PlayerPrist() {
		super("Prist", 190, 110, 70, 55, 65);
		item = 1;
	}

	@Override
	public String toString() {
		return name + " hp : " + hp + "/" + maxHp + "";
	}
	
	@Override
	void skill(Unit u) {
		double rdAtk = (rd.nextInt(20) - 20) / 100.0 + 1; // 공격력 80~100% 회복
		double atk = power * rdAtk;
		u.hp += atk;
		if (u.hp > u.maxHp) {
			u.hp = u.maxHp;
		}
		System.out.printf("[%s]가 [%s]에게 [%s] 사용 %.1f 의 회복\n", name, u.name, skill, atk);
		if (u.hp < u.maxHp / 2) { // 50%
			System.out.println("!추가 회복 +20");
			u.hp += 20;
		}
		System.out.printf("%s의 체력 [%d/%d]\n", u.name, u.hp, u.maxHp);
	}


		
	


}
