
import java.util.Scanner;

public class Main {
	static int[] arr;
	static int S;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		cnt = 0;
		powerSet(0 ,0);
		//모든 idx에 대해 선택하지 않았을 경우 sum = 0이 나오게 되는데 이러한 경우는 빼줘야 된다.
		if(S == 0) {
			cnt--;
		}
		System.out.println(cnt);

	}
	
	static void powerSet(int idx, int sum) {
		// idx를 넣고 안넣고를 반복하여 부분집합을 완성 했을 떄
		if(idx == arr.length) {
			//부분집합의 합이  S와 같다면
			if(sum == S) {
				cnt++;
			}
			return;
		}
		
		//idx를 포함하는 경우
		powerSet(idx + 1, sum + arr[idx]);
		//idx를 포함하지 않는 경우
		powerSet(idx + 1, sum);
	}
}
