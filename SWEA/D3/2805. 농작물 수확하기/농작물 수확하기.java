
import java.util.Scanner;

public class Solution {
	static int[][] farm;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			farm = new int[N][N];
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < str.length(); j++) {
					farm[i][j] = str.charAt(j) - '0';
				}
			}
			int mid = N / 2;
			int sum = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(Math.abs(i - mid) + Math.abs(j - mid) <= N-mid-1) {
						sum += farm[i][j];
					}
				}
			}
			System.out.println("#" + tc + " " + sum);
			
		}

	}
}
