
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 종이의 한 지점으로부터 3번 이동했을 때 의 모든 경우를 구하면 회전, 대칭을 포함한 테트로미노를 구할 수 있다.
	 */
	static int[][] paper;
	static int max, N, M;
	static boolean[][] visited;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		paper = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 0, 0);
				fuckYou(i, j);
				visited[i][j] = false;
			}
		}
		System.out.println(max);
	}

	static void dfs(int row, int col, int sel, int sum) {
		if(sel == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])
				continue;
			
			visited[nr][nc] = true;
			dfs(nr, nc, sel + 1, sum + paper[nr][nc]);
			visited[nr][nc] = false;
		}
	}
	
	static void fuckYou(int row, int col) {
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;
			
			list.add(paper[nr][nc]);
		}
		
		if(list.size() < 3) {
			return;
		}
		
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		
		int sum = paper[row][col];
		for(int i = 0; i < 3; i++) {
			sum += list.get(i);
		}
		max = Math.max(max, sum);
	}
}
