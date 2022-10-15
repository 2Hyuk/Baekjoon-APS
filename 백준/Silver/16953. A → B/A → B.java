	
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.Scanner;
	
	public class Main {
		static class Node{
			long num;
			int move;
	
			public Node(long num, int move) {
				super();
				this.num = num;
				this.move = move;
			}
		
		}
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			long A = sc.nextLong();
			long B = sc.nextLong();
			Queue<Node> q = new LinkedList<>();
			
			q.offer(new Node(A, 1));
			int ans = -1;
			
			while(!q.isEmpty()) {
				Node node = q.poll();
				if(node.num == B) {
					ans = node.move;
					break;
				}
				
				long num = node.num * 2;
				if(num <= B) {
					q.offer(new Node(num, node.move + 1));
				}
				num = node.num * 10 + 1;
				if(num <= B) {
					q.offer(new Node(num, node.move + 1));
				}
			}
			System.out.println(ans);
		}
	}
