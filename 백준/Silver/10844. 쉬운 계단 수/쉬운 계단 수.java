
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// n자리의 일의 자리의 숫자가 k인 계단 수의 개수는
		// n-1자리의 일의 자리 숫자가 k-1, k+1인 개수의 합과 같다.
		// dp[n][k] = dp[n-1][k-1] + dp[n-1][k+1]
		// 이때 k가 0과 9인 경우에 대해서는 1과 8의 개수와 같다.
		
		long[][] dp = new long[101][10];
		
		dp[1][0] = 0;
		dp[1][1] = 1;
		dp[1][2] = 1;
		dp[1][3] = 1;
		dp[1][4] = 1;
		dp[1][5] = 1;
		dp[1][6] = 1;
		dp[1][7] = 1;
		dp[1][8] = 1;
		dp[1][9] = 1;
		
		int n = sc.nextInt();
		for(int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i-1][1]) % 1000000000;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 1000000000;
			dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % 1000000000;
			dp[i][3] = (dp[i-1][2] + dp[i-1][4]) % 1000000000;
			dp[i][4] = (dp[i-1][3] + dp[i-1][5]) % 1000000000;
			dp[i][5] = (dp[i-1][4] + dp[i-1][6]) % 1000000000;
			dp[i][6] = (dp[i-1][5] + dp[i-1][7]) % 1000000000;
			dp[i][7] = (dp[i-1][6] + dp[i-1][8]) % 1000000000;
			dp[i][8] = (dp[i-1][7] + dp[i-1][9]) % 1000000000;
			dp[i][9] = (dp[i-1][8])  % 1000000000;
		}
		
		long result = 0;
		for(int i = 0; i <= 9; i++) {
			result += dp[n][i];
		}
		result %= 1000000000;
		System.out.println(result);

	}
}
