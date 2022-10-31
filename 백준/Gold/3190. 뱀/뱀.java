
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Direction{
		int t;
		String dir;
		public Direction(int t, String dir) {
			super();
			this.t = t;
			this.dir = dir;
		}
		
	}
	static int N, K, L;
	static int snakeRow, snakeCol, dir, time;
	static int[][] board;
	static boolean flag = false;
	static Queue<Direction> q = new ArrayDeque<>();
	static Queue<int[]> snake = new ArrayDeque<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			//사과는 1, 뱀은 2;
			board[row][col] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			//방향정보 q에 넣음
			q.offer(new Direction(t, dir));
		}
		time = 0;
		dir = 2; //처음방향
		snakeRow = snakeCol = 0;
		board[snakeRow][snakeCol] = 2;
		snake.offer(new int[] {snakeRow, snakeCol});
		snakeGame();
		System.out.println(time);
	}
	
	static void snakeGame() {
		loop: while(true) {
			Direction direction = q.poll();
			if(direction == null) {
				flag = true;
			}
			//방향바꿀떄까지 직진한다.
			while(true) {
				time++;
				if(!move())
					break loop;
//				System.out.println(time);
//				for(int[] i : board) {
//					System.out.println(Arrays.toString(i));
//				}
//				System.out.println();
				if(!flag && time == direction.t) {
					break;
				}
			}
			//왼쪽으로 돌때
			if(direction.dir.equals("L")) {
				dir = dir - 1 == -1 ? 3 : dir - 1;
			}
			//오른쪽으로 돌 떄
			else if(direction.dir.equals("D")){
				dir = dir + 1 == 4 ? 0 : dir + 1;
			}
		}
	}
	static boolean move() {
		int nr = snakeRow;
		int nc = snakeCol;
		
		switch(dir) {
		case 0: //왼쪽
			nc--;
			break;
		case 1: //위
			nr--;
			break;
		case 2: //오른쪽
			nc++;
			break;
		case 3: //아래
			nr++;
			break;
		}
		
		if(nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == 2)
			return false;
		
		
		if(board[nr][nc] == 0) {
			int[] lastPos = snake.poll();
			board[lastPos[0]][lastPos[1]] = 0;
		}
		board[nr][nc] = 2;
		snakeRow = nr;
		snakeCol = nc;
		snake.offer(new int[] {snakeRow, snakeCol});
		return true;
	
	}
}
