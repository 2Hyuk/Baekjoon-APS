
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Bridge implements Comparable<Bridge> {
		int st, ed, length;

		public Bridge(int st, int ed, int length) {
			this.st = st;
			this.ed = ed;
			this.length = length;
		}

		@Override
		public int compareTo(Bridge o) {
			// TODO Auto-generated method stub
			return this.length - o.length;
		}

	}

	static int N, M;
	static String[][] map;
	static boolean[][] visited;
	static PriorityQueue<Bridge> pq;
	static int[] p;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split(" ");
		}
		// 섬에 번호매기겠다.
		int idx = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j].equals("1")) {
					dfs(i, j, idx++);
				}
			}
		//	System.out.println(Arrays.toString(map[i]));
		}
		// 정점의 개수
		int V = idx - 2;
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!map[i][j].equals("0")) {
					buildBridge(i, j, map[i][j]);
				}
			}
		}
		p = new int[V];
		for (int i = 0; i < V; i++) {
			p[i] = i;
		}

		int pick = 0;
		int ans = 0;
		while (pick < V - 1) {
			Bridge bridge = pq.poll();
			if (bridge == null) {
				ans = -1;
				break;
			}
			int px = findSet(bridge.st);
			int py = findSet(bridge.ed);

			if (px != py) {
				union(px, py);
				pick++;
				ans += bridge.length;
			}
		}
		System.out.println(ans);

	}

	static void buildBridge(int row, int col, String island) {
		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;
			if (!map[nr][nc].equals("0"))
				continue;

			int len = 0;
			while (true) {
				nr += dr[i];
				nc += dc[i];
				len++; // 다리 한칸 놓았다.
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					break;
				;
				if (map[nr][nc].equals(island))
					break; // 자기자신을 만난다면 종료 -> U자형태섬이 있지 않을까?
				if (map[nr][nc].equals("0"))
					continue; // 0, 즉 바다를 만나면 계속 진행

				// 여기서는 다른 섬을 만났을 경우다.
				// 다리의 길이가 2보다 크니깐 가능!
				if (len >= 2) {
					int st = Integer.parseInt(island) - 2;
					int ed = Integer.parseInt(map[nr][nc]) - 2;
//					System.out.println(st + " " + ed + " " + len);
					pq.add(new Bridge(st, ed, len));
				}
				break;
			}
		}
	}

	static void dfs(int row, int col, int idx) {
		map[row][col] = "" + idx;
		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;

			if (map[nr][nc].equals("1")) {
				dfs(nr, nc, idx);
			}
		}

	}

	static int findSet(int x) {
		if (p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

	static void union(int x, int y) {
		p[y] = x;
	}
}
