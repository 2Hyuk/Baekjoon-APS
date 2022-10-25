import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] ladder = new int[100];
		int[] snake = new int[100];

		for (int i = 0; i < N; i++) {
			ladder[sc.nextInt()] = sc.nextInt();
		}

		for (int j = 0; j < M; j++) {
			snake[sc.nextInt()] = sc.nextInt();
		}

		Queue<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[100];

		q.offer(new int[] {1, 0});

		loop: while (!q.isEmpty()) {
			int[] node = q.poll();
			int start = node[0];
			int cnt = node[1];

			for (int i = 1; i <= 6; i++) {
				int st = start + i;
				if (st > 100)
					continue;
				
				if(st == 100) {
					System.out.println(cnt + 1);
					break loop;
				}

				// 사다리로 갈떄
				if (ladder[st] != 0) {
					if (!visited[ladder[st]]) {
						visited[ladder[st]] = true;
						q.offer(new int[] {ladder[st], cnt + 1});
					}
				}
				// 뱀으로갈떄
				else if (snake[st] != 0) {
					if (!visited[snake[st]]) {
						visited[snake[st]] = true;
						q.offer(new int[] {snake[st], cnt + 1});
					}
				}
				// 그냥 주사위 돌려서 갈때
				else {
					if(!visited[st]) {
						visited[st] = true;
						q.offer(new int[] {st, cnt + 1});
					}
				}
			}
		}

	}
}
