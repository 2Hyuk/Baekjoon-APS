import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int lastIdx = 1;
		int path = 1;
		loop:for(int i = 1; N > 1; i++) {
			lastIdx += 6 * i;
			int firstIdx = lastIdx - (6*i - 1);
			for(int j = firstIdx; j <= lastIdx; j++) {
				if(N == j) {
					path += i;
					break loop;
				}
			}
		}
		System.out.println(path);
	}
}
