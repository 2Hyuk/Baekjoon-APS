
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double N = sc.nextInt();
		int B = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(N != 0) {
			int r = (int)(N % B);
			if(r >= 10) {
				sb.append((char)(r + 55));
			}
			else {
				sb.append(r);
			}
			N = Math.floor(N / B);
		}
		System.out.println(sb.reverse());

	}
}
