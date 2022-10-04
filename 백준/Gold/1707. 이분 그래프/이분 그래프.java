
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 시작정점을 1로 두고 인접한것들은 2로바꾼다. 그리고 큐에 2인녀석들 전부 넣는다. 2인녀석들 꺼내면서 인접한 정점을 1로 바꾼다. 이떄
	 * 인접한 녀석들중 0(초기값)이나 1이 아닌 2가 존재한다면? 이분그래프 안됨 마찬가지고 1의 경우에도 인접한 녀석들이 0이나 2가 아닌
	 * 1이 존재한다면? 이분그래프 안됨
	 */
	static int[] p;
	public static void main(String[] args) throws IOException {
		Queue<Integer> q = new LinkedList<>();
		int[] divide;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			q.clear();
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			List<Integer>[] list = new ArrayList[V];
			for (int i = 0; i < V; i++) {
				list[i] = new ArrayList<>();
			}
			p = new int[V];
			for(int i = 0; i < V; i++) {
				p[i] = i;
			}
			// 정점 0부터 시작하도록 바꿀꺼다.
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken()) - 1;
				int end = Integer.parseInt(st.nextToken()) - 1;
				int px = findSet(start);
				int py = findSet(end);
				union(px, py);
				
				list[start].add(end);
				list[end].add(start);
			}
			Set<Integer> set = new HashSet<>();
			for(int i = 0; i < V; i++) {
				findSet(i);
				set.add(p[i]);
			}
			String result = "YES";
			// 처음 i번부터 시작할건데 i번째를 1번으로 바꾸고 시작한다.
			// 간선이 없는 경우도 있으므로 전체 정점에 대해서 돈다. -> 대표만들고 하자
			divide = new int[V];
			
			
				
			
			loop:for(int i : set) {
				q.offer(i);
				divide[i] = 1;
				
				while (!q.isEmpty()) {
					int start = q.poll();

					for (int j = 0; j < list[start].size(); j++) {
						int end = list[start].get(j);
						//인접한 정점끼리 값이 같다? 그럼 이분그래프 못해
						if (divide[start] == divide[end]) {
							result = "NO";
							break;
						}
						// 값이 다른데.. 0이네? 그럼 반대껄로 바꾸고  q에 넣어서 보내
						else if(divide[end] == 0) {
							q.offer(end);
							divide[end] = divide[start] == 1 ? 2 : 1;
						}
					}

					if (result.equals("NO")) {
						break loop;
					}
				}
			}
			System.out.println(result);
		}

	}
	
	static int findSet(int x) {
		if(p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
	
	static void union(int x, int y) {
		p[y] = x;
	}
}
