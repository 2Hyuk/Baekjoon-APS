
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 1.n-2칸에서 2칸점프해서 오는경우
		// 2.n-3칸에서 2칸점프하고, n-1칸에서 1칸점프해서 오는 경우
		int[] dp = new int[n + 1];
		int[] point = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			point[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = point[1];
		if(n >= 2) {
			dp[2] = point[1] + point[2];
		}
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + point[i - 1]) + point[i];
		}

		System.out.println(dp[n]);

	}
}
