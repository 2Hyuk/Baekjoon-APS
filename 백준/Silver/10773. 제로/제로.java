
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static class Stack{
		int[] stack;
		int top;
		int size;
		
		Stack(int n){
			stack = new int[n];
			this.size = 0;
			this.top = -1;
		}
		
		boolean isEmpty() {
			return size == 0;
		}
		
		boolean push(int data) {
			if(stack.length == size)
				return false;
			
			stack[++top] = data;
			size++;
			return true;
		}
		
		int pop() {
			if(isEmpty())
				return -1;
			
			size--;
			return stack[top--];
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack stack = new Stack(K);
		for(int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				stack.pop();
			}
			else {
				stack.push(num);
			}
		}
		int sum = 0;
		
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
}
