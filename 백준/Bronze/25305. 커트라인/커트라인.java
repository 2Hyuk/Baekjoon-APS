import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] input = new int[N];
		int[] sumArr = new int[10001];
		for(int i = 0; i < N; i++) {
			int point = Integer.parseInt(st.nextToken());
			input[i] = point;
			sumArr[point]++;
		}
		
		for(int i = 1; i < sumArr.length; i++) {
			sumArr[i] += sumArr[i-1];
		}
		
		int[] countingArr = new int[N];
		
		for(int i = N - 1; i >= 0; i--) {
			countingArr[--sumArr[input[i]]] = input[i];
		}
		//N-1번째 인덱스가 1등, N-2가 2등... N-k 가 k등
		System.out.println(countingArr[N-k]);
	}
}
