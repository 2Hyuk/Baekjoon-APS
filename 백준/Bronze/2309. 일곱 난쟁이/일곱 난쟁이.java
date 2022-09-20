
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[] arr = new int[9];
	static boolean[] ch = new boolean[9];
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		list.clear();
		combi(0, 0, 0);
		Collections.sort(list);
//		List<Integer> list = new ArrayList<>();
//		int sum = 0;
//		for(int i = 0; i < 9; i++) {
//			list.add(sc.nextInt());
//			sum += list.get(i);
//		}
//		Collections.sort(list);
//		loop:for(int i = 0; i < list.size()-1; i++) {
//			for(int j = i + 1; j < list.size(); j++) {
//				if(sum - (list.get(i) + list.get(j)) == 100) {
//					list.remove(j);
//					list.remove(i);
//					break loop;
//				}
//			}
//		}
		for (int i : list) {
			System.out.println(i);
		}

	}
	static boolean check = false;
	public static void combi(int idx, int sidx, int sum) {
		if(check)
			return;
		if (sidx == 7) {
			if (sum == 100) {
				for (int i = 0; i < ch.length; i++) {
					if (ch[i] == true)
						list.add(arr[i]);
				}
				check = true;
			}
			return;
		}

		for (int i = idx; i <= 2 + sidx; i++) {
			ch[i] = true;
			combi(i + 1, sidx + 1, sum + arr[i]);
			ch[i] = false;
		}
	}
}
