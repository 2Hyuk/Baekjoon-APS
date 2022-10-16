
import java.util.Scanner;

public class Main {
	static int N;
	static int[] L;
	static int[] J;
	static int maxHappy;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = new int[N];
		J = new int[N];
		for (int i = 0; i < N; i++) {
			L[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			J[i] = sc.nextInt();
		}
		maxHappy = 0;
		dfs(0, 100, 0);
		System.out.println(maxHappy);

	}

	static void dfs(int idx, int life, int happy) {
		if(idx == N) {
			if(life > 0) {
				maxHappy = Math.max(maxHappy, happy);
			}
			return;
		}
			
		dfs(idx + 1, life - L[idx], happy + J[idx]);
		dfs(idx + 1, life, happy);
	}
}
