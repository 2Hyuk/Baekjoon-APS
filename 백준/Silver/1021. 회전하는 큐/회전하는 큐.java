
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int minCnt = 0;
		int[] arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			list.add(i+1);
		}
		for (int i = 0; i < M; i++) {
			int operation = direction(arr[i]);
			while(list.get(0) != arr[i]) {
				if (operation == 2) {
					leftShift();
				} 
				else {
					rightShift();
				}
				minCnt++;
			}
			list.remove(0);
		}
		System.out.println(minCnt);
	}
	
	static int direction(int ele) {
		int idx = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == ele) {
				idx = i;
				break;
			}
		}
		if (idx <= list.size() / 2) {
			return 2;
		}
		return 3;
	}
	
	static void leftShift() {
		list.add(list.remove(0));
	}

	static void rightShift() {
		list.add(0, list.remove(list.size()-1));
	}
}
