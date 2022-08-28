
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class Nge{
		int num;
		int idx;
		Nge(int num, int idx){
			this.num = num;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Nge> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int[] answer = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		//초기값 처음 들어온 값으로 넣어준다.
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && stack.peek().num < num) {
				Nge nge = stack.pop();
				answer[nge.idx] = num;
			}
			
			stack.push(new Nge(num, i));
		}
		
		while(!stack.isEmpty()) {
			answer[stack.pop().idx] = -1;
		}
		
		for(int i : answer) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

	
}
