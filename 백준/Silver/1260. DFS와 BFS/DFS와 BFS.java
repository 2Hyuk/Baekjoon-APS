
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node> {
		int ed;

		public Node(int ed) {
			super();
			this.ed = ed;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.ed - o.ed;
		}

	}

	static List<Node>[] list;
	static int N, M, V;
	static StringBuilder sb;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			list[st].add(new Node(ed));
			list[ed].add(new Node(st));
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
		
		visited = new boolean[N + 1];
		visited[V] = true;
		sb.append(V).append(" ");
		dfs(V);
		sb.append("\n");
		
		visited = new boolean[N + 1];
		visited[V] = true;
		sb.append(V).append(" ");
		bfs(V);
		

		System.out.println(sb);
	}

	static void dfs(int idx) {
		for (int i = 0; i < list[idx].size(); i++) {
			int ed = list[idx].get(i).ed;
			if (!visited[ed]) {
				visited[ed] = true;
				sb.append(ed).append(" ");
				dfs(ed);
			}

		}

	}

	static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(idx);
		
		while(!q.isEmpty()) {
			int st = q.poll();
			
			for(int i = 0; i < list[st].size(); i++) {
				int ed = list[st].get(i).ed;
				if(!visited[ed]) {
					visited[ed] = true;
					sb.append(ed).append(" ");
					q.offer(ed);
				}
			}
		}
	}

}
