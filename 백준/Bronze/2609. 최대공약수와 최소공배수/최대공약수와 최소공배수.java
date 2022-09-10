
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 유클리드 호제법 사용한다.
		// 두 수 a, b(a >= b)에 대해서 a % b = r일 때 a와 b의 최대공약수는 b 와 r의 최대공약수와같다.
		// 최종적으로 r = 0이 되는 구간에서 a와 b의 최대 공약수가 구해진다.
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a < b) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		// 최대공약수
		System.out.println(gdc(a, b));
		System.out.println(lcm(a, b));
	}
	
	static int gdc(int a, int b){
		while(true) {
			int r = a % b;
			if(r == 0)
				break;
			a = b;
			b = r;
		}
		return b;
	}
	
	static int lcm(int a, int b) {
		return a * b / gdc(a, b);
	}
}
