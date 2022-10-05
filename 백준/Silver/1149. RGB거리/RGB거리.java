
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int red = Integer.parseInt(st.nextToken());
		int green = Integer.parseInt(st.nextToken());
		int blue = Integer.parseInt(st.nextToken());
		int[][] dp = new int[2][3];
		dp[0][0] = red;
		dp[0][1] = green;
		dp[0][2] = blue;
		
		for(int i = 2; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			red = Integer.parseInt(st.nextToken());
			green = Integer.parseInt(st.nextToken());
			blue = Integer.parseInt(st.nextToken());
			//2번째집에서 레드를 골랐다면 전의 집에서 그린 또는 블루중 작은값 + 자기 자신의 집값
			dp[1][0] = Math.min(dp[0][1], dp[0][2]) + red;
			//그린을 골랐다면 전의 집에서 레드 또는 블루 중 작은 값 + 자기 자신의 집값
			dp[1][1] = Math.min(dp[0][0], dp[0][2]) + green;
			//그린을 골랐다면 전의 집에서 레드 또는 블루 중 작은 값 + 자기 자신의 집값
			dp[1][2] = Math.min(dp[0][0], dp[0][1]) + blue;
			
			// 값 이동시켜준다.
			dp[0][0] = dp[1][0];
			dp[0][1] = dp[1][1];
			dp[0][2] = dp[1][2];
		}
		
		//0번쨰의 값들 중 최소값을 찾으면된다.
		System.out.println(Math.min(Math.min(dp[0][0] ,dp[0][1]), dp[0][2]));
		
	
	}
	
}
