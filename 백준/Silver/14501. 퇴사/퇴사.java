
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] T;
	static int[] P;
	static int N;
	static int maxValue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		T = new int[N+1];
		P = new int[N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		maxValue = 0;
		recur(1, 0);
		System.out.println(maxValue);
	}
	
	static void recur(int idx, int value) {
		// 날짜가 퇴사날을 넘어가는 경우, 리턴해준다.
		// 만약 N일 날짜가 하루만에 끝나는 상담일 경우도 있으므로 N+1로 잡아준다.
		if(idx > N + 1)
			return;
		else {
			maxValue = Math.max(maxValue, value);
		}
		
		for(int i = idx; i <= N; i++) {
			recur(i + T[i], value + P[i]);
		}
//		if(idx <= N) {
//			recur(idx + T[idx], value + P[idx]);
//			recur(idx + 1, value );
//			
//		}
	}
}
