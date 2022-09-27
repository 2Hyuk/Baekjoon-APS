
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int row, col, dist, bitMask;
		public Node(int row, int col, int dist, int bitMask) {
			this.row = row;
			this.col = col;
			this.dist = dist;
			this.bitMask = bitMask;
		}
		
	}
	static String[][] map;
	static boolean[][][] visited;
	static int N, M, minDist, baseRow, baseCol;
	static Queue<Node> queue;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}
		
		int baseRow = 0, baseCol = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c].equals("0")) {
					baseRow = r;
					baseCol = c;
				}
			}
		}
		queue = new LinkedList<>();
		visited = new boolean[N][M][1<<6];
		minDist = Integer.MAX_VALUE;
		queue.offer(new Node(baseRow, baseCol, 0, 0));
		map[baseRow][baseCol] = ".";
		bfs();
		if(minDist == Integer.MAX_VALUE)
			minDist = -1;
		System.out.println(minDist);
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int row = node.row;
			int col = node.col;
			int dist = node.dist;
			int bitMask = node.bitMask;
			
			if(map[row][col].equals("1")) {
				minDist = node.dist;
				break;
			}
			for(int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				
				if((map[nr][nc].equals(".") || map[nr][nc].equals("1")) && visited[nr][nc][bitMask] == false) {
					visited[nr][nc][bitMask] = true;
					queue.offer(new Node(nr, nc, dist + 1, bitMask));
				}
				
				if(map[nr][nc].charAt(0) >= 'a' && map[nr][nc].charAt(0) <= 'f' && visited[nr][nc][bitMask] == false) {
					visited[nr][nc][bitMask] = true;
					visited[nr][nc][bitMask | 1 << map[nr][nc].charAt(0) - 'a'] = true;
					queue.offer(new Node(nr, nc, dist + 1, bitMask | 1 << map[nr][nc].charAt(0) - 'a'));
				}
				
				if(map[nr][nc].charAt(0) >= 'A' && map[nr][nc].charAt(0) <= 'F' && visited[nr][nc][bitMask] == false) {
					if((bitMask & (1 << map[nr][nc].charAt(0) -'A')) > 0) {
						visited[nr][nc][bitMask] = true;
						queue.offer(new Node(nr, nc, dist + 1, bitMask));
					}
				}
				
			}
		}
	}
	
	
}

























