
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int redRow, redCol, blueRow, blueCol;

		public Node(int redRow, int redCol, int blueRow, int blueCol) {
			super();
			this.redRow = redRow;
			this.redCol = redCol;
			this.blueRow = blueRow;
			this.blueCol = blueCol;
		}

	}

	static int N, M;
	static String[][] board;
//	static boolean[][] visited;
	static Queue<Node> q = new ArrayDeque<Node>();
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	static boolean redHoleFlag, blueHoleFlag;

	public static void main(String[] args) throws IOException {
		// . : 빈칸, # : 벽, 0 : 구멍, R : 빨간구슬의 위치, B : 파란구슬의 위치
		// 4방향으로 기울이기 가능하다.
		// 게임종료조건: R이 0을 만날경우
		// BFS 사용해서 4방향으로 기울였을 떄 가능한 경우만 골라가며 진행한다.
		// 고르면 안되는 경우
		// 1. B가 0과 만나는 경우
		// 2. 이동을 끝까지 했는데 이미 왔었던 위치일 경우
		// R, B에 대해서 기울였을 때 이동위치를 다 기록해야 한다.
		// B에 대한 visited 방문체크는 굳이 할 필요 없을 듯?
		// 10번이상 기울였는데 정답이 안나오면 -1 출력한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new String[N][M];
//		visited = new boolean[N][M];
		// String 배열에 board 정보를받는다.
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().split("");
		}
		int redRow = 0, redCol = 0, blueRow = 0, blueCol = 0;
		// board에서 빨간공과 파란공의 위치를 찾아 준다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j].equals("R")) {
					redRow = i;
					redCol = j;
					board[i][j] = ".";
//					visited[redRow][redCol] = true;
				} else if (board[i][j].equals("B")) {
					blueRow = i;
					blueCol = j;
					board[i][j] = ".";
				}
			}
		}
		// 처음 위치 부터 bfs 한다.
		q.offer(new Node(redRow, redCol, blueRow, blueCol));

		int cnt = 0;
		loop1: while (!q.isEmpty()) {
			cnt++;
			if (cnt > 10) {
				cnt = -1;
				break loop1;
			}
			// 현재 q의 사이즈를 받아서 돌릴꺼다.
			// 이떄 q의 사이즈만큼 for문을 돌릴건데, for문을 돌리는 행위 자체가 depth가 된다.
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				// 4방향으로 기울인다. 순서는 좌 상 우 하
				for (int j = 0; j < 4; j++) {
					redHoleFlag = false;
					blueHoleFlag = false;
					int nRedRow = node.redRow + dr[j];
					int nRedCol = node.redCol + dc[j];
					int nBlueRow = node.blueRow + dr[j];
					int nBlueCol = node.blueCol + dc[j];

					// 움직일때 빨강공 움직이고, 파란공 움직이는데 -> 동시에 움직여서 구멍에 빠지면 실패
					// 한쪽방향으로 기울였을때 동시에 둘이 같은 위치를 갈수가 없지않나?
					// 끝까지 갔을 떄 blue가 구멍으로 들어간 적이 있다면 레드공이 들어갔던 말던 안들어간걸로 처리
					// 둘다 다음칸으로 이동 할 수 있을 때만 진행할거다.

					int[] rc = new int[4];
					switch (j) {
					case 0:
						if (nRedCol < nBlueCol)
							rc = redAndBlue(j, nRedRow, nRedCol, nBlueRow, nBlueCol);
						else
							rc = blueAndRed(j, nRedRow, nRedCol, nBlueRow, nBlueCol);
						break;
					case 1:
						if (nRedRow < nBlueRow)
							rc = redAndBlue(j, nRedRow, nRedCol, nBlueRow, nBlueCol);
						else
							rc = blueAndRed(j, nRedRow, nRedCol, nBlueRow, nBlueCol);
						break;
					case 2:
						if (nRedCol > nBlueCol)
							rc = redAndBlue(j, nRedRow, nRedCol, nBlueRow, nBlueCol);
						else
							rc = blueAndRed(j, nRedRow, nRedCol, nBlueRow, nBlueCol);
						break;
					case 3:
						if (nRedRow > nBlueRow)
							rc = redAndBlue(j, nRedRow, nRedCol, nBlueRow, nBlueCol);
						else
							rc = blueAndRed(j, nRedRow, nRedCol, nBlueRow, nBlueCol);
						break;
					}

					// 블루공이 구멍에 안빠졌을 때
					if (!blueHoleFlag) {
						// 레드공이 구멍에 빠졋을 경우 : 게임을 끝낸다.
						if (redHoleFlag) {
							break loop1;
						}
						// 레드공이 구멍에 안빠졌다면 계속 큐에넣고 진행
						// visited는 쓰면 안된다. b를 구석에 몰아넣고 다시 나오는 경우도 있으니까
						else {
							q.offer(new Node(rc[0], rc[1], rc[2], rc[3]));
						}
					} else {
						redHoleFlag = false;
						blueHoleFlag = false;
					}
				}
			}
		}
		if (!redHoleFlag)
			System.out.println(-1);
		else
			System.out.println(cnt);

	}
	//좌표가 필요한 경우는 빨강, 파랑공 둘다 구멍에 들어갈 경우니깐 구멍에 하나라도 들어간다면 좌표를 신경쓰지말고 break해라
	static int[] redAndBlue(int j, int nRedRow, int nRedCol, int nBlueRow, int nBlueCol) {
		while (true) {
			if (board[nRedRow][nRedCol].equals("O")) {
				redHoleFlag = true;
				break;
			} 
			else if (board[nRedRow][nRedCol].equals("#")) {
				nRedRow -= dr[j];
				nRedCol -= dc[j];
				break;
			} 
			else {
				nRedRow += dr[j];
				nRedCol += dc[j];

			}
		}

		while (true) {
			if (board[nBlueRow][nBlueCol].equals("O")) {
				blueHoleFlag = true;
				break;
			}
			else if (board[nBlueRow][nBlueCol].equals("#") || (nBlueRow == nRedRow && nBlueCol == nRedCol)) {
				nBlueRow -= dr[j];
				nBlueCol -= dc[j];
				break;
			} 
			else {
				nBlueRow += dr[j];
				nBlueCol += dc[j];

			}
		}

		return new int[] { nRedRow, nRedCol, nBlueRow, nBlueCol };
	}

	static int[] blueAndRed(int j, int nRedRow, int nRedCol, int nBlueRow, int nBlueCol) {
		while (true) {
			if(board[nBlueRow][nBlueCol].equals("O")) {
				blueHoleFlag = true;
				break;
			}
			else if (board[nBlueRow][nBlueCol].equals("#")) {
				nBlueRow -= dr[j];
				nBlueCol -= dc[j];
				break;
			} else {
				nBlueRow += dr[j];
				nBlueCol += dc[j];

			}
		}

		while (true) {
			if (board[nRedRow][nRedCol].equals("O")) {
				redHoleFlag = true;
				break;
			} 
			else if (board[nRedRow][nRedCol].equals("#") || (nBlueRow == nRedRow && nBlueCol == nRedCol)) {
				nRedRow -= dr[j];
				nRedCol -= dc[j];
				break;
			} else {
				nRedRow += dr[j];
				nRedCol += dc[j];

			}
		}
		return new int[] { nRedRow, nRedCol, nBlueRow, nBlueCol };
	}
}
