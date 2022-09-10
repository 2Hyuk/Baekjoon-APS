
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
	
		for(int tc = 1; tc <= T; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			if(A < B) {
				int tmp = B;
				B = A;
				A = tmp;
			}
			
			int lcm = (A * B) / gcd(A, B);
			sb.append(lcm).append("\n");
		}
		System.out.println(sb);
	}
	
	static int gcd(int A, int B) {
		while(B > 0) {
			int r = A % B;
			A = B;
			B = r;
		}
		return A;
	}
}
