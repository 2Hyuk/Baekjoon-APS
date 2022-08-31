
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	 * 값을 입력받으면서 누적합 배열을 만든다.
	 * 이 후 i번째에서 j번째 합을 구하라고 했을 때 sumArr[j-1] - sumArr[i-2]를 하게 되면 답이 나온다.
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] sumArr = new int[N];
		//초기값
		sumArr[0] = sc.nextInt();
		for(int i = 1; i < N; i++) {
			sumArr[i] += sumArr[i - 1] + sc.nextInt();
		}
		
		for(int k = 0; k < M; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
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
