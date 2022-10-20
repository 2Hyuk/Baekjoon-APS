
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node{
		int n;
		String order;

		public Node(int n, String order) {
			super();
			this.n = n;
			this.order = order;
		}
		
	}
	static int A, B;
	static Queue<Node> q;
	static boolean[] visited;
	static String minOrder;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			q = new LinkedList<>();
			visited = new boolean[10000];
			minOrder = "";
			flag = false;
			A = sc.nextInt();
			B = sc.nextInt();
			q.offer(new Node(A, ""));
			visited[A] = true;
			bfs();
			sb.append(minOrder).append("\n");
		}
		System.out.println(sb);

	}
	static void bfs() {
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.n == B) {
				if(!flag || minOrder.length() > node.order.length()) {
					minOrder = node.order;
					flag = true;
				}
				continue;
			}
			if(flag && minOrder.length() <= node.order.length())
				continue;
			
			int num = 0;
			num = D(node.n);
			if(!visited[num]) {
				visited[num] = true;
				q.offer(new Node(num, node.order + "D"));
			}
			num = S(node.n);
			if(!visited[num]) {
				visited[num] = true;
				q.offer(new Node(num, node.order + "S"));
			}
			num = L(node.n);
			if(!visited[num]) {
				visited[num] = true;
				q.offer(new Node(num, node.order + "L"));
			}
			num = R(node.n);
			if(!visited[num]) {
				visited[num] = true;
				q.offer(new Node(num, node.order + "R"));
			}
			
		}
	}
	
	static int D(int num) {
		return (2 * num) % 10000;
	}
	
	static int S(int num) {
		return num == 0 ? 9999 : num - 1;
	}
	
	static int L(int num) {
		String tmp = num + "";
		while(tmp.length() < 4) {
			tmp = "0" + tmp;
		}
		String str = tmp.substring(1, 4) + tmp.substring(0, 1);
		return Integer.parseInt(str);
	}
	
	static int R(int num) {
		String tmp = num + "";
		while(tmp.length() < 4) {
			tmp = "0" + tmp;
		}
		String str = tmp.substring(3, 4) + tmp.substring(0, 3);
		return Integer.parseInt(str);
	}
}
