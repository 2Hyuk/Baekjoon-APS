
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 기존배열을 복사해서 카피배열에서 dfs로 기둥을 3개 세운다.
	 * bfs로 바이러스를 퍼뜨려보면서 안전구역이 지금까지 구한 최대값보다 크다면
	 * 프루닝한다.
	 */
	static class Virus{
		int row, col;

		public Virus(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		
	}
	static int N, M, max, ans;
	static int[][] map;
	static int[][] copyMap;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copyMap = new int[N][M];
		max = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if(n == 0) {
					max++;
				}
			}
		}
		//기둥을 3개 세워야되니깐 최대 값은 ans - 3
		max -= 3;
		ans = 0;
		buildPoint(0);
		System.out.println(ans);
		
	}
	public static void buildPoint(int sel) {
		if(sel == 3) {
			copy();
			spread();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					buildPoint(sel + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void spread() {
		Queue<Virus> q = new ArrayDeque<>();
//		for(int[] b : vMap) {
//			Systesm.out.println(Arrays.toString(b));
//		}
//		System.out.println();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyMap[i][j] == 2) {
					q.offer(new Virus(i, j));
				}
			}
		}
		
		int result = max;
		while(!q.isEmpty()) {
			Virus v = q.poll();
			
			if(ans >= result) {
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = v.row + dr[i];
				int nc = v.col + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || copyMap[nr][nc] == 1 || copyMap[nr][nc] == 2)
					continue;
				
				copyMap[nr][nc] = 2;
				result--;
				q.offer(new Virus(nr, nc));
			}
		}
		ans = Math.max(ans, result);
	}
	
	public static void copy() {
		for(int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, copyMap[i], 0, M);
		}
	}
}
