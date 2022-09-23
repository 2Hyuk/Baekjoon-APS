
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int safetyCnt;
	static int waterBoundary;
	static int[][] map;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[][] area = new int[N][N];
		
		int maxHeight = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int height = Integer.parseInt(st.nextToken());
				area[i][j] = height;
				maxHeight = Math.max(maxHeight, height);
			}
		}
		
		safetyCnt = 0;
		int maxSafetyCnt = 0;
		for(int i = 0; i < maxHeight; i++) {
			waterBoundary = i;
			map = deepCopy(area);
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(map[r][c] > waterBoundary) {
						safetyCnt++;
						dfs(r, c);
					}
				}
			}
			maxSafetyCnt = Math.max(maxSafetyCnt, safetyCnt);
			safetyCnt = 0;
		}
		System.out.println(maxSafetyCnt);
	}
	
	static void dfs(int r, int c) {
		map[r][c] = waterBoundary;
		
		for(int i = 0 ; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0  || nr >= N || nc < 0 || nc >= N)
				continue;
			
			if(map[nr][nc] > waterBoundary) {
				dfs(nr, nc);
			}
		}
		
	}
	
	static int[][] deepCopy(int[][] map){
		if(map == null)
			return null;
		
		int[][] tmp = new int[N][N];
		
		for(int i = 0; i < map.length; i++) {
			System.arraycopy(map[i], 0, tmp[i], 0, map[i].length);
		}
		
		return tmp;
	}
}
