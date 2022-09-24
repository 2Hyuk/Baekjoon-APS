
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int K;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] visited = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		visited[N] = 1;
		queue.offer(new int[] { N, 1 });
		while (!queue.isEmpty()) {
			int[] loc = queue.poll();
			bfs(loc[0], loc[1]);
		}

		System.out.println(visited[K] - 1);
	}

	static void bfs(int point, int time) {

		int[] nextPoints = setPoint(point);
		for (int i = 0; i < 3; i++) {
			int nextPoint = nextPoints[i];
			if (nextPoint >= 0 && nextPoint <= 100000) {
				if (i == 2) {
					if (visited[nextPoint] == 0 || visited[nextPoint] > time) {
						visited[nextPoint] = time;
						queue.offer(new int[] { nextPoint, time });
					}
				} 
				else {
					if (visited[nextPoint] == 0 || visited[nextPoint] > time + 1) {
						visited[nextPoint] = time + 1;
						queue.offer(new int[] { nextPoint, time + 1 });

					}
				}

			}
		}
	}

	static int[] setPoint(int point) {
		return new int[] { point + 1, point - 1, point * 2 };
	}
}
