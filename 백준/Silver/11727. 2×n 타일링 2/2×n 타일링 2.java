
import java.util.Scanner;

public class Main {
	static int[] dp;
	public static void main(String[] args) {
		// 2xn타일링문제에서 2x2막대가 추가되었다.
		// 기존 점화식인 dp[n] = dp[n-1] + dp[n-2]에서 2x2막대가 추가되는 경우를 계산해줘야된다.
		// 이는 dp[n] = dp[n-1] + 2 * dp[n-2]와 동일하다.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n + 1];
		
		System.out.println(tile(n));
	}
	
	public static int tile(int n) {
		if(dp[n] == 0) {
			if(n == 1)
				return dp[n] = 1;
			if(n == 2)
				return dp[n] = 3;
			
			return dp[n] = (tile(n - 1) + 2 * tile(n - 2)) % 10007;
		}
		
		return dp[n];
	}
}
