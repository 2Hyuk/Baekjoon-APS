import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int num = sc.nextInt();
			int[] arr = new int[num];
			
			double sum = 0;
			for(int i = 0; i < num; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			int cnt = 0;
			double average = sum / num;
			
			for(int i = 0; i < num; i++) {
				if(arr[i] > average) {
					cnt++;
				}
			}
			double result = ((double)cnt * 100 / num);
			System.out.printf("%.3f", result);
			System.out.println("%");
		}

	}
}
