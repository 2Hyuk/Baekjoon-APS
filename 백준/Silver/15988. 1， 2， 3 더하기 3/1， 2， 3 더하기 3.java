import java.util.Scanner;

public class Main {
	static long[] dp = new long[1000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 0; i < T; i++) {
			int n = sc.nextInt();
			sb.append(recur(n)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static long recur(int n) {
		if(dp[n] == 0) {
			dp[n] = (recur(n - 1) + recur(n - 2) + recur(n - 3)) % 1000000009;
		}
		
		return dp[n];
	}
	
}
