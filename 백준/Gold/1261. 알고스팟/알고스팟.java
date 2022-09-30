
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
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
		boolean[][] visited = new boolean[N][M];
		int[][] dist = new int[N][M];
		for(int i = 0; i < N; i++) {
			Arrays.fill(dist[i], INF);
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		//0,0에서 시작
		dist[0][0] = 0;
		pq.offer(new Node(0, 0, dist[0][0]));
		int min = INF;
		int[] dr = {0, -1, 0, 1};
		int[] dc = {-1, 0, 1, 0};
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int row = node.row;
			int col = node.col;
			int weight = node.weight;
			
			if(row == N - 1 && col == M - 1) {
				min = Math.min(min, weight);
			}
			
			if(visited[row][col]) continue;
			visited[row][col] = true;
			
			for(int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if(!visited[nr][nc] && dist[nr][nc] > weight + map[nr][nc]) {
					dist[nr][nc] = weight + map[nr][nc];
					pq.offer(new Node(nr, nc, dist[nr][nc]));
				}
			}
		}
		
		System.out.println(min);
	}
}
