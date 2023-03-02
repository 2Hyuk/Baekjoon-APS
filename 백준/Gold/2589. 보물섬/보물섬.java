import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Land {
		int curRow;
		int curCol;

		public Land(int curRow, int curCol) {
			this.curRow = curRow;
			this.curCol = curCol;
		}
	}

	static int row;
	static int col;
	static String[][] arr;
	static boolean[][] visited;
	static int answer;
	static int[] rowDir = {0, -1, 0, 1};
	static int[] colDir = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		arr = new String[row][col];
		answer = 0;

		for (int i = 0; i < row; i++) {
			arr[i] = br.readLine().split("");
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if ("L".equals(arr[i][j])) {
					visited = new boolean[row][col];
					bfs(i, j);
				}
			}
		}

		System.out.println(answer);
	}

	public static void bfs(int startRow, int startCol) {
		Queue<Land> queue = new ArrayDeque<>();

		visited[startRow][startCol] = true;
		queue.offer(new Land(startRow, startCol));

		int time = 0;

		while (!queue.isEmpty()) {
			time++;
			int size = queue.size();

			for (int i = 0; i < size; i++) {

				Land land = queue.poll();

				for (int j = 0; j < 4; j++) {
					int nr = land.curRow + rowDir[j];
					int nc = land.curCol + colDir[j];

					if (nr < 0 || nr >= row || nc < 0 || nc >= col || visited[nr][nc] || !"L".equals(arr[nr][nc])) {
						continue;
					}

					queue.offer(new Land(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}

		answer = Math.max(answer, time - 1);
	}
}
