
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node{
		int row, col, move;
		public Node(int row, int col, int move) {
			this.row = row;
			this.col = col;
			this.move = move;
		}
	}
	public static void main(String[] args) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited;
		int[] dr = {-1, -2, -2, -1, +1, +2, +2, +1};
		int[] dc = {-2, -1, +1, +2, +2, +1, -1, -2};
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			q.clear();
			int N = sc.nextInt();
			visited = new boolean[N][N];
			int startRow = sc.nextInt();
			int startCol = sc.nextInt();
			int endRow = sc.nextInt();
			int endCol = sc.nextInt();
			
			q.offer(new Node(startRow, startCol, 0));
			visited[startRow][startCol] = true;
			
			while(!q.isEmpty()) {
				Node node = q.poll();
				
				if(node.row == endRow && node.col == endCol) {
					System.out.println(node.move);
					break;
				}
				
				for(int i = 0; i < 8; i++) {
					int nr = node.row + dr[i];
					int nc = node.col + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
					
					visited[nr][nc] = true;
					q.offer(new Node(nr, nc, node.move + 1));
				}
			}
		}

	}
}
