import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int M = sc.nextInt();
		
		int tired = 0;
		int work = 0;
		int hour = 0;
		do {
			if(A > M) break;
			if(A + tired <= M) {
				// 일한다.
				tired += A;
				work += B;
			}
			else {
				// 쉰다.
				tired = (tired - C < 0) ? 0 : tired - C;
			}
			hour++;
			
		}while(hour != 24);
		
		System.out.println(work);
	}
	
	
}
