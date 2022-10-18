
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static boolean[] isBasket;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int J = sc.nextInt();
		isBasket = new boolean[N];
		
		for(int i = 0; i < M; i++) {
			isBasket[i] = true;
		}
		int min = 0;
		
		for(int i = 0; i < J; i++) {
			int appleIdx = sc.nextInt() - 1;
			if(isBasket[appleIdx]) continue;
			min += moveBasket(appleIdx);
			
		}
		System.out.println(min);
		
	}
	
	public static int moveBasket(int appleIdx) {
		int movement = 0;
		int left = 0;
		int right = isBasket.length - 1;
		while(!isBasket[left]) {
			left++;
		}
		while(!isBasket[right]) {
			right--;
		}
		int leftToApple = Math.abs(left - appleIdx);
		int rightToApple = Math.abs(right - appleIdx);
		Arrays.fill(isBasket, false);
		if(leftToApple > rightToApple) {
			movement = rightToApple;
			for(int i = 0; i < M; i++) {
				isBasket[appleIdx--] = true;
			}
			
		}
		else {
			movement = leftToApple;
			for(int i = 0; i < M; i++) {
				isBasket[appleIdx++] = true;
			}
		}
		
		return movement;
	}
	
}
