package _RPG;

import java.util.ArrayList;

interface Element {
	Unit changePower(Unit u);
}

class Water implements Element {

	@Override
	public Unit changePower(Unit u) {
		u.hp += 40;
		u.maxHp += 40;
		u.power -= 5;
		u.defend -= 5;
		u.speed += 5;
		return null;
	}

}

//Class Test () {
//	Monster_List m = new Monster_List();
//	Unit testmon = m.monsterList.get(1);
//	testmon.element = 
//}


class Ground implements Element {

	@Override
	public Unit changePower(Unit u) {
		u.hp += 20;
		u.maxHp += 20;
		u.defend += 5;
		u.speed -= 5;
		return null;
	}

}

class Air implements Element {

	@Override
	public Unit changePower(Unit u) {
		u.power += 10;
		u.defend -= 20;
		u.speed += 10;
		return null;
	}

}
