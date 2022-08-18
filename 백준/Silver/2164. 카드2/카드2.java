import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		
		//큐에 1~N까지 추가
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		while(queue.size() > 1) {
			//첫번째 원소 뺴고
			queue.poll();
			//두번째원소는 제일뒤로 넣음
			queue.offer(queue.poll());
			
			}
			//큐에 1개의 원소가 있을 때
			System.out.println(queue.poll());
	}
}
