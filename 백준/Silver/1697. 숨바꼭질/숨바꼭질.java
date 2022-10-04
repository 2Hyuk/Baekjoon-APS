
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node {
		int x;
		int time;

		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}

	static int N;
	static int K;
	static int answer;
	static Queue<Node> queue = new LinkedList<>();
	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		// 같은 지점에 있을 떄 0이 출력되야되므로 초기값으로 -1을 주었다.
		answer = -1;
		// 시작점을 체크하고 시작한다.
		visited[N] = true;
		bfs(N, 0);
		System.out.println(answer);
	}

	static void bfs(int point, int time) {
		queue.offer(new Node(point, 0));
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			// 정답을 찾았으니 종료
			if (answer != -1)
				return;

			// K에 도착했으니 종료
			if (answer == -1 && node.x == K) {
				answer = node.time;
				return;
			}

			// 이동할 좌표를 배열로 받아온다.
			int[] nextPoints = setPoint(node.x);
			for (int i = 0; i < 3; i++) {
				int nextPoint = nextPoints[i];
				// 이동할 좌표가 0~100000 사이에 있고 방문한 적이 없다면 갈 수 있다.
				if (nextPoint >= 0 && nextPoint <= 100000 && visited[nextPoint] == false) {
					visited[nextPoint] = true;
					queue.offer(new Node(nextPoint, node.time + 1));
				}
			}
		}

	}

	static int[] setPoint(int point) {
		return new int[] { point + 1, point - 1, point * 2 };
	}
}
