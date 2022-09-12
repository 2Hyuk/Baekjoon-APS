
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] ch;
	static int[] arr;
	// 1000000 이 100개 가 들어올 경우에 int형의 범위를 넘어선다.
	static double sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 모든 쌍에 대한 최대공약수의 합을 구한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			arr = new int[n];
			ch = new boolean[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			sum = 0;
			combi(0,0);
			System.out.printf("%.0f\n", sum);
		}
	}
	
	static void combi(int idx, int cnt) {
		//2개를 골랐을 경우 최대 최소값을 찾아 최대공약수를 구한다.
		if(cnt == 2) {
			int i, j;
			
			for(i = 0; i < ch.length; i++) {
				if(ch[i] == true)
					break;
			}
			for(j = i + 1; j < ch.length; j++) {
				if(ch[j] == true)
					break;
			}
			
			sum += gcd(arr[i], arr[j]);
			return;
		}
		
		//모든쌍을 만들어준다.
		for(int i = idx; i < arr.length; i++) {
			if(ch[i] == false) {
				ch[i] = true;
				combi(i + 1, cnt + 1);
				ch[i] = false;
			}
		}
	}
	
	static int gcd(int a, int b) {
		
		while(b > 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		
		return a;
	}
}
