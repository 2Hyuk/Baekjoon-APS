import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static int K;
	static int minAns;
	static int maxAns;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println((selectionSort() == true) ? (minAns + " " + maxAns) : -1);
	}
	
	static boolean selectionSort() {
		int cnt = 0;
		for(int i = arr.length-1; i > 0; i--) {
			int max = arr[i];
			int idx = i;
			for(int j = i-1; j >= 0; j--) {
				if(max < arr[j]) {
					max = arr[j];
					idx = j;
				}
			}
			if(idx != i) {
				int tmp = arr[idx];
				arr[idx] = arr[i];
				arr[i] = tmp;
				cnt++;
				if(cnt == K) {
					minAns = arr[idx];
					maxAns = tmp;
					return true;
				}
			}
		}
		return false;
	}
}
