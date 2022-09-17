import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<String> list;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int k = sc.nextInt();
		
		list = new ArrayList<>();
		recur(0, "");
		Collections.sort(list);
		
		if(list.size() >= k) {
			System.out.println(list.get(k-1).substring(1));
		}
		else {
			System.out.println(-1);
		}
	}

	public static void recur(int sum, String num) {
		if(sum == n) {
			list.add(num);
			return;
		}
		else if(sum > n)
			return;
		
		recur(sum + 1, num + "+1");
		recur(sum + 2, num + "+2");
		recur(sum + 3, num + "+3");
	}
}
