
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	/*
	 * 시작부터 연속으로 5개를 이을수 있는가 없는가?
	 */
	static boolean[] visited;
	static List<Integer>[] list;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		list = new ArrayList[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y);
			list[y].add(x);

		}
		result = 0;
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i, 1);
			visited[i] = false;
			if (result == 1) {
				break;
			}
		}
		System.out.println(result);
	}

	static void dfs(int st, int sIdx) {
		if (sIdx == 5) {
			result = 1;
			return;
		}

		for (int i = 0; i < list[st].size(); i++) {
			int ed = list[st].get(i);
			if (visited[ed])
				continue;
			visited[ed] = true;
			dfs(ed, sIdx + 1);
			visited[ed] = false;
		}
	}

}
