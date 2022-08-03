import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] primeArr = new int[N];
		int count = N;
		for(int i = 0; i < N; i++) {
			primeArr[i] = sc.nextInt();
			if(primeArr[i] == 1) {
				count -=1;
			}
		}
		for(int i = 0; i < primeArr.length; i++) {
			int num = primeArr[i];
			for(int j = 2; j <= Math.sqrt(num); j++) { // 소수찾기
				if(num % j == 0) {
					count--;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
