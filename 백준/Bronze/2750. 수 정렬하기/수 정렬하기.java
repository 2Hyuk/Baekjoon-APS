import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N - 1; i++) {
			int minValue = arr[i];
			int minIdx = i;
			for(int j = i + 1; j < N; j++) {
				if(minValue > arr[j]) {
					minValue = arr[j];
					minIdx = j;
				}
			}
			if(minIdx != i) {
				int tmp = arr[minIdx];
				arr[minIdx] = arr[i];
				arr[i] = tmp;
			}
		}
		
		for(int i : arr) {
			System.out.println(i);
		}
	}
}
