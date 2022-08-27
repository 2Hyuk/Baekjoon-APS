
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static class PressX {
		int x;
		int idx;

		PressX(int x, int idx) {
			this.x = x;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<PressX> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] pressArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int idx = i;
			int num = Integer.parseInt(st.nextToken());
			list.add(new PressX(num, idx));
			set.add(num);
		}
		//리스트를 오름차순으로 정렬한다.
		Collections.sort(list, new Comparator<PressX>() {
			@Override
			public int compare(PressX o1, PressX o2) {
				return o1.x - o2.x;
			}
		});
		//리스트의 끝에서 부터 숫자가 작은 것들의 개수를 찾는다.
		for(int i = list.size() - 1; i >= 0; i--) {
			//index i의 number를 set에서 제거
			set.remove(list.get(i).x);
			// i번째의 숫자보다 작은 것들의 개수
			pressArr[list.get(i).idx] = set.size();
		}
		for(int i : pressArr) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

}
