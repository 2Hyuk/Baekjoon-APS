
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		int ans = 0;
		if(N % 2 == 0) {
			for(int i = 0 ; i < list.size() / 2; i++) {
				ans += list.get(i);
			}	
			ans *= 2;
		}
		else {
			for(int i = 0 ; i < list.size() / 2; i++) {
				ans += list.get(i);
			}
			//int ans2 = ans + list.get(list.size() - 1);
			//ans += list.get(list.size() / 2);
			ans *= 2;
			ans += list.get(list.size() / 2);
		}
		
		System.out.println(ans);
		

	}
}
