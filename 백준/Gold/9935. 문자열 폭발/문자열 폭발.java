
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String boom = br.readLine();
		
		int idx = 0;
		char[] result = new char[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			result[idx] = str.charAt(i);
			
			if(isBoom(result, idx, boom)) {
				idx -= boom.length();
			}
			idx++;
		}
		String ans = String.valueOf(result, 0, idx);
		ans = ans.length() == 0 ? "FRULA" : ans;
		System.out.println(ans);
	}
	
	public static boolean isBoom(char[] result, int idx, String boom) {
		if(boom.length() - 1 > idx) return false;
		
		for(int i = 0; i < boom.length(); i++) {
			if(boom.charAt(i) != result[idx - boom.length() + 1 + i]) {
				return false;
			}
		}
		return true;
	}
}
