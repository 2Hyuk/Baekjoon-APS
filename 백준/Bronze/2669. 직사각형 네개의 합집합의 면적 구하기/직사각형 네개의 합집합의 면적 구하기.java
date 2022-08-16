import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] arr = new boolean[100][100];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			setRect(x1, y1, x2, y2);
		}
		
		int area = 0;
		for(boolean[] bArr : arr) {
			for(boolean b : bArr) {
				area += (b == true) ? 1 : 0;
			}
		}
		System.out.println(area);
	}
	
	static void setRect(int x1, int y1, int x2, int y2) {
		for(int i = x1; i < x2; i++) {
			for(int j = y2; j > y1; j--) {
				arr[i][j] = true;
			}
		}
	}
}
