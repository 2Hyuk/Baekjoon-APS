
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] area = new int[N];
		for (int i = 0; i < N; i++) {
			area[i] = sc.nextInt();
		}

		int B = sc.nextInt();
		double C = sc.nextDouble();

		long ans = 0;

		for (int i = 0; i < N; i++) {
			area[i] -= B;
			ans++;
			if (area[i] > 0) {
				if(area[i] / C == 0) {
					ans++;
				}
				else {
					ans += Math.ceil(area[i] / C);
				}
			}
		}
		System.out.println(ans);
	}
}
