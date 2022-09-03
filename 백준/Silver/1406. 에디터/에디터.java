
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<String> leftStack = new Stack<>();
		Stack<String> rightStack = new Stack<>();
		
		String initStr = br.readLine();
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < initStr.length(); i++) {
			leftStack.push(""+initStr.charAt(i));
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			switch(order) {
				case "L":
					if(!leftStack.isEmpty())
						rightStack.push(leftStack.pop());
					break;
				case "D":
					if(!rightStack.isEmpty())
						leftStack.push(rightStack.pop());
					break;
				case "B":
					if(!leftStack.isEmpty())
						leftStack.pop();
					break;
				case "P":
					leftStack.push(st.nextToken());
					break;
				default:
					break;
			}
		}
		while(!leftStack.isEmpty()) {
			rightStack.push(leftStack.pop());
		}
		
		while(!rightStack.isEmpty()) {
			sb.append(rightStack.pop());
		}
		
		System.out.println(sb);
	}
}
