import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			String PS = br.readLine();
			boolean isVPS = true;
			stack.clear();
			
			for(int j = 0; j < PS.length(); j++) {
				char ch = PS.charAt(j);
				if(ch == '(') {
					stack.push(ch);
				}
				else {
					if(stack.isEmpty()) {
						isVPS = false;
						break;
					}
					stack.pop();
				}
			}
			if(!stack.isEmpty()) {
				isVPS = false;
			}
			
			sb.append(isVPS == true ? "YES" : "NO").append("\n");
		}
		System.out.println(sb);
	}
}
