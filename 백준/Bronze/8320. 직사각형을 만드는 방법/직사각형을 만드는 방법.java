import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = n;
		
		for(int i = 2; i * i <= n; i++) {
			cnt += ((n - i * i) / i) + 1;
		}
		System.out.println(cnt);
	}
}
