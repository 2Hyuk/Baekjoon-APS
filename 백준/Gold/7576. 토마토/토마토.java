
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Tomato {
		int row;
		int col;
		int time;

		public Tomato(int row, int col, int time) {
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}

	static int M; // 가로칸
	static int N; // 세로칸
	static String[][] tomato;
	static Queue<Tomato> queue = new LinkedList<>();
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new String[N][M];

		for (int i = 0; i < N; i++) {
			tomato[i] = br.readLine().split(" ");
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j].equals("1")) {
					tomato[i][j] = "1";
					queue.offer(new Tomato(i, j, 0));
				}
			}
		}
		int day = -1;
		while (!queue.isEmpty()) {
			Tomato tomato = queue.poll();
			day = Math.max(day, tomato.time);
			bfs(tomato.row, tomato.col, tomato.time);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tomato[i][j].equals("0"))
					day = -1;
			}
		}
		System.out.println(day);
	}

	static void bfs(int row, int col, int time) {

		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;

			if (tomato[nr][nc].equals("0")) {
				tomato[nr][nc] = "1";
				queue.offer(new Tomato(nr, nc, time + 1));
			}
		}
	}

}
