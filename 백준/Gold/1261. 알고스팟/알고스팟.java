
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	//다익스트라 사용해서 최적경로를 구한다.
	static class Node implements Comparable<Node>{
		int row, col, weight;

		public Node(int row, int col, int weight) {
			this.row = row;
			this.col = col;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); //가로길이
		int N = Integer.parseInt(st.nextToken()); //세로길이
		int[][] map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		final int INF = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[N][M]; // 방문체크배열
		int[][] dist = new int[N][M]; //현재 row, col 까지오는데 까지 뚫은 벽의 수
		for(int i = 0; i < N; i++) { // 처음에는 최대치로 초기화
			Arrays.fill(dist[i], INF);
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		//0,0에서 시작
		dist[0][0] = 0; // 0,0에서 시작하니깐 0으로 초기화
		pq.offer(new Node(0, 0, dist[0][0]));
		int min = INF;
		int[] dr = {0, -1, 0, 1};
		int[] dc = {-1, 0, 1, 0};
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int row = node.row;
			int col = node.col;
			int weight = node.weight;
			
			//목표지점에 도달했을 떄
			if(row == N - 1 && col == M - 1) {
				min = Math.min(min, weight);
			}
			//한번 왔었던 길이면? 패스
//			if(visited[row][col]) continue;
//			visited[row][col] = true;
			
			for(int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				//지금까지 nr, nc까지 오는데 뚫은 벽의 수가 현재 기록된 벽의 수보다 작다면 갱신하고, 다음으로 보낸다.
				if(dist[nr][nc] > weight + map[nr][nc]) {
					dist[nr][nc] = weight + map[nr][nc];
					pq.offer(new Node(nr, nc, dist[nr][nc]));
				}
			}
		}
		
		System.out.println(min);
	}
}
