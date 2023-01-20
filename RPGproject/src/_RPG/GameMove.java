package _RPG;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameMove extends Game_Manager_TEST {

	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	GameMove(Unit u){
		this.u = u;
	}
	Unit u;
	GameBattle b = new GameBattle();

	void monsterCheck(int Y, int X) {
		if (Game_Manager_TEST.f.map[2 - Y][2 - X] != 0) {
			System.out.println("========= [ 전투 ]==========");
			Monster_List mon = new Monster_List();
			Unit m = mon.monsterList.get(rd.nextInt(mon.monsterList.size()));
			if (boss) {
				m.boss();
			}
			System.out.println(m.UnitInfo());
			m.element = Element_List.instance.elementlist.get(rd.nextInt(3));
			m.element.changePower(m);
			System.out.println(m.UnitInfo());
			b.Battle(player, m);
		}
	}

	void bossSpown() { //
		int cnt = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (f.map[i][j] == 8) {
					cnt++;
				}
			}
		}
		if (cnt == 0 && boss == false) {
			f.map[0][2] = 9;
			boss = true;
		}
	}

	void moveUpSide(int Y, int X) {
		int[][] temp = new int[SIZE][SIZE];
		f.map[2][2] = 0;
		for (int i = 0; i < SIZE; i++) {
			if (i == SIZE - 1) {
				for (int j = 0; j < SIZE; j++) {
					temp[0][j] = f.map[i][j];
				}
			} else {
				for (int j = 0; j < SIZE; j++) {
					temp[i + Y][j + X] = f.map[i][j];

				}
			}
		}
		temp[2][2] = 1;
		f.map = temp;
		bossSpown();
	}

	void moveDownSide(int Y, int X) {
		int[][] temp = new int[SIZE][SIZE];
		f.map[2][2] = 0;
		for (int i = 0; i < SIZE; i++) {
			if (i == 0) {
				for (int j = 0; j < SIZE; j++) {
					temp[SIZE - 1][j] = f.map[i][j];
				}
			} else {
				for (int j = 0; j < SIZE; j++) {
					temp[i + Y][j + X] = f.map[i][j];

				}
			}
		}
		temp[2][2] = 1;
		f.map = temp;
		bossSpown();
	}

	void moveLeftSide(int Y, int X) {
		int[][] temp = new int[SIZE][SIZE];
		f.map[2][2] = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (j == SIZE - 1) {
					temp[i][0] = f.map[i][j];
				} else {
					temp[i + Y][j + X] = f.map[i][j];
				}
			}
		}
		temp[2][2] = 1;
		f.map = temp;
		bossSpown();
	}

	void moveRightSide(int Y, int X) {
		int[][] temp = new int[SIZE][SIZE];
		f.map[2][2] = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (j == 0) {
					temp[i][SIZE - 1] = f.map[i][j];
				} else {
					temp[i + Y][j + X] = f.map[i][j];
				}
			}
		}
		temp[2][2] = 1;
		f.map = temp;
		bossSpown();
	}
}
