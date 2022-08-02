import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int ABC = A * B * C;
		
		while(ABC > 0) {
			arr[ABC % 10]++;
			ABC /= 10;
		}
		
		for(int i : arr) {
			System.out.println(i);
		}
	}
}
