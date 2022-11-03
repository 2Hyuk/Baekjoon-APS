
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Tree implements Comparable<Tree>{
		int height;

		public Tree(int height) {
			super();
			this.height = height;
		}

		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			return o.height - this.height;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		//정렬 > 가장 큰 값 중앙으로하고 그다음 2개의 값을 양옆에 계속 쌓아 나가는 식으로 한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		PriorityQueue<Tree> pq = new PriorityQueue<>();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				pq.offer(new Tree(Integer.parseInt(st.nextToken())));
			}
			int left = N / 2;
			int right = N / 2;
			arr[left] = pq.poll().height;
			int max = 0;
			while(pq.size() >= 2) {
				int leftNum = pq.poll().height;
				int rightNum = pq.poll().height;
				max = Math.max(max, Math.max(arr[left] - leftNum, arr[right] - rightNum));
				arr[--left] = leftNum;
				arr[++right] = rightNum;
				
			}
			if(!pq.isEmpty()) {
				int leftNum = pq.poll().height;
				max = Math.max(max, Math.max(arr[left] - leftNum, Math.abs(arr[right] - leftNum)));
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}


















