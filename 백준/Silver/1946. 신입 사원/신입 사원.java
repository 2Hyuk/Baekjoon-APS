
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N+1];
			
			for(int i = 1; i <= N; i++) {
				int grade1 = sc.nextInt();
				int grade2 = sc.nextInt();
				arr[grade1] = grade2;
			}
			
			int min = arr[1];
			int ans = 1;
			for(int i = 2; i <= N; i++) {
				if(min > arr[i]) {
					ans++;
					min = arr[i];
				}
			}
			System.out.println(ans);
		}
	}
}
