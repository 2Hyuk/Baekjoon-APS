import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Fireball {
		// fireball row
		private int r;
		// fireball column
		private int c;
		// fireball mass
		private int m;
		// fireball speed
		private int s;
		// fireball direction
		private int d;

		public Fireball(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		public void addM(int m) {
			this.m += m;
		}

		public void addS(int s) {
			this.s += s;
		}

	}

	static Queue<Fireball> fireballs;
	public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		fireballs = new ArrayDeque<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			fireballs.add(new Fireball(r, c, m, s, d));
		}

		// K번 이동
		for (int i = 0; i < K; i++) {
			moveFireball();
		}

		int answer = 0;
		while (!fireballs.isEmpty()) {
			answer += fireballs.poll().m;
		}

		System.out.println(answer);

	}

	public static void moveFireball() {
		Fireball[][] fbArr = new Fireball[N][N];
		int[][] fbCount = new int[N][N];
		double[][] fbDir = new double[N][N];

		while (!fireballs.isEmpty()) {
			Fireball fb = fireballs.poll();
			int[] rc = getRowCol(fb);
			int r = rc[0];
			int c = rc[1];
			int m = fb.m;
			int s = fb.s;
			int d = fb.d;

			if (fbArr[r][c] == null) {
				fbArr[r][c] = new Fireball(r, c, m, s, d);
			} else {
				fbArr[r][c].addM(m);
				fbArr[r][c].addS(s);
			}
			if (d % 2 == 0) {
				fbDir[r][c] += 2;
			} else {
				fbDir[r][c] += 1;
			}
			fbCount[r][c]++;
		}

		setFireballs(fbArr, fbDir, fbCount);
	}

	public static void setFireballs(Fireball[][] fbArr, double[][] fbDir, int[][] fbCount) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (fbCount[r][c] == 1) {
					fireballs.add(fbArr[r][c]);
				} else if (fbCount[r][c] >= 2) {
					int m = fbArr[r][c].m / 5;
					if (m == 0) {
						continue;
					}
					int s = fbArr[r][c].s / fbCount[r][c];

					if (fbDir[r][c] / fbCount[r][c] == 2 || fbDir[r][c] / fbCount[r][c] == 1) {
						fireballs.add(new Fireball(r, c, m, s, 0));
						fireballs.add(new Fireball(r, c, m, s, 2));
						fireballs.add(new Fireball(r, c, m, s, 4));
						fireballs.add(new Fireball(r, c, m, s, 6));
					} else {
						fireballs.add(new Fireball(r, c, m, s, 1));
						fireballs.add(new Fireball(r, c, m, s, 3));
						fireballs.add(new Fireball(r, c, m, s, 5));
						fireballs.add(new Fireball(r, c, m, s, 7));
					}
				}
			}
		}
	}

	public static int[] getRowCol(Fireball fireball) {
		int r = fireball.r;
		int c = fireball.c;
		int s = fireball.s;
		int d = fireball.d;
		r = (N + r + dx[d] * (s % N)) % N;
		c = (N + c + dy[d] * (s % N)) % N;

		return new int[] {r, c};
	}
}
