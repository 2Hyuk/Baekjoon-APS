import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	// 간선을 최소로하면서 간선의 길이가 가장 짧은 것. -> 간선이 정점에 비해 적으므로 크루스칼?
	// 간선을 V-1만큼만 선택한다.
	// 어떻게 하면 간선정보를 나타낼 수 있을까?
	// 모든 정점을 연결한다고 했을 떄 길이를 구해서 간선 정보로 넣는다.
	static class Edge implements Comparable<Edge> {
		int st, ed;
		double price;

		public Edge(int st, int ed, double price) {
			this.st = st;
			this.ed = ed;
			this.price = price;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.price - o.price > 0)
				return 1;
			else if (this.price - o.price < 0)
				return -1;
			return 0;
		}

	}

	static class Island {
		int x, y;

		public Island(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static double E;
	static List<Edge> edges = new ArrayList<>();
	static Island[] island;
	static boolean[] visited;
	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st_X, st_Y;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			N = Integer.parseInt(br.readLine());// 섬의개수
			edges.clear(); // 간선리스트 초기화
			island = new Island[N]; // 섬의 좌표 배열 초기화
			visited = new boolean[N]; // 섬 방문했는지 체크
			st_X = new StringTokenizer(br.readLine());
			st_Y = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st_X.nextToken());
				int y = Integer.parseInt(st_Y.nextToken());

				island[i] = new Island(x, y);
			}
			E = Double.parseDouble(br.readLine());
			combi(0, 0); // 간선 모두 뽑아내기
			Collections.sort(edges); // 뽑아낸 간선을 정렬

			p = new int[N]; // 대표배열 생성
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}

			double price = 0;
			int pick = 0;
			int idx = 0;

			while (pick < N - 1) { // N-1개를 뽑으면 중단(모든정점을 연결하기 위한 최소)
				Edge edge = edges.get(idx++);
				int px = findSet(edge.st);
				int py = findSet(edge.ed);

				if (px != py) {
					union(px, py);
					price += edge.price;
					pick++;
				}
			}
			long totalPrice = (long) Math.round(price);
			sb.append(totalPrice).append("\n");
		}
		System.out.println(sb);
	}

	// 모든 간선을 구해서 넣을거다.
	static void combi(int idx, int sidx) {

		if (sidx == 2) {
			int st = -1;
			int ed = -1;
			double price = 0;
			for (int i = 0; i < N; i++) {
				if (st != -1 && ed != -1)
					break;
				else if (visited[i] && st == -1) {
					st = i;
				} else if (visited[i] && ed == -1) {
					ed = i;
				}
			}
			price =  E * (Math.pow(island[st].x - island[ed].x, 2) + Math.pow(island[st].y - island[ed].y, 2));
			edges.add(new Edge(st, ed, price));
			return;
		}

		for (int i = idx; i < N; i++) {
			visited[i] = true;
			combi(i + 1, sidx + 1);
			visited[i] = false;
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
