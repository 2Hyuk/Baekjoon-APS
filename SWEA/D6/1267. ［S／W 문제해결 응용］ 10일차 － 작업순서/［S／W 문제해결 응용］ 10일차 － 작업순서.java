
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++) {
			sb.append("#"+ tc + " ");
			int V = sc.nextInt();
			int E = sc.nextInt();
			// 정점의 번호는 -1해서 계산하고 출력할 떄 +1할거다.
			List<Integer>[] list = new ArrayList[V];
			int[] arr = new int[V]; //진입차수 배열
			for(int i = 0; i < V; i++) {
				list[i] = new ArrayList<>();
			}
			//인접행렬과 진입차수를 구한다.
			for(int i = 0; i < E; i++) {
				int st = sc.nextInt() - 1;
				int ed = sc.nextInt() - 1;
				list[st].add(ed);
				arr[ed]++;
			}
			//진입차수가 0인것들은 모두 큐에 넣는다.
			Queue<Integer> q = new LinkedList<>();
			for(int i = 0; i < V; i++) {
				if(arr[i] == 0) {
					q.add(i);
				}
			}
			
			while(!q.isEmpty()) {
				//큐에서 시작 노드를 하나 꺼내고 꺼낸 노드와 인접한 노드들을 찾아서 모두 진입차수를 하나씩 깐다.
				//그 후 진입차수가 0이라면? -> 큐에 넣는다.
				int st = q.poll();
				sb.append(st + 1 + " ");
				
				for(int i = 0; i < list[st].size(); i++) {
					int ed = list[st].get(i);
					if(--arr[ed] == 0) {
						q.offer(ed);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
