
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int cnt = 0;
		
		// 뒷자리 0의 개수는 2 x 5의 개수이므로, 5의 개수만 세어주면 된다.
		while(n >= 5) {
			cnt += n / 5;
			n /= 5;
		}
		
		System.out.println(cnt);

	}
}
