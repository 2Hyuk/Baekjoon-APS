import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int modNum = 42;
		int[] chArr = new int[modNum];
		int answer = 0;
		for(int i = 1; i <= 10; i++) {
			chArr[sc.nextInt() % modNum]++;
		}
		
		for(int i = 0; i < chArr.length; i++) {
			answer += chArr[i] != 0 ? 1 : 0;
		}
		System.out.println(answer);
	}
}
