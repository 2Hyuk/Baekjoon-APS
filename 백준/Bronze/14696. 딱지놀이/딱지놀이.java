import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int round = sc.nextInt();
		for(int r = 1; r <= round; r++) {
			int[] aArr = new int[5];
			int[] bArr = new int[5];
			
			int a = sc.nextInt();
			for(int i = 0; i < a; i++) {
				aArr[sc.nextInt()]++;
			}
			int b = sc.nextInt();
			for(int i = 0; i < b; i++) {
				bArr[sc.nextInt()]++;
			}
			String winner = "D";
			for(int i = 4; i > 0; i--) {
				if(aArr[i] == bArr[i]) continue;
				winner = aArr[i] > bArr[i] ? "A" : "B";
				break;
			}
			
			System.out.println(winner);
		}

	}
}
