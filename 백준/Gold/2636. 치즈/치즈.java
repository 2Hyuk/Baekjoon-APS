import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static String[][] board;
	static int N, M, answer;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열

		board = new String[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				if (board[i][j].equals("1")) {
					answer++;
				}
			}
		}
		queue = new LinkedList<>();
		board[0][0] = "2";
		queue.offer(new int[] { 0, 0 });
		spreadAir();

		int time = 0;
		while (true) {
			time++;
			int meltCnt = meltingCheese();

			if (answer - meltCnt == 0)
				break;
			
			answer -= meltCnt;
			spreadAir();
		}
		
		System.out.println(time);
		System.out.println(answer);
	}

	public static int meltingCheese() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j].equals("1")) {
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (board[nr][nc].equals("2")) {
							queue.offer(new int[] {i, j});
							count++;
							break;
						}
					}
				}
			}
		}
		return count;
	}

	public static void spreadAir() {
		while (!queue.isEmpty()) {
			int[] rc = queue.poll();
			board[rc[0]][rc[1]] = "2";
			
			for (int i = 0; i < 4; i++) {
				int nr = rc[0] + dr[i];
				int nc = rc[1] + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || !board[nr][nc].equals("0"))
					continue;

				queue.offer(new int[] { nr, nc });
				board[nr][nc] = "2";
			}
		}
	}
}
