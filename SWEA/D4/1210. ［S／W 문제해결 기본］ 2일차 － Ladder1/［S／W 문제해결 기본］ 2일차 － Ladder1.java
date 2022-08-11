
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] ladder = new int[100][100];
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			int T = Integer.parseInt(br.readLine());
			// ladder map 생성
			for (int row = 0; row < 100; row++) {
				st = new StringTokenizer(br.readLine());
				for (int col = 0; col < 100; col++) {
					ladder[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			// 도착지점 찾기
			int endPoint = 0;
			for (int col = 0; col < 100; col++) {
				if(ladder[0][col] == 1) { // 출발지점 후보군
					list.add(col);
				} 
				if (ladder[99][col] == 2) { // 도착지점
					endPoint = col;
				}
			}
			// 도착지점의 사다리가 후보군 리스트의 몇번째 인덱스인지?
			int endColIdx = 0;
			for(int j = 0; j < list.size(); j++) {
				if(list.get(j) == endPoint)
					endColIdx = j;
			}
			// 도착지점으로부터 위로 올라가면서 출발지점을 찾는다.
			int startPoint;
			int curRow = 99;
			int curCol = endPoint;

			while (true) {
				// 1. 왼쪽
				if (curCol != 0 && ladder[curRow][curCol - 1] == 1) {
					endColIdx -= 1;
					curRow -= 1;
					curCol = list.get(endColIdx);
				}
				// 2. 오른쪽
				else if (curCol != 99 && ladder[curRow][curCol + 1] == 1) {
					endColIdx += 1;
					curRow -= 1;
					curCol = list.get(endColIdx);
				}
				// 3. 위
				else {
					curRow -= 1;
				}

				if (curRow == 0) {
					System.out.println("#" + i + " " + list.get(endColIdx));
					break;
				}
			}
		}
	}
}
