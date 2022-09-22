
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int map[][] = new int[10][10];
	static int[] paper = new int[6];
	static int minCnt;
	static int pointCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] visited = new boolean[10][10];
		StringTokenizer st;

		int firstRow = -1;
		int firstCol = -1;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				int state = Integer.parseInt(st.nextToken());
				map[i][j] = state;
				if (state == 1) {
					pointCnt++;
				}
				if (state == 1 && firstRow == -1 && firstCol == -1) {
					firstRow = i;
					firstCol = j;
				}
			}
		}
		if (pointCnt == 0) {
			System.out.println(0);
		} else {
			minCnt = Integer.MAX_VALUE;
			Arrays.fill(paper, 5);
			backtracking(0, firstRow, firstCol);
			if (minCnt == Integer.MAX_VALUE) {
				minCnt = -1;
			}
			System.out.println(minCnt);
		}
	}

	static void backtracking(int cnt, int row, int col) {
		if (cnt == pointCnt) {
			minCnt = Math.min(minCnt, sumPaper());
			return;
		}

		if (row == -1 || col == -1) {
			return;
		}

		for (int i = 5; i >= 1; i--) {
			if (row + i <= map.length && col + i <= map.length && check(row, col, i) && paper[i] > 0) {
				paper[i] -= 1;
				changeMap(row, col, i, 0);
				int[] xy = findOne(row, col);
				backtracking(cnt + i * i, xy[0], xy[1]);
				changeMap(row, col, i, 1);
				paper[i] += 1;
			}

		}
	}

	static int[] findOne(int row, int col) {

		for (int i = row; i < map.length; i++) {
			for (int j = col; j < map.length; j++) {
				if (map[i][j] == 1) {
					return new int[] { i, j };
				}
			}
			col = 0;
		}
		return new int[] { -1, -1 };
	}

	static boolean check(int row, int col, int size) {
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (map[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	static void changeMap(int row, int col, int size, int num) {
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				map[i][j] = num;
			}
		}
	}

	static int sumPaper() {
		int sum = 0;
		for (int i = 1; i <= 5; i++) {
			sum += paper[i];
		}

		return 25 - sum;
	}
}
