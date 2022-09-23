
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
		int height;
		int time;

		public Tomato(int row, int col, int height, int time) {
			this.row = row;
			this.col = col;
			this.height = height;
			this.time = time;
		}
	}

	static int M; // 가로칸
	static int N; // 세로칸
	static int H; // 높이
	static String[][][] tomato;
	static Queue<Tomato> queue = new LinkedList<>();
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	static int[] dh = { -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomato = new String[N][M][H];

		for(int h = 0; h < H; h++) {	
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					tomato[i][j][h] = st.nextToken();
				}
			}
		}
		

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tomato[i][j][h].equals("1")) {
						queue.offer(new Tomato(i, j, h, 0));
					}
				}
			}
		}

		int day = -1;
		while (!queue.isEmpty()) {
			Tomato tomato = queue.poll();
			day = Math.max(day, tomato.time);
			bfs(tomato.row, tomato.col, tomato.height, tomato.time);
		}

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tomato[i][j][h].equals("0"))
						day = -1;
				}
			}
		}
		System.out.println(day);
	}

	static void bfs(int row, int col, int height, int time) {

		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;

			if (tomato[nr][nc][height].equals("0")) {
				tomato[nr][nc][height] = "1";
				queue.offer(new Tomato(nr, nc, height, time + 1));
			}

		}

		for (int i = 0; i < 2; i++) {
			int nh = height + dh[i];

			if (nh < 0 || nh >= H)
				continue;
			if (tomato[row][col][nh].equals("0")) {
				tomato[row][col][nh] = "1";
				queue.offer(new Tomato(row, col, nh, time + 1));
			}
		}
	}

}
