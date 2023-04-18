
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long K = sc.nextLong();
		if(K == 0){
			System.out.println(0);
		}
		else if(K % 2 == 0)
			System.out.println(-1);
		else if(K == 1 || K == -1){
			System.out.println(1);
		}
		else {
			int count = 1;
			long num = 2;
			while(true) {
				count++;
				num *= 2;

				if (Math.abs(K) <= num - 1) {
					System.out.println(count);
					break;
				}
			}
		}
	}
}
