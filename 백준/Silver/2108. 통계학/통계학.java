import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] arr = new int[8001];
		double sum = 0;
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			list.add(num);
			arr[num + 4000]++;
			sum += num;
		}
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		//산술평균
		sb.append((int)Math.round(sum / N)).append("\n");
		//중앙값
		sb.append(list.get(N/2)).append("\n");
		//최빈값
		int maxValue = 0;
		int maxIdx = 0;
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			if(maxValue < arr[i]) {
				maxValue = arr[i];
				maxIdx = i;
			}
		}
		for(int i = 0; i < arr.length; i++) {
			if(maxValue == arr[i]) {
				cnt++;
				if(cnt == 2) {
					maxIdx = i;
					break;
				}
			}
		}
		
		sb.append(maxIdx - 4000).append("\n");
		
		//범위
		sb.append(list.get(list.size()-1) - list.get(0)).append("\n");
		
		System.out.println(sb);
	}
}
