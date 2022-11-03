import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 첫번째 줄 N:사람의 수, M:파티의 수
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = M;
		// 파티 정보 리스트
		List<Integer>[] partyInfo = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			partyInfo[i] = new ArrayList<>();
		}

		p = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			p[i] = i;
		}

		// 진실을 아는사람의 수 K
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(st.nextToken());
			stack.push(num);
		}
		
		// 파티정보, 첫번째사람을 대표로 묶는다.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken()); // cnt명
			int x = Integer.parseInt(st.nextToken());
			partyInfo[i].add(x);
			for (int j = 1; j < cnt; j++) {
				int num = Integer.parseInt(st.nextToken());
				union(findSet(x), findSet(num));
				partyInfo[i].add(num);
			}
		}
		// 진실을 아는 사람들은 0을 대표로 만든다.
		while (!stack.isEmpty()) {
			int py = findSet(stack.pop());
			union(0, py);
		}

		// 갱신한다.
		for (int i = 1; i <= N; i++) {
			findSet(i);
		}
		
		//파티수를 찾는다.
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < partyInfo[i].size(); j++) {
				if(findSet(partyInfo[i].get(j)) == 0) {
					ans--;
					break;
				}
			}
		}
		System.out.println(ans);

	}

	static int findSet(int x) {
		if (p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

	static void union(int x, int y) {
		p[y] = x;
	}
}
