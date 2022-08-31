
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 값을 입력받으면서 누적합 배열을 만든다.
	 * 이 후 i번째에서 j번째 합을 구하라고 했을 때 sumArr[j-1] - sumArr[i-2]를 하게 되면 답이 나온다.
	 * */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] sumArr = new int[N];
		//초기값
		st = new StringTokenizer(br.readLine());
		sumArr[0] = Integer.parseInt(st.nextToken());
		for(int i = 1; i < N; i++) {
			sumArr[i] += sumArr[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		for(int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int sum = 0;
			//i 가 1이라면  1부터 포함되므로 처음부터 j까지 누적한다.
			if(i == 1) {
				sum = sumArr[j-1];
			}
			//i가 1이 아니라면 i+1부터 시작해서 더해야 되므로 i-2까지의 누적합을 빼준다.
			else {
				sum = sumArr[j-1] - sumArr[i-2];
			}
			
			System.out.println(sum);
		}
	}
}
