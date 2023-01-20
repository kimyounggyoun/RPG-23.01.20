package _RPG;

import java.util.ArrayList;

public class Player_List {

	ArrayList<Unit> playerList = new ArrayList<Unit>();

	static Player_List plist = new Player_List();

	public Player_List() {
		playerList.add(new PlayerHunter());
		playerList.add(new PlayerPrist());
	}

}
