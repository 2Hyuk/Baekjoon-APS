
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
		int ed, dist;

		public Node(int ed, int dist) {
			super();
			this.ed = ed;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.dist - o.dist;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;
		
		//인접리스트로 인접정점 받아둔다.
		List<Integer>[] list = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			list[start].add(end);
		}
		//최단거리를 갱신할 배열
		int[] dist = new int[N];
		//일단 최대치로 바꿔놓고
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		//처음시작할 부분에 시작
		pq.add(new Node(X, 0));
		//시작하는곳은 0으로 초기화
		dist[X] = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			for(int i = 0; i < list[node.ed].size(); i++) {
				int ed = list[node.ed].get(i);
				if(dist[ed] > dist[node.ed] + 1) {
					dist[ed] = dist[node.ed] + 1;
					pq.offer(new Node(ed, dist[ed]));
				}
			}
		}
		
		for(int i = 0; i < dist.length; i++) {
			if(dist[i] == K) {
				sb.append(i + 1).append("\n");
			}
		}
		
		if(sb.length() > 0) {
			System.out.println(sb);
		}
		else {
			System.out.println(-1);
		}
		
	}

}
