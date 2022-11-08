import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		int[] lTR = new int[N];
		int[] rTL = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//Input && left to right
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			int num = i - 1;
			
			while(num >= 0) {
				if(input[i] > input[num]) {
					lTR[i] = Math.max(lTR[i], lTR[num] + 1);
				}
				num--;
			}
			if(lTR[i] == 0) {
				lTR[i] = 1;
			}
		}
		
		//right to left
		for(int i = N - 1; i >= 0; i--) {
			int num = i + 1;
			
			while(num < N) {
				if(input[i] > input[num]) {
					rTL[i] = Math.max(rTL[i], rTL[num] + 1);
				}
				num++;
			}
			if(rTL[i] == 0) {
				rTL[i] = 1;
			}
		}
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans = Math.max(ans, lTR[i] + rTL[i]);
		}
		
		System.out.println(ans - 1);
	}
}
