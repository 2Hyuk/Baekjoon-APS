
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node{
		int x;
		int time;
		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	static int N;
	static int K;
	static int answer;
	static Queue<Node> queue = new LinkedList<>();
	static boolean[] visited = new boolean[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		answer = -1;
		visited[N] = true;
		bfs(N, 0);
		System.out.println(answer);
	}
	
	static void bfs(int point, int time) {
		if(answer != -1) return;
		
		if(answer == -1 && point == K) {
			answer = time;
		}
		int nextPoint = point + 1;
		if(nextPoint >= 0 && nextPoint <= 100000 && visited[nextPoint] == false) {
			visited[nextPoint] = true;
			queue.offer(new Node(nextPoint, time));
		}
		
		nextPoint = point - 1;
		if(nextPoint >= 0 && nextPoint <= 100000 && visited[nextPoint] == false) {
			visited[nextPoint] = true;
			queue.offer(new Node(nextPoint, time));
		}
		
		nextPoint = 2 * point;
		if(nextPoint >= 0 && nextPoint <= 100000 && visited[nextPoint] == false) {
			visited[nextPoint] = true;
			queue.offer(new Node(nextPoint, time));
		}
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			bfs(node.x, node.time + 1);
		}
	}
}
