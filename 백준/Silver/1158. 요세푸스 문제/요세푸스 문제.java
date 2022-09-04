import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		//Queue
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++)
			queue.offer(i);
		
		sb.append("<");
		int cycle = 0;
		while(queue.size() != 1) {
			cycle++;
			if(cycle == K) {
				sb.append(queue.poll()).append(", ");
				cycle = 0;
			}
			else {
				queue.offer(queue.poll());
			}
		}
		sb.append(queue.poll()).append(">");
		System.out.println(sb);
	}
}
