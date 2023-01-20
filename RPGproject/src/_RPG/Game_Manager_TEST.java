package _RPG;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game_Manager_TEST {

	Scanner sc = new Scanner(System.in);
	Random rd = new Random();

	static GameFiled f = new GameFiled();
	static Unit player;
	static GameMove m = new GameMove(player);
	
	int[] mY = { 1, -1, 0, 0 }; // 플레이어 이동 -> 화면이동 기준
	int[] mX = { 0, 0, 1, -1 };
	int yx[];
	int cnt;
	static boolean life;
	static boolean win;
	static boolean boss;

	final int SIZE = 5;

	void init() {
		System.out.println("[0.Hunter][1.Print]");
		player =  Player_List.plist.playerList.get(sc.nextInt());
		f.map = new int[SIZE][SIZE];
		life = true;
		yx = new int[2];
		yx[0] = 2;
		yx[1] = 2;
		f.map[yx[0]][yx[1]] = 1;
		for (int i = 0; i < SIZE; i++) {
			int temp = rd.nextInt(5);
			if (i == 2 && temp == 2) {
				temp += 1;
			}
			for (int j = 0; j < SIZE; j++) {
				if (temp == j) {
					f.map[i][j] = 8;
				}
			}
		}
	}

	void mainMenu() {
		while (true) {
			f.printGameMap();
			System.out.println(player.UnitInfo());
			System.out.println();
			System.out.println("   [w][e]   w,a,s,d : 이동  ");
			System.out.println("[a][s][d]   e : 아이템사용   ");
			System.out.println("[z]         z : 종료        ");

			String sel = sc.next();
			if (sel.equals("z")) {
				break;
			} else if (sel.equals("e")) {
				System.out.printf("보유 개수 : %d \n", player.item);
				if (player.item == 0) {
					continue;
				} else {
					player.useItem();
				}
			} else if (sel.equals("e")) { // 이동할때 전투를 먼저하고 결과자릿값 0

			} else if (sel.equals("w")) { // 위로이동
				m.monsterCheck(mY[0], mX[0]);
				m.moveUpSide(mY[0], mX[0]);

			} else if (sel.equals("s")) { // 아래로이동
				m.monsterCheck(mY[1], mX[1]);
				m.moveDownSide(mY[1], mX[1]);

			} else if (sel.equals("a")) { // 왼쪽이동
				m.monsterCheck(mY[2], mX[2]);
				m.moveLeftSide(mY[2], mX[2]);

			} else if (sel.equals("d")) { // 오른쪽이동
				m.monsterCheck(mY[3], mX[3]);
				m.moveRightSide(mY[3], mX[3]);

			} else {
				System.out.println("!잘 못 된 입력입니다");
			}

			if (!life || win) {
				break;
			}
		}
	}

	void run() {
		init();
		mainMenu();
		if (life == false) {
			System.out.println("게임오버");
			return;
		}
		if (win == true) {
			System.out.println("보스를 잡았다!");
			return;
		}
	}

}
