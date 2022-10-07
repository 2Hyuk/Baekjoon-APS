
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static String[][] map = new String[5][5];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().split(" ");
		}

		Queue<String> q = new LinkedList<>();
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				q.offer(st.nextToken());
			}
		}
		int ans = 0;
		while (!q.isEmpty()) {
			checkNum(q.poll());
			ans++;
			if(checkBingo())
				break;
		}
		System.out.println(ans);

	}

	static void checkNum(String str) {
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				if (map[r][c].equals(str)) {
					map[r][c] = "0";
					return;
				}
			}
		}
	}

	static boolean checkBingo() {
		int bingo = 0;

		// 가로, 세로검사
		int ltrCnt = 0, rtlCnt = 0;
		for (int r = 0; r < 5; r++) {
			int rowCnt = 0, colCnt = 0;
			for (int c = 0; c < 5; c++) {
				if (map[r][c].equals("0"))
					rowCnt++;
				if (map[c][r].equals("0"))
					colCnt++;
				if (r == c && map[r][c].equals("0"))
					ltrCnt++;
				if (r + c == 4 && map[r][c].equals("0"))
					rtlCnt++;
			}

			if (rowCnt == 5)
				bingo++;
			if (colCnt == 5)
				bingo++;
			if (bingo >= 3)
				return true;

		}

		if (ltrCnt == 5)
			bingo++;
		if (rtlCnt == 5)
			bingo++;
		if (bingo >= 3)
			return true;

		return false;
	}
}
