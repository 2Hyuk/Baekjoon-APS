
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static class Carrot implements Comparable<Carrot> {
		int w, p;

		public Carrot(int w, int p) {
			super();
			this.w = w;
			this.p = p;
		}

		@Override
		public int compareTo(Carrot o) {
			return o.p - this.p;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		Set<Integer> set = new HashSet<>();
		List<Carrot> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			list.add(new Carrot(w, p));

		}
		long result = 0;
		Collections.sort(list);
		for(int i = T-N; i < T; i++) {
			Carrot carrot = list.get(list.size() - 1);
			result += ( carrot.w + (carrot.p * (long)i));
			list.remove(list.size() - 1);
		}
		System.out.println(result);

	}
}
