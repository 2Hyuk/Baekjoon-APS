
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int R = sc.nextInt();
			String S = sc.next();
			
			for(int i = 0; i < S.length(); i++) {
				for(int j = 0; j < R; j++) {
					sb.append(S.charAt(i));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
