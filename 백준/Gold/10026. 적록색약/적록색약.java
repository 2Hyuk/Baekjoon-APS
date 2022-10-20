
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class Node{
		int row, col;
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		
	}
	static String[][] arr;
	static boolean[][] visited;
	static Queue<Node> q = new LinkedList<>();
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N][N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine().split("");
		}
		
		int area = 0;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j]) continue;
				q.offer(new Node(i, j));
				area++;
				bfs(arr[i][j]);
			}
		}
		System.out.print(area + " ");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j].equals("G")) {
					arr[i][j] = "R";
				}
			}
		}
		
		area = 0;
		q.clear();
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j]) continue;
				q.offer(new Node(i, j));
				area++;
				bfs(arr[i][j]);
			}
		}
		System.out.println(area);
	}
	
	static void bfs(String color) {
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = node.row + dr[i];
				int nc = node.col + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || !arr[nr][nc].equals(color)) continue;
				
				visited[nr][nc] = true;
				q.offer(new Node(nr, nc));
			}
		}
	}
}
