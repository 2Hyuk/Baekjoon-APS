
import java.util.Scanner;

public class Main {
	static int[][] dp = new int[10001][4];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
				
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			
			for(int i = 4; i <= n; i++) {
				dp[i][1] = dp[i-1][1];
				dp[i][2] = dp[i-2][1] + dp[i-2][2];
				dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
			}
			
			int result = dp[n][1] + dp[n][2] + dp[n][3];
			sb.append(result).append("\n");
			
		}
		System.out.println(sb);

	}
	
}
