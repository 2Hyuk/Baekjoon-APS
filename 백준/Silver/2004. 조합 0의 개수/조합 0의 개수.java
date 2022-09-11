
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		// 분자에서 2와 5의 개수중 적은 수가 0의 개수다.
		// 분자의 2개수 - 분모의 2개수, 분자의 5개수 - 분모의 5개중 작은 값이 0의 개수이다.
		
		// 분모의 2와 5의개수
		int downTwoCnt = findTwoCount(Math.abs(n - m)) + findTwoCount(m);
		int downFiveCnt = findFiveCount(Math.abs(n - m)) + findFiveCount(m);
		
		// 분자의 2와 5의 개수
		int upTwoCnt = findTwoCount(n);
		int upFiveCnt = findFiveCount(n);
		
		System.out.println(Math.min(upTwoCnt - downTwoCnt, upFiveCnt - downFiveCnt));

	}
	
	static int findTwoCount(int n) {
		int count = 0;
		while(n >= 2) {
			count += n / 2;
			n /= 2;
		}
		return count;
	}
	
	static int findFiveCount(int n) {
		int count = 0;
		while(n >= 5) {
			count += n / 5;
			n /= 5;
		}
		return count;
	}
}
