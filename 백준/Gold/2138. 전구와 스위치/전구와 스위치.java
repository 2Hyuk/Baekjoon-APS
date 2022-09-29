
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	/*
	 * 
	 */
	static String[] input;
	static String[] result;
	static String[] tmp;
	static boolean[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		input = br.readLine().split("");
		result = br.readLine().split("");
		int ans1 = 0;
		int ans2 = 0;
		
		//첫번째꺼 안누름
		tmp = input.clone();
		for (int i = 0; i < tmp.length - 1; i++) {
			if (!tmp[i].equals(result[i])) {
				clickSwitch(i + 1);
				ans1++;
			}
		}
		if(!equal()) {
			ans1 = Integer.MAX_VALUE;
		}
		
		//첫번째꺼 누름
		tmp = input.clone();
		clickSwitch(0);
		ans2++;
		for (int i = 0; i < tmp.length - 1; i++) {
			if (!tmp[i].equals(result[i])) {
				clickSwitch(i + 1);
				ans2++;
			}
		}
		if(!equal()) {
			ans2 = Integer.MAX_VALUE;
		}
		
		int result = Math.min(ans1, ans2);
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
		
	}

	static void clickSwitch(int i) {
		if (i >= tmp.length || i < 0)
			return;
		int[] arr = { i - 1, i, i + 1 };
		for (int j = 0; j < 3; j++) {
			int idx = arr[j];
			if (idx >= 0 && idx < tmp.length) {
				tmp[idx] = tmp[idx].equals("1") ? "0" : "1";
			}
		}
	}

	static boolean equal() {
		String str1 = String.join("", tmp.clone());
		String str2 = String.join("", result.clone());
		if(str1.equals(str2))
			return true;
//		for (int i = 0; i < input.length; i++) {
//			if (!input[i].equals(result[i])) {
//				return false;
//			}
//		}
		return false;
	}

}
