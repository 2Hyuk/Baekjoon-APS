
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String postfix = br.readLine();
		Stack<Double> stack = new Stack<>();
		Map<Character, Double> map = new HashMap<>();
		for(int i = 0; i < postfix.length(); i++) {
			char ch = postfix.charAt(i);
			if(ch >= 'A' && ch <= 'Z') {
				if(!map.containsKey(ch)) {
					map.put(ch, Double.parseDouble(br.readLine()));
				}
				stack.push(map.get(ch));
			}
			else {
				double result = 0;
				double Y = stack.pop();
				double X = stack.pop();
				
				switch(ch) {
					case '+':
						result = X + Y;
						break;
					case '-':
						result = X - Y;
						break;
					case '/':
						result = X / Y;
						break;
					case '*':
						result = X * Y;
						break;
						
				}
				stack.push(result);
			}
		}
		System.out.printf("%.2f", stack.pop());
	}
}
