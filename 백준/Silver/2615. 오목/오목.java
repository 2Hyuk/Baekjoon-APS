import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] map = new int[21][21]; // 0 ~ 20 이며, 0과 20은 비워둠

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 방향벡터, 오목 찾는 경우
		int[] dr = { 0, 1, 1, 1 };
		int[] dc = { 1, 1, 0, -1 };
		// 반대편 있나 없나 확인용
		int[] rdr = { 0, -1, -1, -1 };
		int[] rdc = { -1, -1, 0, 1 };

		// 맵 입력
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int winner = 0;
		int row = 0;
		int col = 0;
		// 하나씩 탐색
		loop: for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				if (map[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						int color = map[i][j];
						int nr = i;
						int nc = j;
						row = i;
						col = j;
						if (map[nr + rdr[k]][nc + rdc[k]] == color)
							continue;
						int cnt = 1;
						while (true) {
							nr = nr + dr[k];
							nc = nc + dc[k];
							if (map[nr][nc] == color) {
								cnt++;
								if(cnt == 5) {
									if(col > nc) {
										row = nr;
										col = nc;
									}
								}
							} 
							else {
								break;
							}
							
						}
						if (cnt == 5) {
							winner = map[i][j];
							break loop;
						}
					}
				}
			}
		}
		System.out.println(winner);
		if (winner != 0) {
			System.out.print(row + " " + col);
		}
	}
}
