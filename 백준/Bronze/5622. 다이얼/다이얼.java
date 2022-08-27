
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//시간초는 idx + 3;
		char[][] alpha = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}, {'J', 'K', 'L'}, {'M', 'N', 'O'}, {'P', 'Q', 'R', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y', 'Z'}};
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int time = 0;
		for(int i = 0; i < str.length(); i++) {
			loop:for(int j = 0; j < alpha.length; j++) {
				for(int k = 0; k < alpha[j].length; k++) {
					if(alpha[j][k] == str.charAt(i)) {
						time += j + 3;
						break loop;
					}
						
				}
			}
		}
		System.out.println(time);
	}
}
