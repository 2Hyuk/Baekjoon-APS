
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int v, weight;

		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<Node>[] list = new ArrayList[V];
		for(int i = 0; i < V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, weight));
			list[end].add(new Node(start, weight));
		}
		
		//프림
		final int INF = Integer.MAX_VALUE;
		boolean[] visited = new boolean[V];
		int[] dist = new int[V];
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		//0에서부터 시작할거다.
		pq.offer(new Node(0, 0));
		dist[0] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(visited[node.v]) continue;
			
			visited[node.v] = true;
			
			for(Node n : list[node.v]) {
				if(!visited[n.v] && dist[n.v] > n.weight) {
					dist[n.v] = n.weight;
					pq.offer(new Node(n.v, dist[n.v]));
				}
			}
		}
		long ans = 0;
		for(int i : dist) {
			ans += i;
		}
		System.out.println(ans);
	}
}
