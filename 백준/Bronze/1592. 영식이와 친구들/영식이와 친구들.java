import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] arr = new int[N];
		arr[0] = 1; // 시작
		int idx = 0;
		int cnt = 0;
		//홀수면 시계방향 L번, 짝수면 반시계 L번
		while(arr[idx] != M) {
			cnt++;
			//짝수일 떄
			if(arr[idx] % 2 == 0) {
				// 반시계로 L번쨰
				idx = idx - L < 0 ? arr.length + idx - L : idx - L;
				arr[idx]++;
			}
			//홀수일 때
			else {
				// 시계로 L번째
				idx = idx + L >= arr.length ? idx + L - arr.length : idx + L;
				arr[idx]++;
			}
		}
		System.out.println(cnt);

	}
}
