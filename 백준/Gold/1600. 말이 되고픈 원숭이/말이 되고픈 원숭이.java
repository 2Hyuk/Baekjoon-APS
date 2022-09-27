
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int row, col, movement, likeHorse;

		public Node(int row, int col, int movement, int likeHorse) {
			this.row = row;
			this.col = col;
			this.movement = movement;
			this.likeHorse = likeHorse;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] dr = { 0, -1, 0, 1 };
		int[] dc = { -1, 0, 1, 0 };
		int[] drc = { -1, 1 };
		boolean[][][] visited = new boolean[K + 1][H][W];
		String[][] map = new String[H][W];
		for (int i = 0; i < H; i++) {
			map[i] = br.readLine().split(" ");
		}
		int minMovement = Integer.MAX_VALUE;
		Queue<Node> queue = new LinkedList<>();

		visited[0][0][0] = true;
		queue.offer(new Node(0, 0, 0, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.row == H - 1 && node.col == W - 1) {
				minMovement = node.movement;
				break;
			}
			// 상하좌우 이동
			for (int i = 0; i < 4; i++) {
				int nr = node.row + dr[i];
				int nc = node.col + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= H || nc >= W)
					continue;

				if (map[nr][nc].equals("0") && visited[node.likeHorse][nr][nc] == false) {
					visited[node.likeHorse][nr][nc] = true;
					queue.offer(new Node(nr, nc, node.movement + 1, node.likeHorse));
				}
			}
			// 말처럼 이동하는 경우
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 2; j++) {
					int hr = node.row + 2 * dr[i];
					int hc = node.col + 2 * dc[i];
					if (i % 2 == 0)
						hr += drc[j];
					else 
						hc += drc[j];

					if (hr < 0 || hc < 0 || hr >= H || hc >= W)
						continue;

					if (node.likeHorse < K && map[hr][hc].equals("0") && visited[node.likeHorse + 1][hr][hc] == false) {
						visited[node.likeHorse + 1][hr][hc] = true;
						queue.offer(new Node(hr, hc, node.movement + 1, node.likeHorse + 1));
					}

				}
			}
		}
		if (minMovement == Integer.MAX_VALUE)
			minMovement = -1;
		System.out.println(minMovement);
	}
}
