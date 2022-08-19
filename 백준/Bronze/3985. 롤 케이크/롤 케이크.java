import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();
		int[] rollCake = new int[L+1]; // 0 ~ L-1까지
		// rollcake 배열에 조각을 가지는 방청객 번호 입력
		int maxPieceCnt = 0;
		int maxPieceIdx = 0;
		for (int i = 1; i <= N; i++) {
			int min = sc.nextInt();
			int max = sc.nextInt();
			// 가장 많이 받을것으로 예상되는 번호
			if(maxPieceCnt < max-min+1) {
				maxPieceCnt = max-min+1;
				maxPieceIdx = i;
			}
			for (int j = min; j <= max; j++) {
				if (rollCake[j] == 0) {
					rollCake[j] = i;
				}
			}
		}
		System.out.println(maxPieceIdx);
		// 각 인덱스의 번호의 사람이 가져간 롤케이크 개수
		int[] personNum = new int[N + 1]; // 0은 비워둔다.
		for (int j = 0; j < rollCake.length; j++) {
			personNum[rollCake[j]]++;
		}
		int maxIdx = 0;
		int maxCnt = 0;
		for (int j = 1; j < personNum.length; j++) {
			if(maxCnt < personNum[j]) {
				maxCnt = personNum[j];
				maxIdx = j;
			}
		}
		System.out.println(maxIdx);
	}
}
