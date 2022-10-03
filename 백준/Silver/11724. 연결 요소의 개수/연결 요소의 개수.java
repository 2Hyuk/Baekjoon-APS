
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		p = new int[N];
		
		for(int i = 0; i < N; i++) {
			p[i] = i;
		}
		for(int i = 0; i < M; i++) {
			int px = findSet(sc.nextInt() - 1);
			int py = findSet(sc.nextInt() - 1);
			
			union(px, py);
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			int x = findSet(i);
			set.add(x);
		}
		System.out.println(set.size());
	}
	
	static int findSet(int x) {
		if(p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
	
	static void union(int x, int y) {
		p[y] = x;
	}
}
