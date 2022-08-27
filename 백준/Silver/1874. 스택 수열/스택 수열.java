
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int input = 0;
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			// stack이 비었으면 num값 하나 넣어라.
			if (stack.isEmpty() && input <= n) {
				stack.push(++input);
				sb.append("+").append("\n");
			}

			// stack의 피크값과 num값이 같다면 그냥 빼라.
			if (!stack.isEmpty() && stack.peek() == num) {
				if(!stack.isEmpty())
					stack.pop();
				sb.append("-").append("\n");
			}
			// stack의 피크값이 num보다 작다면, num까지 넣어라.
			else if (!stack.isEmpty() && stack.peek() < num) {
				while (input <= n && input != num) {
					stack.push(++input);
					sb.append("+").append("\n");
				}
				if(!stack.isEmpty())
					stack.pop();
				sb.append("-").append("\n");
			}
			// stack의 피크값이 num보다 크다면, num이 나올때 까지 뺴라.
			else if (!stack.isEmpty() && stack.peek() > num) {
				while (!stack.isEmpty()) {
					sb.append("-" + "\n").append("\n");
					if (stack.pop() == num) {
						break;
					}
				}
			}
		}
		System.out.println(sb.length() / 4 == n ? sb : "NO");
	}
}
