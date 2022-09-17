import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] dp;
	public static void main(String[] args) {
		// 규칙: dp[n] = dp[n-1] + dp[n-2]
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n+1];
		System.out.println(combi(n));
	}
	
	public static int combi(int n) {
		if(dp[n] == 0) {
			if(n == 1 || n == 2)
				return dp[n] = n;	
			
			return dp[n] = (combi(n - 1) + combi(n - 2)) % 10007;
			}
		
		return dp[n];
	}
}
