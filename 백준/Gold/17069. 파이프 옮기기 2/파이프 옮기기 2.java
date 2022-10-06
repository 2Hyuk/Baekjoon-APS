
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 0 가로방향으로 온경우, 1세로방향에서온경우, 2대각선에서온경우
		long[][][] dp = new long[N + 1][N + 1][3];
		dp[1][2][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				if (map[i][j] == 1 || (i == 1 && j == 2))
					continue;
				// 가로로 오는 경우는 열-1칸에서 가로에있던파이프가 오는 경우와 대각선에 있던 파이프가 오는 경우
				dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
				// 세로로 오는 경우는 행-1칸에서 세로로 있던 파이프가 오는 경우와 대각선에 있던 파이프가 오는 경우
				dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
				// 대각선에서 오는 경우는 행-1, 열-1에서 가로, 세로 대각선 방향에 있던 파이프가 오는 경우
				// 근데 주변에 돌없어야됨 ㅋ
				if (map[i - 1][j] == 0 && map[i][j - 1] == 0) {
					dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				}
			}
		}
		
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
	}
}
