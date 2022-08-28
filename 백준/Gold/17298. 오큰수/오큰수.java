
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class Nge{
		//들어온 숫자와 인덱스
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
		
		// 값을 입력받으면서 오큰수를 찾는다.
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			//스택이 비어있지 않고, 피크가 새로 들어온 넘버보다 작다면?
			while(!stack.isEmpty() && stack.peek().num < num) {
				//스택의 마지막 값을 꺼내고 그 값의 인덱스로 하는 배열에 num을 입력
				Nge nge = stack.pop();
				answer[nge.idx] = num;
			}
			//스택에 값이 비어있다면 추가하고, 새로 들어온 값도 추가한다.
			stack.push(new Nge(num, i));
		}
		
		//남은값들은 오큰수가 없는 숫자들
		while(!stack.isEmpty()) {
			answer[stack.pop().idx] = -1;
		}
		
		for(int i : answer) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

	
}
