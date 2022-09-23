
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int N;
	static String[][] map;
	static int buildingCnt;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				buildingCnt = 0;
				if(map[i][j].equals("1")) {
					dfs(i, j);
					list.add(buildingCnt);
					buildingCnt = 0;
				}
			}
		}
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for(int i : list) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int r, int c) {
		buildingCnt++;
		map[r][c] = "0";
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			
			if(map[nr][nc].equals("1")) {
				dfs(nr, nc);
			}
		}
	}
}
