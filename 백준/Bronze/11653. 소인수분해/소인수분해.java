
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		boolean[] arr = new boolean[N+1];
		arr[0] = arr[1] = true;
		
		for(int i = 2; i < arr.length; i++) {
			if(arr[i] == true)
				continue;
			for(int j = 2; i * j < arr.length; i++) {
				if(arr[i * j] == false)
					arr[i * j] = true;
			}
		}
		int tmp = N;
		for(int i = 2; i <= N; i++) {
			while(tmp != 0 && arr[i] == false && tmp % i == 0) {
				sb.append(i).append("\n");
				tmp /= i;
			}
			if(tmp == 0)
				break;
		}
		System.out.println(sb);
	}
}
