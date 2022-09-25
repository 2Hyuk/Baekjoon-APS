
import java.util.Scanner;

public class Main {
	static long[] dp = new long[4000001];
	static long P = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		dp[0] = 1;
		
		//팩토리얼 구하기
		for(int i = 1; i < 4000001; i++) {
			dp[i] = dp[i-1] * i;
			dp[i] %= P;
		}
		
		long result = dp[N] * pow(dp[N-K] * dp[K] % P, P - 2) % P;
		System.out.println(result);
	}
	
	static long pow(long n, long r) {
		if (r == 1)
			return n;

		long result = pow(n, r/2);
		if(r % 2 == 0) 
			return (result * result) % P;
		else
			return (result * result ) % P * n % P;
	}
}
