
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int grade1 = Integer.parseInt(st.nextToken());
				int grade2 = Integer.parseInt(st.nextToken());
				arr[grade1] = grade2;
			}
			
			int min = arr[1];
			int ans = 1;
			for(int i = 2; i <= N; i++) {
				if(min > arr[i]) {
					ans++;
					min = arr[i];
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
