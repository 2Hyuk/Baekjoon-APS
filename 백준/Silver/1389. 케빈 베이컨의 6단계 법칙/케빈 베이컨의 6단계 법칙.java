
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[] result;
	static boolean[] visited;
	static List<Integer>[] list;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		list = new ArrayList[N];
		arr = new int[N][N];
		result = new int[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int st = sc.nextInt() - 1;
			int ed = sc.nextInt() - 1;

			list[st].add(ed);
			list[ed].add(st);
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				q.clear();
				Arrays.fill(visited, false);
				q.offer(i);
				visited[i] = true;
				arr[i][j] = arr[j][i] = bfs(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				result[i] += arr[i][j];
			}
		}
		int min = Integer.MAX_VALUE;
		int minIdx = 0;
		
		for(int i = 0; i < N; i++) {
			if(min > result[i]) {
				min = result[i];
				minIdx = i;
			}
		}
		System.out.println(minIdx + 1);
	}

	static int bfs(int endIdx) {
		int ans = 0;
		loop: while (!q.isEmpty()) {
			int size = 0;
			size = q.size();
			for (int i = 0; i < size; i++) {
				int st = q.poll();
				if (st == endIdx) {
					break loop;
				}
				
				for(int j = 0; j < list[st].size(); j++) {
					int ed = list[st].get(j);
					if(visited[ed]) continue;
					visited[ed] = true;
					q.offer(ed);
				}
			}
			ans++;
		}
		return ans;
	}
}
