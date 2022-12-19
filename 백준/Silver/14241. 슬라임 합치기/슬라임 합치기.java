import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int point = 0;
		int prevNum = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N - 1; i++) {
			int currNum = Integer.parseInt(st.nextToken());
			point += prevNum * currNum;
			prevNum = prevNum + currNum;
		}
		
		System.out.println(point);
	}
}
