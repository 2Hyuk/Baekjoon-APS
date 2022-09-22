import java.util.Scanner;

public class Solution {
	static int[][] map;
	static boolean[] visited;
	static int[][] customer;
	static int xHome;
	static int yHome;
	static int shortDistance;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[101][101];
			visited = new boolean[N];
			customer = new int[N][N];
			int xCompany = sc.nextInt();
			int yCompany = sc.nextInt();
			xHome = sc.nextInt();
			yHome = sc.nextInt();
			for (int i = 0; i < N; i++) {
				customer[i][0] = sc.nextInt();
				customer[i][1] = sc.nextInt();
			}
			shortDistance = Integer.MAX_VALUE;
			shortDistance(0, xCompany, yCompany, 0);
			System.out.println("#" + tc + " " +shortDistance);
		}

	}

	static void shortDistance(int idx, int x, int y, int distance) {
		if (idx == N) {
			shortDistance = Math.min(shortDistance, distance + Math.abs(x - xHome) +Math.abs(y - yHome));
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			shortDistance(idx + 1, customer[i][0], customer[i][1], distance + Math.abs(x - customer[i][0]) +Math.abs(y - customer[i][1]));
			visited[i] = false;
		}
	}
}
