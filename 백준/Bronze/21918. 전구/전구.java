import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			changeState(a, b, c);
		}
		for(int i : arr) {
			System.out.print(i + " ");
		}

	}
	
	public static void changeState(int a, int b, int c) {
		switch(a) {
		case 1:
			arr[b-1] = c;
			break;
		case 2:
			for(int i = b - 1; i < c; i++) {
				arr[i] = (arr[i] == 0 ? 1 : 0);
			}
			break;
		case 3:
			for(int i = b - 1; i < c; i++) {
				arr[i] = 0;
			}
			break;
		case 4:
			for(int i = b - 1; i < c; i++) {
				arr[i] = 1;
			}
			break;
		}
	}
}
