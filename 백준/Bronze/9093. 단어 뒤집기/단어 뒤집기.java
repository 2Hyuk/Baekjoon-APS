
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sbResult = new StringBuilder();
		StringBuilder sbWord = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.countTokens() > 0) {
				sbWord.append(st.nextToken()).reverse().append(" ");
				sbResult.append(sbWord);
				sbWord.setLength(0);
			}
			System.out.println(sbResult);
			sbResult.setLength(0);
		}
		br.close();
	}
}
