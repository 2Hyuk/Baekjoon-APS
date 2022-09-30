import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	static class Node implements Comparable<Node>{
		int row, col;
		int weight;
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
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < str.length(); j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			boolean[][] visited = new boolean[N][N];
			final int INF = Integer.MAX_VALUE;
			int[][] dist = new int[N][N];
			for(int i = 0; i < N; i++) {
				Arrays.fill(dist[i], INF);
			}
			PriorityQueue<Node> pq = new PriorityQueue<>();
			//0,0 부터 시작
			dist[0][0] = 0;
			pq.offer(new Node(0, 0, dist[0][0]));
			
			int[] dr = {0, -1, 0, 1};
			int[] dc = {-1, 0, 1, 0};
			//다익스트라
			int min = INF;
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				int row = node.row;
				int col = node.col;
				int weight = node.weight;
				
				if(row == N - 1 && col == N - 1) {
					min = Math.min(min, weight);
					break;
				}
				
				if(visited[row][col]) continue;
				visited[row][col] = true;
				
				for(int i = 0; i < 4; i++) {
					int nr = row + dr[i];
					int nc = col + dc[i];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					
					if(!visited[nr][nc] && dist[nr][nc] > weight + map[nr][nc]) {
						dist[nr][nc] = weight + map[nr][nc];
						pq.offer(new Node(nr, nc, dist[nr][nc]));
					}
				}
			}
			System.out.println("#" + tc + " " + min);
			
			
		}
	}
}
