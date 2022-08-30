
import java.util.Scanner;

public class Main {
	/*
	 * coin을 배열에 입력받아 놓고, 뒤에서 부터 순서대로 K보다 작은지 큰지 비교하여 k보다 작다면 k에서 빼주는 것을 반복하면서 인덱스를
	 * 감소시킨다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] coin = new int[N];

		int cnt = 0;
		for(int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}
		for (int i = N - 1; i >= 0; i--) {
			// 코인 값이 K보다 큰 경우 인덱스를 줄인다.
			if (coin[i] > K) {
				continue;
			}
			// 코인 값이 K보다 작을 경우 빼주고 다시 실행한다.
			else if (coin[i] < K) {
				// K가 코인 값보다 작거나 같아지면 while문 종료
				while (coin[i] < K) {
					K -= coin[i];
					cnt++;
				}
			}
			// 코인 값이 K와 같을 경우 정답이다.
			if (coin[i] == K) {
				cnt++;
				break;
			}
		}
		System.out.println(cnt);

	}
}
