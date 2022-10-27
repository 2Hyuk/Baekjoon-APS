
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int row, col;

		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}
	/*
	 * 일단 바깥 빈공간을 전부 2로 만들어서 3가지 영역으로 만든다. 2:바깥, 1:치즈, 0:치즈 내부
	 * 1을 사방탐색하면서 2가 2개있다면 큐에 넣어놓는다.
	 * 이후에 큐에서 하나씩꺼내면서 사방탐색하면서 녹인다.
	 */

	static int N, M;
	static String[][] paper;
	static Queue<Node> q;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new String[N][M];
		for (int i = 0; i < N; i++) {
			paper[i] = br.readLine().split(" ");
		}
		q = new ArrayDeque<>();
		q.offer(new Node(0, 0));
		setOuter();
		
		int time = 0;
		while(true) {
			if(melt()) {
				time++;
				setOuter();
			}
			else {
				break;
			}
		}
		System.out.println(time);
	}

	static void setOuter() {
		while (!q.isEmpty()) {
			Node node = q.poll();
			paper[node.row][node.col] = "2";
			
			for (int i = 0; i < 4; i++) {
				int nr = node.row + dr[i];
				int nc = node.col + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || paper[nr][nc].equals("1") || paper[nr][nc].equals("2"))
					continue;

				paper[nr][nc] = "2";
				q.offer(new Node(nr, nc));
			}
		}
	}

	static boolean melt() {
		boolean flag = false;
		for (int r = 1; r < N - 1; r++) {
			for(int c = 1; c < M - 1; c++) {
				if(paper[r][c].equals("1")) {
					int cnt = 0;
					for(int k = 0; k < 4; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						if(paper[nr][nc].equals("2"))
							cnt++;
					}
					if(cnt >= 2) {
						q.offer(new Node(r, c));
						flag = true;
					}
						
				}
			}
		}
		return flag;
	}
}
