import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int groupWord = 0;
		for(int i = 0; i < N; i++) {
			if(checkGroup(br.readLine())) {
				groupWord++;
			}
		}
		System.out.println(groupWord);
		
	}
	
	public static boolean checkGroup(String word) {
		String[] wordArr = word.split("");
		Set<String> set = new HashSet<>();
		set.add(wordArr[0]);
		for(int i = 1; i < word.length(); i++) {
			if(wordArr[i].equals(wordArr[i - 1])) {
				continue;
			}
			else {
				if(!(set.add(wordArr[i]))) {
					return false;
				}
			}
		}
 		return true;
	}
}
