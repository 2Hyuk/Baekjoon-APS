
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	// 스택 내부
	static char[][] isp = { { '(', ' ' }, { '+', '-' }, { '*', '/' } };
	// 스택 외부
	static char[][] icp = { { ' ', ' ' }, { '+', '-' }, { '*', '/' }, { '(', ' ' } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String infix = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < infix.length(); i++) {
			char ch = infix.charAt(i);
			int icp = setICP(ch);

			// 연산자일 때
			if (icp > 0) { 
				// 스택이 비어있지않고, 연산자의 우선순위가 내부가 크거나 같다면 반복
				while(!stack.isEmpty() && setISP(stack.peek()) >= icp) {
					//스택에서 하나 꺼내서 저장하고					
					sb.append(stack.pop()); 
				}
				// 스택에 지금의 연산자를 추가한다.
				stack.push(ch); 
			}
			else if(ch == ')') {
				// 닫는 괄호가 나올 때 까지 반복한다.
				while(stack.peek() != '(') 
				{
					sb.append(stack.pop());
				}
				// 여는 괄호는 삭제
				stack.pop(); 
			}
			else {
				// 피연산자는 바로 넣는다.
				sb.append(ch); 
			}
		}
		 // 스택에 남아있는 것은 전부 넣는다.
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}

	public static int setISP(char ch) {
		for (int i = 0; i < isp.length; i++) {
			for (int j = 0; j < 2; j++) {
				if (isp[i][j] == ch) {
					return i; // 우선순위 리턴(0, 1 ,2)
				}
			}
		}
		return -1; // 못찾으면 -1
	}

	public static int setICP(char ch) {
		for (int i = 1; i < icp.length; i++) {
			for (int j = 0; j < 2; j++) {
				if (icp[i][j] == ch) {
					return i; // 우선순위 리턴(1, 2 ,3)
				}
			}
		}
		return -1; // 못찾으면 -1
	}
}
