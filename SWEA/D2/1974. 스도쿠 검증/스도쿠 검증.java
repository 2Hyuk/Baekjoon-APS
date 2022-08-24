
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			arr = new int[9][9];
			for (int row = 0; row < 9; row++) {
				st = new StringTokenizer(br.readLine());
				for (int col = 0; col < 9; col++) {
					arr[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + tc + " " + check());
		}
	}

	static int check() {
		// 가로
		for (int i = 0; i < 9; i++) {
			boolean[] check = new boolean[10];
			for (int j = 0; j < 9; j++) {
				if (check[arr[i][j]]) {
					return 0;
				}
				check[arr[i][j]] = true;
			}
		}
		// 세로
		for (int j = 0; j < 9; j++) {
			boolean[] check = new boolean[10];
			for (int i = 0; i < 9; i++) {
				if (check[arr[i][j]]) {
					return 0;
				}
				check[arr[i][j]] = true;
			}
		}
		// 박스
		for(int i = 0; i < 9; i += 3) {
			for(int j = 0; j < 9; j += 3) {
				int startRow = i;
				int startCol = j;
				boolean[] check = new boolean[10];
				for(int r = startRow; r < startRow+3; r++) {
					for(int c = startCol; c < startCol+3; c++) {
						if(check[arr[r][c]])
							return 0;
						check[arr[r][c]] = true;
					}
				}
			}
		}
		return 1;
	}
}
