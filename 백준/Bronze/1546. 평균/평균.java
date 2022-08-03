import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double max = 0;
		int[] pointArr = new int[N];
		
		//배열에 값 점수 넣어주고 최대점수 구한다.
		for(int i = 0; i < N; i++) {
			pointArr[i] = sc.nextInt();
			max = Math.max(max, pointArr[i]);
		}
		
		double sum = 0;
		for(int i = 0; i < N; i++) {
			sum += (pointArr[i] / max) * 100; 
		}
		System.out.println(sum / N);
	}
}
