import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += sc.nextInt();
			if(Math.abs(100-sum) <= Math.abs(100-answer)) {
				answer = sum;
			}
		}
		System.out.println(answer);

	}
}
