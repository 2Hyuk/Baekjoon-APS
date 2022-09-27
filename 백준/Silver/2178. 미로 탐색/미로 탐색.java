
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Move{
		int row;
		int col;
		int dist;
		public Move(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dr = {0, -1, 0, 1};
		int[] dc = {-1, 0, 1, 0};
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[][] map = new String[N][M];
		
		for(int r = 0; r < N; r++) {
			map[r] = br.readLine().split("");
		}
		
		Queue<Move> queue = new LinkedList<>();
		
		queue.offer(new Move(0, 0, 1));
		
		while(!queue.isEmpty()) {
			Move move = queue.poll();
			
			if(move.row == N - 1 && move.col == M - 1) {
				System.out.println(move.dist);
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = move.row + dr[i];
				int nc = move.col + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				
				if(map[nr][nc].equals("1")) {
					queue.offer(new Move(nr, nc, move.dist + 1));
					map[nr][nc] = "0";
				}
			}
		}
	}
}
