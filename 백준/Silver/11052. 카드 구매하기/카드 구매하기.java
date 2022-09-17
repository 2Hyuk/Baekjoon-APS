import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 1장을 비싸게 사는 것은 1장짜리를 사는것
	// 2장을 비싸게 사는 것은 1장짜리를 2개사는 것과 2장짜리를 1개사는것중 비싼 것
	// 3장을 비싸게 사는 것은 2장을 비싸게 사는 경우에 1장을 사는것, 3장을 사는 것 중 비싼것
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
		if(n == 0) return 0;
		if(dp[n] == 0) {
			int max = price[n];
			for(int i = 1; i < n; i++) {
				max = Math.max(recur(i) + recur(n - i), max);
			}
			dp[n] = max;
		}
		return dp[n];
	}
}
