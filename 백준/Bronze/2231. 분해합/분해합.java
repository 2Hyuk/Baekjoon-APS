import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int len = Integer.toString(N).length();
		int min = N - (9 * len);
		if(min < 0) min = 0;
		int result = 0;
		for(int i = min; i <= N; i++) {
			int tmp = i;
			int sum = i;
			while(tmp > 0) {
				sum += tmp % 10;
				tmp /= 10;
			}
			
			if(sum == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}
