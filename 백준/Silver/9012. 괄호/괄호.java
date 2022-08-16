import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			Stack<Character> stack = new Stack<>();
			String inputPS = br.readLine();
			for(int i = 0; i < inputPS.length(); i++) {
				if(inputPS.charAt(i) == ')') {
					if(stack.isEmpty()) {
						stack.push(inputPS.charAt(i));
						break;
					}
					stack.pop();
				}
				else{
					stack.push(inputPS.charAt(i));
				}
			}
			System.out.println(stack.isEmpty()? "YES" : "NO");
		}
	}
}
