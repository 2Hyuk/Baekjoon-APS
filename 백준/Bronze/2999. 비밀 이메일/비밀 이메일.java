import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String email = sc.next();
		int N = email.length();
		int R = 0;
		
		for(int i = 1; i <= Math.sqrt(N); i++) {
			if(N % i == 0) {
				R = Math.max(R, i);
			}
		}
		int C = N / R;
		int cnt = N;
		int idx = 0;
		while(cnt != 1) {
			sb.append(email.charAt(idx));
			idx = (idx+R) % (N-1);
			cnt--;
		}
		sb.append(email.charAt(N-1));
		System.out.println(sb);

	}
}
