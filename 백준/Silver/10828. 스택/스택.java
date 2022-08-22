import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Stack {
		int[] stack = new int[10000];
		int size;
		int top = -1;

		boolean isEmpty() {
			if (size == 0)
				return true;
			return false;
		}

		int size() {
			return size;
		}

		int peek() {
			if(isEmpty()) {
				return -1;
			}
			return stack[top];
		}

		void push(int data) {
			stack[++top] = data;
			size++;
		}

		int pop() {
			if (isEmpty())
				return -1;
			size--;
			return stack[top--];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack stack = new Stack();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			switch (order) {
			case "push":
				int data = Integer.parseInt(st.nextToken());
				stack.push(data);
				break;
			case "pop":
				System.out.println(stack.pop());
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				System.out.println(stack.isEmpty() == true ? 1 : 0);
				break;
			case "top":
				System.out.println(stack.peek());
				break;
			}
		}

	}

}
