
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int w;
	static int h;
	static int[][] arr;
	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			arr = new int[h + 2][w + 2];

			for (int r = 1; r < 1 + h; r++) {
				for (int c = 1; c < 1 + w; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			int[] rc = nextXY(1, 1);
			int row = rc[0];
			int col = rc[1];
			int landCnt = 0;
			while (true) {
				if (row == -1 && col == -1)
					break;
				findLand(row, col);
				landCnt++;
				rc = nextXY(row, col);
				row = rc[0];
				col = rc[1];
			}
			System.out.println(landCnt);
		}
	}

	static void findLand(int row, int col) {
		arr[row][col] = 0;
		for (int i = 0; i < 8; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			if (nr < 1 || nr > h || nc < 1 || nc > w)
				continue;
			if (arr[nr][nc] == 1) {
				findLand(nr, nc);
			}
		}

	}

	static int[] nextXY(int row, int col) {
		for (int i = row; i <= h; i++) {
			for (int j = col; j <= w; j++) {
				if (arr[i][j] == 1) {
					return new int[] { i, j };
				}
			}
			col = 1;
		}
		return new int[] { -1, -1 };
	}

	static void print() {
		for (int[] i : arr) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println();
	}
}
