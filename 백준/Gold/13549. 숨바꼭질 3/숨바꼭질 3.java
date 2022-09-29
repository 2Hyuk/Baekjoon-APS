
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Move implements Comparable<Move>{
		int x, time;

		public Move(int x, int time) {
			this.x = x;
			this.time = time;
		}

		@Override
		public int compareTo(Move o) {
			return this.time - o.time;
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		//boolean[] visited = new boolean[100001];
		int[] dist = new int[100001];
		
		final int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);
		
		PriorityQueue<Move> pq = new PriorityQueue<>();
		dist[N] = 0;
		pq.offer(new Move(N, dist[N]));
		
		boolean[] visited = new boolean[100001];
		
		while(!pq.isEmpty()) {
			Move m = pq.poll();
			
			if(m.x == K) {
				System.out.println(m.time);
				break;
			}
			
			if(visited[m.x]) continue;
			
			visited[m.x] = true;
			
			int[] movePoint = movePoint(m.x);
			for(int i = 0; i < 3; i++) {
				int x = movePoint[i];
				if(x < 0 || x > 100000) continue;
				if(i == 2) {
					if(!visited[x] && dist[x] > dist[m.x]) {
						dist[x] = dist[m.x];
						pq.offer(new Move(x, dist[x]));
					}
				}
				else {
					if(!visited[x] && dist[x] > dist[m.x] + 1) {
						dist[x] = dist[m.x] + 1;
						pq.offer(new Move(x, dist[x]));
					}
				}
			}
		}

	}
	
	static int[] movePoint(int x) {
		return new int[] {x-1, x+1, 2*x};
	}
}
















