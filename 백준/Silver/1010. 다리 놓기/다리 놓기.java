import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp = new int[30][30];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			sb.append(combination(n, r)).append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static int combination(int n, int r) {
		if(dp[n][r] > 0)
			return dp[n][r];
		
		if(n == r || r == 0)
			return dp[n][r] = 1;
		
		
		return dp[n][r] = combination(n-1, r-1) + combination(n-1, r);
	}
}
