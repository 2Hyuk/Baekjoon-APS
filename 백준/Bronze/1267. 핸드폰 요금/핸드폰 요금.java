import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] callArr = new int[N];
		int yPrice = 0;
		int mPrice = 0;
		
		for(int i = 0; i < N; i++) {
			callArr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			yPrice += 10 + (callArr[i] / 30) * 10;
			mPrice += 15 + (callArr[i] / 60) * 15;
		}
		
		if(mPrice == yPrice) {
			System.out.println("Y " + "M " + mPrice);
		}
		else if(mPrice > yPrice) {
			System.out.println("Y " + yPrice);
		}
		else {
			System.out.println("M " + mPrice);
		}
	}
}
