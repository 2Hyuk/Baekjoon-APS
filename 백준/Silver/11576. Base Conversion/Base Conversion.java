
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// A진수, B진수 받기
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		// A진수의 자리수 받기
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		// 배열에 A진수 자리수 받기
		st = new StringTokenizer(br.readLine());
		int[] a = new int[m];
		for(int i = 0; i < m ; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		// A진수를 10진수로 변환
		int dec = 0;
		for(int i = a.length - 1, j = 0; i >= 0; i--, j++) {
			dec += Math.pow(A, j) * a[i];
		}
		
		// 10진수를 B진수로 변환
		StringBuilder sb = new StringBuilder();
		while(dec != 0) {
			sb.insert(0, " ").insert(0, dec % B);
			dec = (int) Math.floor(dec / B);
		}
		System.out.println(sb);

	}
}
