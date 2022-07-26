import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = 0;
		int N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			int tmp = i;
			int sum = 0;
			while(tmp > 0) {
				sum += tmp % 10;
				tmp /= 10;
			}
			if((i % sum == 0)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
