
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Main {
	// 퀸은 8방향 공격이 가능
	static int N;
	static int result;
	static boolean[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new boolean[N][N];
		result = 0;
		backtracking(0);
		System.out.println(result);
	}
	
	public static void backtracking(int r) {
		// 기저조건
		// r이 N까지 도달했으면 체스판을 다 돌면서 한 줄마다 퀸을 배치하였음
		if(r == N) {
			result++;
			return;
		}
		// 하나의 행에는 한개만 놓을 수 있으므로 행은 r로 받고 열에 대해서 반복한다.
		for(int c = 0; c < N; c++) {
			if(putable(r, c)) {
				//놓았다면 행을 증가시켜 재귀한다.
				map[r][c] = true;
				backtracking(r + 1);
				map[r][c] = false;
			}
		}
		
	}
	
	public static boolean putable(int r, int c) {
		int left = 0;
		int right = 0;
		// 놓을 수 있는가 없는가에대해서는 지금까지 놓았던 퀸의 위치만 파악하면된다.
		// 그러므로 위로 탐색하면서 놓을 자리에서 위, 양 대각선을 탐색하면서 퀸이 있는지 확인한다.
		for(int i = r-1; i >= 0; i--) {
			left++;
			right++;
			// 위 탐색
			if(map[i][c] == true)
				return false;
			// 왼쪽 대각선 탐색
			if(c - left >= 0 && map[i][c-left] == true)
				return false;
			// 오른쪽 대각선 탐색
			if(c + right < N && map[i][c+right] == true)
				return false;
		}
		
		return true;
	}
}
