import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 1장을 싸게 사는 것은 1장짜리를 사는것
	// 2장을 싸게 사는 것은 1장짜리를 2개사는 것과 2장짜리를 1개 사는것중 싼 것
	// 3장을 싸게 사는 것은 1장짜리 1개+2장 1개, 3장 1개 사는것 중 싼 것
	// n장을 구매할 때 가장 싼 값을 dp[n]이라고 하고, n장을 한번에 구매하는 가격을 p라고 한다.
	// 즉, dp[n]은 (dp[1] + dp[n-1], dp[2] + dp[n-2], ...., dp[n-1] + dp[1], p)의 최소값이 된다.
	// 이때 제일 처음 값과 끝의 값은 순서만 다르고 값은 같으므로, 범위는 n/2까지만 구하면 된다.
	// 재귀를 통해 n장을 줄여가며 n장을 구매할 때 가장 싼 경우를 구한다.
	static int[] price;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		price = new int[N + 1];
		dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		dp[1] = price[1];
		System.out.println(recur(N));
		
	}
	
	public static int recur(int n) {
		if(dp[n] == 0) {
			// n장을 한번에 구매할 떄의 가격
			int min = price[n];
			for(int i = 1; i <= n / 2; i++) {
				// n장을 구매할 때의 가장 싼 값에대해 모든 경우의 수를 구한다.
				min = Math.min(recur(i) + recur(n - i), min);
			}
			dp[n] = min;
		}
		return dp[n];
	}
}
