
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 최대 5번 이동시켜서 가장 큰 값을 구한다.
 * 그러면 한번의 이동마다 4가지의 이동방향을 구한다.
 * 모든 경우의 수를 해봐야 최대값을 아니깐 깊이우선탐색을 사용한다.
 * 근데 조합을 써서 모든 경우의 수를 구해줄거다.
 */
public class Main {
	static int N, maxNumber;
	static int[][] orgBoard;
	static int[][] board;
	// 방향 조합에 쓸 배열
	static int[] dirArr = new int[5];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		orgBoard = new int[N][N];
		board = new int[N][N];
		maxNumber = 0;
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				orgBoard[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combi(0);
		System.out.println(maxNumber);
	}
	
	//모든 숫자의 순열 경우의 수를 5개를 찾는다. ->방향선택
	//찾은 후에 맵을 새로 카피하고 선택한 순서대로 2048게임 시작
	static void combi(int sIdx) {
		if (sIdx == 5) {
			copyBoard();
			dfs(0);
			return;
		}

		for (int i = 0; i < 4; i++) {
			dirArr[sIdx] = i;
			combi(sIdx + 1);
		}
	}

	//5개 다 돌리면 가장 큰 값을 찾는다.
	static void dfs(int idx) {
		if (idx == 5) {
			maxNumber = Math.max(maxNumber, findMaxNumber());
			return;
		}

		int dir = dirArr[idx];

		switch (dir) {
		case 0:// 왼쪽으로 밀기
			leftPush();
			break;
		case 1:// 위로 밀기
			upPush();
			break;
		case 2:// 오른쪽으로 밀기
			rightPush();
			break;
		case 3:// 아래로 밀기
			downPush();
			break;
		}
		
		dfs(idx + 1);
	}

	static void copyBoard() {
		for (int i = 0; i < N; i++) {
			System.arraycopy(orgBoard[i], 0, board[i], 0, N);
		}
	}

	static int findMaxNumber() {
		int maxNum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] > maxNum) {
					maxNum = board[i][j];
				}
			}
		}
		return maxNum;
	}

	static void leftPush() {
		Deque<Integer> dq = new ArrayDeque<Integer>();
		//0이아닌 수는 덱에 넣는다.
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (board[r][c] != 0) {
					dq.offerLast(board[r][c]);
					board[r][c] = 0;
				}
			}
			int idx = 0;
			//덱에서 2개를 꺼낼 수 있을 떄 꺼내서 비교하고
			//같다면 넣고, 아니면 처음값만 넣고 뒤에값은 덱의 앞에 넣는다.
			while (dq.size() >= 2) {
				int num1 = dq.pollFirst();
				int num2 = dq.pollFirst();

				if (num1 == num2) {
					board[r][idx] = num1 + num2;
				} else {
					board[r][idx] = num1;
					dq.offerFirst(num2);
				}
				idx++;
			}
			//남은 값을 모두 꺼내서 넣는다.
			if (dq.size() > 0) {
				int num = dq.pollFirst();
				board[r][idx] = num;
			}
		}
	}
	
	static void rightPush() {
		Deque<Integer> dq = new ArrayDeque<Integer>();
		for (int r = 0; r < N; r++) {
			for (int c = N - 1; c >= 0; c--) {
				if (board[r][c] != 0) {
					dq.offerLast(board[r][c]);
					board[r][c] = 0;
				}
			}
			int idx = N - 1;

			while (dq.size() >= 2) {
				int num1 = dq.pollFirst();
				int num2 = dq.pollFirst();

				if (num1 == num2) {
					board[r][idx] = num1 + num2;
				} else {
					board[r][idx] = num1;
					dq.offerFirst(num2);
				}
				idx--;
			}

			if (dq.size() > 0) {
				int num = dq.pollFirst();
				board[r][idx] = num;
			}
		}
	}
	
	static void upPush() {
		Deque<Integer> dq = new ArrayDeque<Integer>();
		for (int c = 0; c < N; c++) {
			for (int r = 0; r < N; r++) {
				if (board[r][c] != 0) {
					dq.offerLast(board[r][c]);
					board[r][c] = 0;
				}
			}
			int idx = 0;

			while (dq.size() >= 2) {
				int num1 = dq.pollFirst();
				int num2 = dq.pollFirst();

				if (num1 == num2) {
					board[idx][c] = num1 + num2;
				} else {
					board[idx][c] = num1;
					dq.offerFirst(num2);
				}
				idx++;
			}

			if (dq.size() > 0) {
				int num = dq.pollFirst();
				board[idx][c] = num;
			}
		}
	}
	
	static void downPush() {
		Deque<Integer> dq = new ArrayDeque<Integer>();
		for (int c = 0; c < N; c++) {
			for (int r = N - 1; r >= 0; r--) {
				if (board[r][c] != 0) {
					dq.offerLast(board[r][c]);
					board[r][c] = 0;
				}
			}
			int idx = N - 1;

			while (dq.size() >= 2) {
				int num1 = dq.pollFirst();
				int num2 = dq.pollFirst();

				if (num1 == num2) {
					board[idx][c] = num1 + num2;
				} else {
					board[idx][c] = num1;
					dq.offerFirst(num2);
				}
				idx--;
			}

			if (dq.size() > 0) {
				int num = dq.pollFirst();
				board[idx][c] = num;
			}
		}
	}
}
