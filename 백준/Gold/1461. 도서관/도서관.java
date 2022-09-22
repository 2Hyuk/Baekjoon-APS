
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	 * 배열 정렬을 한다. 멀리 있는 것은 제일 나중에 간다.
	 */

	static int[] book;
	static int N;
	static int M;
	static int minDistance;
	static int zeroIdx;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정리할 책의 수
		M = sc.nextInt(); // 한번에 들수 있는 수

		book = new int[N + 1];

		book[0] = 0;
		for (int i = 1; i < N + 1; i++) {
			book[i] = sc.nextInt();
		}

		Arrays.sort(book);

		for (int i = 0; i < book.length; i++) {
			if (book[i] == 0)
				zeroIdx = i;
		}

		// 제일끝쪽에 M개를 비교해서 숫자가 작은거 선택
		// M개가 안된다면 안되는것만큼만선택
		// 왼쪽 오른쪽 어느곳을 먼저할지
		// 왼쪽이나 오른쪽에 없을 떄
		int sum = 0;
		if (zeroIdx == 0 || zeroIdx == book.length - 1) {
			if(zeroIdx == 0) {
				sum = book[book.length - 1];
				int R = book.length - 1 - M;
				while(R > zeroIdx) {
					sum += 2 * book[R];
					R -= M;
				}
			}
			else {
				sum = Math.abs(book[0]);
				int L = M;
				while(L < zeroIdx) {
					sum += 2 * Math.abs(book[L]);
					L += M;
				}
			}
		}
		// 왼쪽 오른쪽 둘다 있을 때
		else {
			//왼쪽 먼저
			if (Math.abs(book[0]) < book[book.length - 1]) {
				sum = 0;
				int L = 0;
				while(L < zeroIdx) {
					sum += 2 * Math.abs(book[L]);
					L += M;
				}
				
				sum += book[book.length - 1];
				int R = book.length - 1 - M;
				while(R > zeroIdx) {
					sum += 2 * book[R];
					R -= M;
				}
			}
			//오른쪽 먼저
			else if(Math.abs(book[0]) > book[book.length - 1]) {
				sum = 0;
				int R = book.length - 1;
				while(R > zeroIdx) {
					sum += 2 * book[R];
					R -= M;
				}
				
				sum += Math.abs(book[0]);
				int L = M;
				while(L < zeroIdx) {
					sum += 2 * Math.abs(book[L]);
					L += M;
				}
				
				
			}
			//같을 떄 개수비교해서 개수 적은쪽부터
			else {
				if(book.length / 2 > zeroIdx) {
					sum = 0;
					int L = 0;
					while(L < zeroIdx) {
						sum += 2 * Math.abs(book[L]);
						L += M;
					}
					
					sum += book[book.length - 1];
					int R = book.length - 1 - M;
					while(R > zeroIdx) {
						sum += 2 * book[R];
						R -= M;
					}
				}
				else {
					sum = 0;
					int R = book.length - 1;
					while(R > zeroIdx) {
						sum += 2 * book[R];
						R -= M;
					}
					
					sum += Math.abs(book[0]);
					int L = M;
					while(L < zeroIdx) {
						sum += 2 * Math.abs(book[L]);
						L += M;
					}
				}
			}
			

		}
		
		System.out.println(sum);
	}

}
