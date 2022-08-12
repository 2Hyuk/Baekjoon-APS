import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/* Concept
 * 2차원 배열 100X100에서 초기 원소값을 0으로 한다.
 * 다음 색종이가 들어 가는 곳의 원소를 +1해준다.
 * 색종이 수 * 10(가로) * 10(세로) - (100X100배열에서 0이 아닌 원소의 값 - 1) 을 해주면 총 색종이가 차지하는 넓이가 된다.
 */
public class Main {
	static int[][] arr = new int[100][100];
	static final int PAPER_LEN = 10;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int paperCount = Integer.parseInt(br.readLine());
		
		//색종이 수만큼
		for(int i = 0; i < paperCount; i++) {
			st = new StringTokenizer(br.readLine());
			int xSpace = Integer.parseInt(st.nextToken()); // 왼쪽으로 부터 xSpace만큼 떨어져 있다.
			int ySpace = Integer.parseInt(st.nextToken()); // 아래로 부터 ySpace만큼 떨어져 있다.
			int xStart = xSpace; // 색종이 시작 x지점
			int yStart = 99 - ySpace; // 색종이 시작  y지점
			
			//배열에 색종이 구역만큼 +1;
			for(int x = xSpace; x < PAPER_LEN + xStart; x++) {
				for(int y = 99 - ySpace; y > yStart - PAPER_LEN; y--) {
					arr[y][x]++;
				}
			}
		}
		// 배열을 돌면서 색종이 수 * 10(가로) * 10(세로) - (100X100배열에서 0이 아닌 원소의 값 - 1) 해준다.
		int area = paperCount * PAPER_LEN * PAPER_LEN;
		for(int x = 0; x < arr.length; x++) {
			for(int y = 0; y < arr.length; y++) {
				if(arr[x][y] > 1)
					area -= (arr[x][y] - 1);
			}
		}
		System.out.println(area);
	}
}
