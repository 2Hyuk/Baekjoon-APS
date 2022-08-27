
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] alphabet = new int[26];
		
		for(int i = 0; i < alphabet.length; i++) {
			alphabet[i] = -1;
		}
		
		for(int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - 'a';
			if(alphabet[idx] == -1) {
				alphabet[idx] = i;
			}
		}
		for(int i : alphabet) {
			System.out.print(i + " ");
		}
	}
}
