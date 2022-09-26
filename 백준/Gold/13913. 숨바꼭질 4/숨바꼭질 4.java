
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static class Location{
		int x;
		int time;
		public Location(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int minTime = Integer.MAX_VALUE;
		boolean[] visited = new boolean[100001];
		int[] path = new int[100001];
		Queue<Location> queue = new LinkedList<>();
		
		visited[N] = true;
		queue.offer(new Location(N, 0)); 
		
		loop:while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				Location loc = queue.poll();
				int time = loc.time;
				int[] xPoints = setX(loc.x);
				
				if(loc.x == K) {
					minTime = time;
					break loop;
				}
				
				for(int j = 0; j < 3; j++) {
					int x = xPoints[j];
					if(x >= 0 && x <= 100000 && visited[x] == false) {
						path[x] = loc.x;
						visited[x] = true;
						queue.offer(new Location(x, time + 1));
					}
				}
				
			}
		}
		
		Stack<Integer> stack = new Stack<>();
		int idx = K;
		while(idx != N) {
			stack.push(idx);
			idx = path[idx];
		}
		stack.push(idx);
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(minTime);
		System.out.println(sb);
	}
	
	public static int[] setX(int x) {
		return new int[] {x + 1, x - 1, 2 * x};
	}
}
