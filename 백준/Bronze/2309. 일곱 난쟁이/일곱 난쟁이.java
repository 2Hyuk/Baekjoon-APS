import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		for(int i = 0; i < 9; i++) {
			list.add(sc.nextInt());
			sum += list.get(i);
		}
		Collections.sort(list);
		loop:for(int i = 0; i < list.size()-1; i++) {
			for(int j = i + 1; j < list.size(); j++) {
				if(sum - (list.get(i) + list.get(j)) == 100) {
					list.remove(j);
					list.remove(i);
					break loop;
				}
			}
		}
		for(int i : list) {
			System.out.println(i);
		}
	}
}
