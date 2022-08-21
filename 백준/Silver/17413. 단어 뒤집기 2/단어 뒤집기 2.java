import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder tmp = new StringBuilder();
		String inputStr = br.readLine();
		boolean isTag = false;
		for(int i = 0; i < inputStr.length(); i++) {
			char ch = inputStr.charAt(i);
			if(ch == '<') {
				if(tmp.length() != 0) {
					sb.append(tmp.reverse());
					tmp.setLength(0);
				}
				sb.append(ch);
				isTag = true;
			}
			else if(ch == '>') {
				sb.append(ch);
				isTag = false;
			}
			else if(isTag) {
				sb.append(ch);
			}
			else if(ch == ' ') {
				sb.append(tmp.reverse()).append(ch);
				tmp.setLength(0);
			}
			else {
				tmp.append(ch);
			}
		}
		if(tmp.length() != 0) {
			sb.append(tmp.reverse());
		}
		System.out.println(sb);
	}
}
