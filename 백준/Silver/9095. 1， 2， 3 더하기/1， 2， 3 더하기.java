import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// 정수 n을 1, 2, 3의 합으로 나타내는 모든 경우의 수를 구하는 문제이다.
	// n=1 : 1, n=2 : 1+1, 2, n=3 : 1+1+1, 1+2, 2+1, 3
	// 이후 n이 증가하면 n이 1,2,3의 합으로 나타내는 것은, 
	// n-1을 1,2,3의 합으로 나타낸 것에 +1 하는 것
	// n-2을 1,2,3의 합으로 나타낸 것에 +2 하는 것
	// n-3을 1,2,3의 합으로 나타낸 것에 +3 하는 것과 같으므로
	// n을 1,2,3의 합으로 나타낸 경우의 수는 n-1의 경우의 수 + n-2의 경우의 수 + n-3의 경우의 수 와 같다.
	static int[] dp = new int[11];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(recur(n)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int recur(int n) {
		if(dp[n] == 0) {
			return dp[n] = recur(n - 1) + recur(n - 2) + recur(n - 3);
		}
		
		return dp[n];
	}
}
