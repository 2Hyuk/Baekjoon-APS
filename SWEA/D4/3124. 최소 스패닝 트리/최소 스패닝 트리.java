import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution {
	static class Node implements Comparable<Node>{
		int st, ed, weight;

		public Node(int st, int ed, int weight) {
			this.st = st;
			this.ed = ed;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
	}
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		// 간선의 정보를 저장할 배열

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); // 정점의개수
			int E = Integer.parseInt(st.nextToken()); // 간선의개수
			List<Node>[] list = new ArrayList[V+1];
			for(int i = 1; i <= V; i++) {
				list[i] = new ArrayList<>();
			} 
			// 간선의 정보를 입력받아 저장
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				list[start].add(new Node(start, end, weight));
				list[end].add(new Node(end, start, weight));
			}
			
			boolean[] visited = new boolean[V+1];
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.addAll(list[1]);
			visited[1] = true;
			int pick = 1;
			long ans = 0;
			while(pick < V) {
				Node node = pq.poll();
				if(visited[node.ed]) continue;
				
				ans += node.weight;
				pq.addAll(list[node.ed]);
				visited[node.ed] = true;
				pick++;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
