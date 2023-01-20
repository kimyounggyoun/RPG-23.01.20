package _RPG;

import java.util.ArrayList;

public class Monster_List {
//	static Monster_List mlist = new Monster_List();

	ArrayList<Unit> monsterList = new ArrayList<Unit>();

	public Monster_List() {
		monsterList.add(new MonsterBat());
		monsterList.add(new MonsterWolf());
	}

}
