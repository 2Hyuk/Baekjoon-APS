
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Enemy{
		int row, col;
		public Enemy(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
		
	static int N, M, D, row;
	static int enemyCnt;
	static int currEnemy;
	static int[] archerPos;
	static int maxKill;
	static Queue<Enemy> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		enemyCnt = 0;
		int[][] originMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				originMap[i][j] = Integer.parseInt(st.nextToken());
				if(originMap[i][j] == 1) {
					enemyCnt++;
				}
			}
		}
		int[][] map;
		q = new LinkedList<>();
		maxKill = Integer.MIN_VALUE;
		archerPos = new int[3];
		for(int i = 0; i < M - 2; i++) {
			archerPos[0] = i;
			for(int j = i + 1; j < M - 1; j++) {
				archerPos[1] = j;
				for(int k = j + 1; k < M; k++) {
					archerPos[2] = k;
					currEnemy = enemyCnt;
					row = N;
					map = copyMap(originMap);
					simulation(map);
				}
			}
		}
		System.out.println(maxKill);
	}
	
	static void simulation(int[][] map) {
		
		if(row == 0 || currEnemy == 0) {
			maxKill = Math.max(maxKill, enemyCnt - currEnemy);
			return;
		}
		
		attckEnemy(map);
		//moveEnemy(map);
		row--;
		simulation(map);
	}
	
	
	static void moveEnemy(int[][] map) {
		int[] arr = {7, 0, 0, 0, 0, 7, 0, 0, 0, 7};
		System.out.println(row);
		for(int[] i : map) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println("[^, 0, 0, 0, 0, ^, 0, 0, 0, ^]");
		System.out.println(currEnemy);
		
		for(int i = 0; i < M; i++) {
			map[row - 1][i] = arr[i];
		}
		row--;
	}
	
	
	static void attckEnemy(int[][] map) {
		for(int i = 0; i < 3; i++) 
			findTarget(archerPos[i], map);
			
		while(!q.isEmpty()) {
			Enemy e = q.poll();
			if(map[e.row][e.col] == 1) {
				map[e.row][e.col] = 8;
				currEnemy--;
			}
		}
	}
	
	static void findTarget(int col, int[][] map){ 
		int eRow = -1;
		int eCol = -1;
		int dist = Integer.MAX_VALUE;
		for(int i = 1; i <= D; i++) {
			for(int j = 0; j <= D - i; j++) {
				if(row - i < 0) continue;
				if(col + j < M && map[row - i][col + j] == 1) { // 오른쪽에서 적을 찾았을 때
					if(dist > i + j) {	//새로발견한 적이 원래 타겟보다 가까우면 바꿔준다.
						eRow = row - i;
						eCol = col + j;
						dist = i + j;
					}
					else if(dist == i + j) { //같은 거리에 있을떄
						if(eCol > col + j) { //새로발견한 적이 원래적보다 왼쪽에 있다면
							eRow = row - i; //타겟을 바꿔준다.
							eCol = col + j;
						}
					}
				}
				
				if(col - j >= 0 && map[row - i][col - j] == 1) { // 왼쪽에서 적을 찾았을 때
					if(dist > i + j) {	//새로발견한 적이 원래 타겟보다 가까우면 바꿔준다.
						eRow = row - i;
						eCol = col - j;
						dist = i + j;
					}
					else if(dist == i + j) { //같은 거리에 있을떄
						if(eCol > col - j) { //새로발견한 적이 원래적보다 왼쪽에 있다면
							eRow = row - i; //타겟을 바꿔준다.
							eCol = col - j;
						}
					}
				}
			}
		}
		if(eRow != -1 && eCol != -1)
			q.add(new Enemy(eRow, eCol));
	}
	
	static int[][] copyMap(int[][] originMap){
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			System.arraycopy(originMap[i], 0, map[i], 0, M);
		}
		return map;
	}
}
