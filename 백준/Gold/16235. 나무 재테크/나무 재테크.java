
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Tree implements Comparable<Tree> {
		int row, col, age;

		public Tree(int row, int col, int age) {
			this.row = row;
			this.col = col;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}

	}

	static int N;
	static int[][] A;
	static int[][] energy;
	static PriorityQueue<Tree> pq;
	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();
		A = new int[N][N];
		energy = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(energy[i], 5);
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			pq.add(new Tree(x, y, age));
		}

		for (int i = 1; i <= K; i++) {
			springSummer();
			autumn();
			winter();
		}
		
		System.out.println(pq.size());

	}

	static void springSummer() {
		int[][] tmp = new int[N][N];
		PriorityQueue<Tree> tmpQueue = new PriorityQueue<>();
		while (!pq.isEmpty()) {
			Tree tree = pq.poll();
			int row = tree.row;
			int col = tree.col;
			int age = tree.age;

			if (energy[row][col] >= age) {
				energy[row][col] -= age;
				tmpQueue.add(new Tree(row, col, age + 1));
			} else {
				tmp[row][col] += age / 2;
			}
		}

		pq.addAll(tmpQueue);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				energy[i][j] += tmp[i][j];
			}
		}
	}

//	static void summer() {
//		for(int i = 0; i < treeList.size(); i++) {
//			if(treeList.get(i).isAlive) continue;
//			
//			int row = treeList.get(i).row;
//			int col = treeList.get(i).col;
//			int age = treeList.get(i).age;
//			energy[row][col] += age / 2;
//			//treeList.remove(i);
//			
//		}
//	}

	static void autumn() {
		PriorityQueue<Tree> tmpQueue = new PriorityQueue<>();
		while (!pq.isEmpty()) {
			Tree tree = pq.poll();
			int row = tree.row;
			int col = tree.col;
			int age = tree.age;
			tmpQueue.add(new Tree(row, col, age));

			if (age % 5 == 0) {
				for (int j = 0; j < 8; j++) {
					int nr = row + dr[j];
					int nc = col + dc[j];

					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;

					tmpQueue.add(new Tree(nr, nc, 1));
				}
			}
		}
		pq.addAll(tmpQueue);
	}

	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				energy[i][j] += A[i][j];
			}
		}
	}
}
