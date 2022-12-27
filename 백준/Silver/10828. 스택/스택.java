import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static class Stack{
		private int[] stack;
		private int top;
		
		public Stack(int N) {
			this.stack = new int[N];
			top = 0;
		}
		
		public int size() {
			return this.top;
		}
		
		public int empty() {
			if(this.size() > 0)
				return 0;
			return 1;
		}
		
		public void push(int X) {
			this.stack[top++] = X;
		}
		
		public int top() {
			if(this.size() > 0)
				return this.stack[this.top - 1];
			return -1;
		}
		
		public int pop() {
			if(this.size() > 0)
				return this.stack[--this.top];
			return -1;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack stack = new Stack(N);
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			switch(order) {
			case "push":
				int X = Integer.parseInt(st.nextToken());
				stack.push(X);
				break;
			case "top":
				sb.append(stack.top()).append("\n");
				break;
			case "pop":
				sb.append(stack.pop()).append("\n");
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				sb.append(stack.empty()).append("\n");
				break;
			}
		}
		System.out.println(sb);
		
	}
}
