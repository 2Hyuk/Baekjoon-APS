
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Main {
	static class Node implements Comparable<Node>{
		int n, w;

		public Node(int n, int w) {
			super();
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
		
		
	}
	static int N;
	static List<Node>[] list;
	public static void main(String[] args) throws IOException {
		/*
		 * 1에서 최단거리로 v1 -> v2 -> N 가는경우
		 * 1에서 최단거리로 v2 -> v1 -> N 가는 경우
		 * 
		 * 1 -> v1
		 * 1 -> v2
		 * v1 ->v2
		 * v1 -> N
		 * v2 -> N
		 * 이걸 구하면 된다.
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			list[start].add(new Node(end, weight));
			list[end].add(new Node(start, weight));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken()) - 1;
		int v2 = Integer.parseInt(st.nextToken()) - 1;
		
		int[] dist = dijkstra(0);
		//1 - v1 - v2 - N
		long path1 = dist[v1];
		//1 - v2 - v1 - N
		long path2 = dist[v2];
		
		dist = dijkstra(v1);
		path1 += dist[v2];
		path2 += dist[N - 1];
		
		dist = dijkstra(v2);
		path1 += dist[N - 1];
		path2 += dist[v1];
		
		long min = Math.min(path1, path2);
		
		if(min >= 1234567891) {
			min = -1;
		}
		System.out.println(min);
	}
	
	static int[] dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		int[] dist = new int[N];
		boolean[] visited = new boolean[N];
		
		Arrays.fill(dist, 1234567891);
		dist[start] = 0;
		q.offer(new Node(start, 0));
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			
			if(visited[node.n]) continue;
			visited[node.n] = true;

			for (int i = 0; i < list[node.n].size(); i++) {
				int ed = list[node.n].get(i).n;
				int weight = list[node.n].get(i).w;

				if(dist[ed] > dist[node.n] + weight) {
					dist[ed] = dist[node.n] + weight;
					q.offer(new Node(ed, dist[node.n] + weight));
				}
			}

		}
		return dist;
	}
}
