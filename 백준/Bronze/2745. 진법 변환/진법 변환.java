
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		int B = sc.nextInt();
		
		int N = 0;
		
		for(int i = ch.length - 1 ,j = 0; i >= 0; i--, j++) {
			if(ch[i] >= '0' && ch[i] <= '9') {
				N += Math.pow(B, j) * (ch[i] - '0');
			}
			else {
				N += Math.pow(B, j) * (ch[i] - 55);
			}
		}
		System.out.println(N);

	}
}
