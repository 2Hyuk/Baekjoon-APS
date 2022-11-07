
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int row, col, dust;

		public Node(int row, int col, int dust) {
			super();
			this.row = row;
			this.col = col;
			this.dust = dust;
		}
		
	}
	static int[][] room;
	static int cR, R, C;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		room = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				int n = Integer.parseInt(st.nextToken());
				room[i][j] = n;
				if(n == -1) {
					//공기청정기는 (cR-1, 0), (cR, 0) 차지
					cR = i;
				}
			}
		}
	
		for(int i = 0; i < T; i++) {
			room = dustSpread(room);
			wind(room);
		}
		
		
		
		
		//공기청정기 자리 생각해주고 2부터 시작
		int ans = 2;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				ans += room[i][j];
			}
		}
		
		System.out.println(ans);
	}
	
	public static int[][] dustSpread(int[][] room){
		int[][] tmp = new int[R][C];
		Queue<Node> q = new ArrayDeque<>();
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(room[i][j] == -1) {
					tmp[i][j] = -1;
				}
				else if(room[i][j] != 0)
					q.offer(new Node(i, j, room[i][j]));
			}
		}
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int cnt = 0;
			int spreadWeight = node.dust / 5;
			
			for(int i = 0; i < 4; i++) {
				int nr = node.row + dr[i];
				int nc = node.col + dc[i];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || tmp[nr][nc] == -1)
					continue;
				
				cnt++;
				tmp[nr][nc] += spreadWeight;
			}
			tmp[node.row][node.col] += node.dust - spreadWeight * cnt;
		}
		return tmp;
	}
	
	public static int[][] wind(int[][] room){
		int row = cR - 1;
		int col = 1;
		int prevNum = 0;
		//윗부분
		//왼쪽 ->오른쪽
		while(col < C) {
			int nextNum = room[row][col];
			room[row][col] = prevNum;
			prevNum = nextNum;
			col++;
		}
		col--;
		row--;
		//아래 -> 위
		while(row >= 0) {
			int nextNum = room[row][col];
			room[row][col] = prevNum;
			prevNum = nextNum;
			row--;
		}
		row++;
		col--;
		//오른쪽 ->왼쪽
		while(col >= 0) {
			int nextNum = room[row][col];
			room[row][col] = prevNum;
			prevNum = nextNum;
			col--;
		}
		col++;
		row++;
		//위->아래
		while(row < cR - 1) {
			int nextNum = room[row][col];
			room[row][col] = prevNum;
			prevNum = nextNum;
			row++;
		}
		
		//아래부분
		row = cR;
		col = 1;
		prevNum = 0;
		//왼쪽->오른쪽
		while(col < C) {
			int nextNum = room[row][col];
			room[row][col] = prevNum;
			prevNum = nextNum;
			col++;
		}
		col--;
		row++;
		//위->아래
		while(row < R) {
			int nextNum = room[row][col];
			room[row][col] = prevNum;
			prevNum = nextNum;
			row++;
		}
		row--;
		col--;
		//오른쪽->왼쪽
		while(col >= 0) {
			int nextNum = room[row][col];
			room[row][col] = prevNum;
			prevNum = nextNum;
			col--;
		}
		col++;
		row--;
		//아래->위
		while(row > cR) {
			int nextNum = room[row][col];
			room[row][col] = prevNum;
			prevNum = nextNum;
			row--;
		}
		return room;
	}
}
