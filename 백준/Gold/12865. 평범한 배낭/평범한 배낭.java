
import java.util.Scanner;

public class Main {
	static class Thing{
		int w, v;

		public Thing(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Thing[] things = new Thing[N+1];
		int[][] dp = new int[N+1][K+1];
		
		for(int i = 1; i <= N; i++) {
			things[i] = new Thing(sc.nextInt(), sc.nextInt());
		}
		
		for(int i = 1; i <= N; i++) {
			for(int w = 1; w <= K; w++) {
				if(things[i].w > w) {
					dp[i][w] = dp[i-1][w];
				}
				else {
					dp[i][w] = Math.max(dp[i-1][w-things[i].w] + things[i].v, dp[i-1][w]);
				}
			}
		}
		System.out.println(dp[N][K]);

	}
}
