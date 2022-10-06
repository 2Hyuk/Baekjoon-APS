
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] memo;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		memo = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			Arrays.fill(memo[i], -1);
		}
		int ans = dfs(0, 0);
		System.out.println(ans);

	}

	static int dfs(int row, int col) {
		if (row == M - 1 && col == N - 1)
			return 1;

		if (memo[row][col] != -1)
			return memo[row][col];
		
		int result = 0;
		
		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (nr < 0 || nr >= M || nc < 0 || nc >= N || map[nr][nc] >= map[row][col])
				continue;

			result += dfs(nr, nc);
		}
		memo[row][col] = result;
		return result;
	}
}
