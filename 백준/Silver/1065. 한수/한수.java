import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 99;
		if(N < 100) {
			System.out.println(N);
		}
		else {
			for(int i = 100; i <= N; i++) {
				int tmp = i;
				int[] arr = new int[Integer.toString(i).length()];
				int idx = 0;
				while(tmp > 0) {
					arr[idx++] = tmp % 10;
					tmp /= 10;
				}
				int tol = arr[1] - arr[0];
				boolean ishansoo = true;
				for(int j = idx -1; j > 0; j--) {
					if(arr[j] - arr[j - 1] != tol) {
						ishansoo = false;
						break;
					}
				}
				if(ishansoo)
					result++;
			}
			System.out.println(result);
		}
	}
}
