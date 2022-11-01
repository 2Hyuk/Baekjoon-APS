import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, K, curRow, curCol;
	static int[][] map;
	static Queue<Integer> order = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	static int[] dice = new int[7];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		curRow = sc.nextInt();
		curCol = sc.nextInt();
		K = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < K; i++) {
			order.offer(sc.nextInt());
		}
		
		//현재 바닥면 1 ->반대편짝(1,6) (2,5) (3,4)
		move();
		System.out.println(sb);
		
	}
	//이동했을 때 이동한 칸의 수가 0이라면?, 주사위 바닥면의 수가 칸에 복사됨
	//0이 아닌경우에는 칸에 있는 수가 주사위로 복사되며 칸에 쓰여있는 수는 0
	static void move() {
		//이동명령 다할때까지 뽑을거다.
		while(!order.isEmpty()) {
			int dir = order.poll();
			int nr = curRow;
			int nc = curCol;
			switch(dir) {
			case 1: //동
				nc++;
				break;
			case 2: //서
				nc--;
				break;
			case 3: //북
				nr--;
				break;
			case 4: //남
				nr++;
				break;
			}
			//바깥으로 이동할려고 한다면 그냥 넘긴다.
			if(nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;
			
			//1을 무조건 지면에 닿고 6은 윗면을 향한다고 생각해서
			//주사위가 구를때마다 값을 옮겨준다.
			int[] tmp = dice.clone();
			switch(dir) {
			case 1: //동
				dice[1] = tmp[3];
				dice[6] = tmp[4];
				dice[3] = tmp[6];
				dice[4] = tmp[1];
				break;
			case 2: //서
				dice[1] = tmp[4];
				dice[6] = tmp[3];
				dice[3] = tmp[1];
				dice[4] = tmp[6];
				break;
			case 3: //북
				dice[1] = tmp[2];
				dice[6] = tmp[5];
				dice[2] = tmp[6];
				dice[5] = tmp[1];
				break;
			case 4: //남
				dice[1] = tmp[5];
				dice[6] = tmp[2];
				dice[2] = tmp[1];
				dice[5] = tmp[6];
				break;
			}
			
			//다음 지면이 0이면
			if(map[nr][nc] == 0) {
				//다이스의 숫자가 지면에 주입
				map[nr][nc] = dice[1];
			}
			//0이아니면
			else {
				//다이스에 지면 숫자가 주입
				dice[1] = map[nr][nc];
				//그리고 0으로 바꿈	
				map[nr][nc] = 0;
			}
			//이동시켜줌
			curRow = nr;
			curCol = nc;
			//윗면은 7 - 현재숫자이므로 넣어준다.
			sb.append(dice[6]).append("\n");
		}
	}
	
}
