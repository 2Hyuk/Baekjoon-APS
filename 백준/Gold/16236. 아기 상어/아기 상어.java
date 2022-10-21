

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import javax.print.attribute.standard.Copies;

public class Main {
	static class Node {
		int row, col, time;

		public Node(int row, int col, int time) {
			super();
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}

	static int N;
	static int[][] map;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		int sharkRow = 0, sharkCol = 0, sharkSize = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					sharkRow = i;
					sharkCol = j;
					map[i][j] = 0;
				}
			}
		}

		int ans = 0;
		int eat = 0;
		while (true) {
			Node node = findTarget(sharkRow, sharkCol, sharkSize);

			if (node == null) {
				break;
			}
			map[node.row][node.col] = 0;

			eat++;
			if (eat == sharkSize) {
				sharkSize++;
				eat = 0;
			}
			ans += node.time;
			sharkRow = node.row;
			sharkCol = node.col;
		}
		System.out.println(ans);

	}

	static Node findTarget(int row, int col, int sharkSize) {
		Queue<Node> q = new LinkedList<>();
		List<Node> list = new ArrayList<>();
		boolean[][] visited = new boolean[N][N];
		visited[row][col] = true;
		q.offer(new Node(row, col, 0));

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node node = q.poll();

				for (int j = 0; j < 4; j++) {
					int nr = node.row + dr[j];
					int nc = node.col + dc[j];

					if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] > sharkSize || visited[nr][nc])
						continue;

					visited[nr][nc] = true;
					if (map[nr][nc] == sharkSize || map[nr][nc] == 0) {
						q.offer(new Node(nr, nc, node.time + 1));
					} else if (map[nr][nc] < sharkSize) {
						list.add(new Node(nr, nc, node.time + 1));
					}
				}
			}
			if (list.size() > 0) {
				Collections.sort(list, new Comparator<Node>() {
					@Override
					public int compare(Node o1, Node o2) {
						if (o1.row == o2.row) {
							return o1.col - o2.col;
						}
						return o1.row - o2.row;
					}
				});

				break;
			}

		}
		
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

}
