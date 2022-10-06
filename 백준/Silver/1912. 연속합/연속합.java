
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;
	static int[] input;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = new int[n];
		dp = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxValue = dp[0] = input[0];
		for(int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i-1] + input[i], input[i]);
			maxValue = Math.max(maxValue, dp[i]);
		}
		System.out.println(maxValue);
	}
}
