import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static class Node {
		int row, col, height, dig, dist;
		boolean[][] prevRC;
		public Node(int row, int col, int height, int dist, int dig, boolean[][] prevRC) {
			this.row = row;
			this.col = col;
			this.height = height;
			this.dist = dist;
			this.dig = dig;
			this.prevRC = prevRC;
		}
	}

	static int N, K, longestDist;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static int[][] map;
	static boolean[][] visited;
	static Queue<Node> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			queue = new LinkedList<>();
			int maxHeight = 0;

			// map만들면서 최대값 구하기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int num = sc.nextInt();
					map[r][c] = num;
					if (num > maxHeight)
						maxHeight = num;
				}
			}
			visited = new boolean[N][N];
			// 초기값 입력
			longestDist = Integer.MIN_VALUE;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == maxHeight)
						queue.offer(new Node(r, c, maxHeight, 1, 0 , visited) );
						bfs();
				}
			}
			System.out.println("#" + tc + " " + longestDist);
		}

	}
	public static void bfs() {
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int row = node.row;
			int col = node.col;
			int height = node.height;
			int dist = node.dist;
			int dig = node.dig;
			
			boolean[][] check = new boolean[N][N];
			check = copyArr(node.prevRC);
			check[row][col] = true;
			
			longestDist = Math.max(longestDist, dist);
			
			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];

				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;

				if (map[nr][nc] < height && !check[nr][nc]) {
					queue.offer(new Node(nr, nc, map[nr][nc], dist + 1, dig , check));
				}

				if (map[nr][nc] >= height && dig == 0 && !check[nr][nc]) {
					for (int j = 1; j <= K; j++) {
						if (map[nr][nc] - j >= 0 && map[nr][nc] - j < height) {
							queue.offer(new Node(nr, nc, map[nr][nc] - j, dist + 1, dig + j, check));
						}
					}
				}
			}
		}
	}
	
	public static boolean[][] copyArr(boolean[][] prevRc) {
		boolean[][] tmp = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			System.arraycopy(prevRc[i], 0, tmp[i], 0, N);
		}
		return tmp;
	}
}
