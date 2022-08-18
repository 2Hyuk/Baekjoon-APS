
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int testCase = 1; testCase <= 10; testCase++) {
			Queue<Integer> queue = new LinkedList<>();
			br.readLine();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));			
			}
			int cycle = 1;
			while(true) {
				int num = (queue.poll() - cycle);
				if(num <= 0) num = 0;
				queue.offer(num);
				if(num == 0) {
					break;
				}
				cycle = ++cycle > 5 ? 1 : cycle;
			}
			System.out.print("#" + testCase);
			for(int i : queue) {
				System.out.print(" "+ i);
			}
			System.out.println();
		}
	}
}
