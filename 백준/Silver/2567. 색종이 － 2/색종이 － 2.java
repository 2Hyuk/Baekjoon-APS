import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* Concept
 * boolean 배열에서 색종이 범위만큼 true
 * 배열을 전부 돌면서 true -> false, false -> true가 되는 부분을 찾는다.
 * 
 */
public class Main {
	static boolean[][] arr = new boolean[102][102];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int paperCount = Integer.parseInt(br.readLine());

		// 색종이 수만큼
		for (int i = 0; i < paperCount; i++) {
			st = new StringTokenizer(br.readLine());
			int xSpace = Integer.parseInt(st.nextToken()); // 왼쪽으로 부터 xSpace만큼 떨어져 있다.
			int ySpace = Integer.parseInt(st.nextToken()); // 아래로 부터 ySpace만큼 떨어져 있다.
			for(int x = xSpace + 1; x < 10 + 1 + xSpace; x++) {
				for(int y = ySpace + 1; y < 10 + 1+ ySpace; y++) {
						arr[x][y] = true;
				}
			}
		}

		// 행, 열을 돌면서 true false가 바뀌는 부분만 센다
		int round = 0;
		for (int x = 0; x < 101; x++) {
			for (int y = 0; y < 101; y++) {
				round = arr[x][y] == arr[x][y+1] ? round : round + 1; // 열을 돌면서 찾음
				round = arr[y][x] == arr[y+1][x] ? round : round + 1;// 행들 돌면서 찾음
			}
		}
		System.out.println(round);
	}
}