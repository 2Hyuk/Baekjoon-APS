
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int row, col, dist;
		int isBreak;

		public Node(int row, int col, int dist, int isBreak) {
			this.row = row;
			this.col = col;
			this.dist = dist;
			this.isBreak = isBreak;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dr = { 0, -1, 0, 1 };
		int[] dc = { -1, 0, 1, 0 };
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[][] map = new String[N][M];
		boolean[][][] check = new boolean[2][N][M];
		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().split("");
		}
		int minDist = Integer.MAX_VALUE;
		Queue<Node> queue = new LinkedList<>();

		queue.offer(new Node(0, 0, 1, 0));

		while (!queue.isEmpty()) {
			Node move = queue.poll();

			if (move.row == N - 1 && move.col == M - 1) {
				minDist = move.dist;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nr = move.row + dr[i];
				int nc = move.col + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				if (map[nr][nc].equals("1") && move.isBreak == 0 && check[1][nr][nc] == false) {
					queue.offer(new Node(nr, nc, move.dist + 1, 1));
					check[1][nr][nc] = true;
				}

				else if (map[nr][nc].equals("0") && check[move.isBreak][nr][nc] == false) {
					queue.offer(new Node(nr, nc, move.dist + 1, move.isBreak));
					check[move.isBreak][nr][nc] = true;
				}
			}
		}

		if (minDist == Integer.MAX_VALUE)
			minDist = -1;

		System.out.println(minDist);
	}
}
