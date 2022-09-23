
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static class Node {
		int row;
		int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static int N;
	static String[][] map;
	static List<Integer> list;
	static Queue<Node> queue;
	static int buildngCnt;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		list = new ArrayList<>();
		queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				buildngCnt = 0;
				if (map[i][j].equals("1")) {
					map[i][j] = "0";
					buildngCnt++;
					bfs(i, j);
					list.add(buildngCnt);
					buildngCnt = 0;
					
				}
			}
		}
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for(int i : list) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb);
		
	}

	public static void bfs(int r, int c) {

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;

			if (map[nr][nc].equals("1")) {
				map[nr][nc] = "0";
				buildngCnt++;
				queue.offer(new Node(nr, nc));
			}
		}
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			bfs(node.row, node.col);
		}

	}
}
