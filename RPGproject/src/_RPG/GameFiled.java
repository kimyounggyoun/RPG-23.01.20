package _RPG;

public class GameFiled  {
	int map[][];

	void printGameMap() {
		System.out.println("┌───── M A P ─────┐");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (j == 0) {
					System.out.print("│ ");
				}
				if (map[i][j] == 0) {
					System.out.print("[ ]");
				} else if (map[i][j] == 1) {
					System.out.print("[H]");
				} else if (map[i][j] == 8) {
					System.out.print("[M]");
				} else if (map[i][j] == 9) {
					System.out.print("[B]");
				}
			}
			System.out.println(" │");
		}
		System.out.println("└─────────────────┘");
	}
}
