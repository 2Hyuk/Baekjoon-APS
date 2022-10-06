
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Position implements Comparable<Position> {
		int row, col, likeCnt, blankCnt;

		public Position(int row, int col, int likeCnt, int blankCnt) {
			super();
			this.row = row;
			this.col = col;
			this.likeCnt = likeCnt;
			this.blankCnt = blankCnt;
		}

		@Override
		// 규칙에 맞게 자리 정하기
		public int compareTo(Position o) {
			if (this.likeCnt == o.likeCnt) {
				if (this.blankCnt == o.blankCnt) {
					if (this.row == o.row) {
						return this.col - o.col;
					} else {
						return this.row - o.row;
					}
				}
				return o.blankCnt - this.blankCnt;
			}
			return o.likeCnt - this.likeCnt;
		}

	}

	static int[][] map;
	static int N;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	static List<Integer>[] sList;

//	비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
//	1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
//	2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int[] likePoint = { 0, 1, 10, 100, 1000 }; // 호감도 점수배열
		Queue<Integer> q = new LinkedList<>(); // 들어온 학생순서대로 자리배치해야되니깐
		sList = new ArrayList[N * N + 1]; // 학생정보 넣어줄 배열
		for (int i = 1; i <= N * N; i++) {
			sList[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int myNum = Integer.parseInt(st.nextToken()); // 자기 번호
			q.offer(myNum); // 순서대로 뽑아야되니깐 넣고

			for (int j = 0; j < 4; j++) {
				// 친구들 번호 받아서 리스트에 넣고
				int friend = Integer.parseInt(st.nextToken());
				sList[myNum].add(friend); // 호감가는 친구들 넣고
			}
		}

		while (!q.isEmpty()) {
			int num = q.poll();
			setPosition(num); // 넣은순서대로 빼서 자리배치하겠다.
		}
		int result = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int likeCnt = 0;
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];

					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;
					
					if (sList[map[r][c]].indexOf(map[nr][nc]) != -1) {
						likeCnt++;
					}
				}
				result += likePoint[likeCnt];
			}
		}
		System.out.println(result);

	}

	static void setPosition(int num) {
		PriorityQueue<Position> pq = new PriorityQueue<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] != 0)
					continue;

				int likeCnt = 0;
				int blankCnt = 0;
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];

					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;

					// 호감리스트에 있다면 증가
					if (sList[num].indexOf(map[nr][nc]) != -1) {
						likeCnt++;
					}
					// 호감리스트에 없고 빈칸이면 증가
					else if (map[nr][nc] == 0) {
						blankCnt++;
					}
				}
				pq.offer(new Position(r, c, likeCnt, blankCnt));
			}
		}

		Position pos = pq.poll();
		map[pos.row][pos.col] = num;
	}
}
