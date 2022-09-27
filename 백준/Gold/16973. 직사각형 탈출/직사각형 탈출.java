
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Rect{
		int row, col, moveCnt;
		public Rect(int row, int col, int moveCnt) {
			this.row = row;
			this.col = col;
			this.moveCnt = moveCnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[][] map = new String[N][M];
		
		for(int r = 0; r < N; r++) {
			map[r] = br.readLine().split(" ");
		}
		
		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken()); // 직사각형 높이(row)
		int W = Integer.parseInt(st.nextToken()); // 직사각형 넓이(col)
		int Sr = Integer.parseInt(st.nextToken()) - 1; //시작 row
		int Sc = Integer.parseInt(st.nextToken()) - 1; //시작 col
		int Fr = Integer.parseInt(st.nextToken()) - 1; //도착 row
		int Fc = Integer.parseInt(st.nextToken()) - 1; //도착 col
		
		boolean[][] visited = new boolean[N - H + 1][M - W + 1];
		Queue<Rect> queue = new LinkedList<>();
		int[] dr = {0, -1, 0, 1};
		int[] dc = {-1, 0, 1, 0};
		visited[Sr][Sc] = true;
		queue.offer(new Rect(Sr, Sc, 0));
		
		int minMove = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			Rect rect = queue.poll();
			
			if(rect.row == Fr && rect.col == Fc) {
				minMove = rect.moveCnt;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = rect.row + dr[i];
				int nc = rect.col + dc[i];
				boolean flag = true;
				switch(i) {
				case 0://좌
					for(int j = 0; j < H; j++) {
						int nnr = nr + j;
						int nnc = nc;
						if(nnr < 0 || nnr >= N || nnc < 0 || nnc >= M || visited[nr][nc] == true || map[nnr][nnc].equals("1")) {
							flag = false;
							break;
						}
					}
					break;
				case 1://상
					for(int j = 0; j < W; j++) {
						int nnr = nr;
						int nnc = nc + j;
						if(nnr < 0 || nnr >= N || nnc < 0 || nnc >= M || visited[nr][nc] == true || map[nnr][nnc].equals("1")) {
							flag = false;
							break;
						}
					}
					break;
				case 2://우
					for(int j = 0; j < H; j++) {
						int nnr = nr + j;
						int nnc = nc + W - 1;
						if(nnr < 0 || nnr >= N || nnc < 0 || nnc >= M || visited[nr][nc] == true || map[nnr][nnc].equals("1")) {
							flag = false;
							break;
						}
					}
					break;
				case 3://하
					for(int j = 0; j < W; j++) {
						int nnr = nr + H - 1;
						int nnc = nc + j;
						if(nnr < 0 || nnr >= N || nnc < 0 || nnc >= M || visited[nr][nc] == true || map[nnr][nnc].equals("1")) {
							flag = false;
							break;
						}
					}
					break;
				}
				if(flag) {
					visited[nr][nc] = true;
					queue.offer(new Rect(nr, nc, rect.moveCnt + 1));
				}
			}
			
		}
		
		if(minMove == Integer.MAX_VALUE) {
			minMove = -1;
		}
		System.out.println(minMove);
	}
}





















