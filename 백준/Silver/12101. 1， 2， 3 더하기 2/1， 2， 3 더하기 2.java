import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		List<String>[] arr = new ArrayList[n+3];
		for(int i = 0; i <=n+2; i++) {
			arr[i] = new ArrayList<>();
		}
		
		arr[1].add("1");
		arr[2].add("1+1");
		arr[2].add("2");
		arr[3].add("1+1+1");
		arr[3].add("1+2");
		arr[3].add("2+1");
		arr[3].add("3");
		
		
		for(int i = 4; i <=n; i++) {
			for(int j = 3; j >= 1; j--) {
				for(String s : arr[i-j]) {
					arr[i].add(s + "+" + j);
				}
			}
		}
		
		Collections.sort(arr[n]);
		
		if(arr[n].size() >= k) {
			System.out.println(arr[n].get(k-1));
		}
		else {
			System.out.println(-1);
		}
	}
}
