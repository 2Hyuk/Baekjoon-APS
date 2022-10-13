
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		long ans = 0;
		int cnt = 0;
		loop:for(int i = 1; i < 1000; i++) {
			for(int j = 0; j < i; j++) {
				cnt++;
				if(cnt >= A && cnt <= B) {
					ans += i;
				}
				if(cnt > B) {
					break loop;
				}
			}
		}
		System.out.println(ans);
	}
}
