import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] numArr = new int[N];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			numArr[i] = sc.nextInt();
			max = Math.max(max, numArr[i]);
			min = Math.min(min, numArr[i]);
		}
		System.out.println(max * min);
	}
}
