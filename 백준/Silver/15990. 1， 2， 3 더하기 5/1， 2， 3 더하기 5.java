
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[][] dp = new long[100001][4];
		//초기값
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		// 같은 수를 두번 이상 연속해서 쓰면 안되므로 
		// 마지막을 숫자 n에 대해서 1로 끝나게 만드는 경우의 수는
		// n-1의 2로 끝나는 경우의 수와 3으로 끝나는 경우의 수의 합이다.
		// 이러한 방법으로 2로 끝나는 경우의수와 3으로 끝나는 경우의 수를 구해준다.
		for(int i = 4; i <= 100000; i++) {
			dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1000000009;
			dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1000000009;
			dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1000000009;
		}
		
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			long result = (dp[n][1] + dp[n][2] + dp[n][3])% 1000000009;
			sb.append(result).append("\n");
		}
		System.out.println(sb);

	}
}
