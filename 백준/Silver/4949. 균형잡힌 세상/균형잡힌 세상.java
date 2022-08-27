
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		do {
			Stack<Character> stack = new Stack<>();
			boolean isEqual = true;
			for(int i = 0; i < line.length(); i++) {
				char ch = line.charAt(i);
				if(ch == '(' || ch == '[') {
					stack.push(ch);
				}
				else if(ch == ')') {
					if(stack.isEmpty()) {
						isEqual = false;
						break;
					}
					else if(stack.pop() != '(') {
						isEqual = false;
						break;
					}
				}
				else if(ch == ']') {
					if(stack.isEmpty()) {
						isEqual = false;
						break;
					}
					else if(stack.pop() != '[') {
						isEqual = false;
						break;
					}
				}
			}
			if(stack.size() != 0)
				isEqual = false;
			
			System.out.println(isEqual == true ? "yes" : "no");
			line = br.readLine();
		}while(!line.equals("."));
			
		
		
	}
}
