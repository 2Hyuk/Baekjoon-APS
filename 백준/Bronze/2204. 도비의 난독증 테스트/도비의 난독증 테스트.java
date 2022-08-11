import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int testCase = Integer.parseInt(br.readLine());
			if(testCase == 0) break;
			
			String[] wordArr = new String[testCase];
			for(int i = 0; i < testCase; i++) {
				wordArr[i] = br.readLine();
			}
			System.out.println(wordArr[sortWord(wordArr)]);
		}
	}
	
	public static int sortWord(String[] wordArr) {
		int idx = 0;
		String firstWord = wordArr[0];
		for(int i = 1; i < wordArr.length; i++) {
			int n = Math.min(firstWord.length(), wordArr[i].length());
			for(int j = 0; j < n; j++) {
				if(firstWord.toLowerCase().charAt(j) > wordArr[i].toLowerCase().charAt(j)) {
					idx = i;
					firstWord = wordArr[i];
				}
				else if(firstWord.toLowerCase().charAt(j) == wordArr[i].toLowerCase().charAt(j)) {
					if(j == n - 1 && firstWord.length() > wordArr[i].length()) {
						idx = i;
						firstWord = wordArr[i];
					}
					continue;
				}
				break;
			}
		}
		return idx;
	}
}
