import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] time = new int[1001];
		for (int i = 0; i < N; i++) {
			time[sc.nextInt()]++;
		}

		int sum = 0;
		int cnt = N;
		for (int i = 1; i < time.length; i++) {
			for (int j = time[i]; j > 0; j--) {
				sum += i * cnt;
				cnt--;
			}
		}
		System.out.println(sum);

	}
}
