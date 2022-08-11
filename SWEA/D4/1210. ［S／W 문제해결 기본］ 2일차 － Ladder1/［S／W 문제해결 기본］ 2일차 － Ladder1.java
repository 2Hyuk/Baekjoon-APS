
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] ladder = new int[100][100];

		for (int i = 1; i <= 10; i++) {
			int T = Integer.parseInt(br.readLine());
			// ladder map 생성
			for (int row = 0; row < 100; row++) {
				st = new StringTokenizer(br.readLine());
				for (int col = 0; col < 100; col++) {
					ladder[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			// 도착지점 찾기
			int endPoint = 0;
			for (int col = 0; col < 100; col++) {
				if (ladder[99][col] == 2) {
					endPoint = col;
					break;
				}
			}
			// 도착지점으로부터 위로 올라가면서 출발지점을 찾는다.
			int startPoint;
			int curRow = 99;
			int curCol = endPoint;
			int[] dr = { 0, 0, -1 };
			int[] dc = { -1, 1, 0 };
			while (true) {

				for (int j = 0; j < 3; j++) {
					int nr = curRow + dr[j];
					int nc = curCol + dc[j];
					if (nc >= 0 && nc <= 99 && nr >= 0 && ladder[nr][nc] == 1) {
						curRow = nr;
						curCol = nc;
						ladder[curRow][curCol] = 0;
						break;
					}
				}
//			// 1. 왼쪽
//			if (curCol != 0 && ladder[curRow][curCol - 1] == 1) {
//				curCol -= 1;
//			}
//			// 2. 오른쪽
//			else if (curCol != 99 && ladder[curRow][curCol + 1] == 1) {
//				curCol += 1;
//			}
//			// 3. 위
//			else if (curRow != 0 && ladder[curRow - 1][curCol] == 1) {
//				curRow -= 1;
//			}
//			ladder[curRow][curCol] = 0;
				if (curRow == 0) {
					startPoint = curCol;
					break;
				}
			}
			System.out.println("#" + i + " " + startPoint);
		}
	}
}
