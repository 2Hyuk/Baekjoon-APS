
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[26];
		
		String word = sc.next().toUpperCase();
		int maxIdx = 0;
		int maxValue = 0;
		for(int i = 0; i < word.length(); i++) {
			int idx = word.charAt(i) - 'A';
			arr[idx]++;
			
			if(maxValue < arr[idx]) {
				maxValue = arr[idx];
				maxIdx = idx;
			}
		}
		boolean flag = false;
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == maxValue) {
				cnt++;
				if(cnt == 2) {
					flag = true;
					break;
				}
			}
		}
		
		System.out.println(flag == true ? "?" : (char)(maxIdx + 'A'));

	}
}
