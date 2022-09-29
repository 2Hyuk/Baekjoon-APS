
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
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine()) - 1;
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
		}
		
		final int INF = Integer.MAX_VALUE;
		// 다익스트라
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		int[] dist = new int[V];
		Arrays.fill(dist, INF);
		//시작점은  K;
		pq.offer(new Node(K, 0));
		dist[K] = 0;
		
		boolean[] visited = new boolean[V];
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(visited[node.v]) continue;
			
			visited[node.v] = true;
				
			for(Node n : list[node.v]) {
				if(!visited[n.v] && dist[n.v] > dist[node.v] + n.weight) {
					dist[n.v] = dist[node.v] + n.weight;
					pq.offer(new Node(n.v, dist[n.v]));
				}
			}
		}
		
		for(int i : dist) {
				if(i == INF) {
					sb.append("INF").append("\n");
				}
				else {
					sb.append(i).append("\n");
				}
		}
		System.out.println(sb);
		
	}
}
