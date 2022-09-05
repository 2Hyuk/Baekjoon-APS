
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class NGF{
		int num;
		int idx;
		
		public NGF(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] count = new int[1000001];
		int[] input = new int[N];
		int[] result = new int[N];
		Arrays.fill(result, -1);
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			input[i] = num;
			count[num]++;
		}
		
		Stack<NGF> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			int num = input[i];
			int cycle = 0;
			while(!stack.isEmpty() && count[stack.peek().num] < count[num]) {
				result[stack.pop().idx] = num;
			}
			stack.push(new NGF(num, i));
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i : result) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}
}
