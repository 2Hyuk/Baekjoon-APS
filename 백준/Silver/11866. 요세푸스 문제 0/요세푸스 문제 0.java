
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static class CircleQueue {
		int[] queue;
		int front;
		int rear;
		int size;

		CircleQueue(int n) {
			this.queue = new int[n];
			this.front = 0;
			this.rear = -1;
			this.size = 0;
		}

		boolean isEmpty() {
			return size == 0;
		}

		boolean isFull() {
			return size == queue.length;
		}

		boolean enqueue(int data) {
			if (isFull())
				return false;
			rear = (rear + 1) % queue.length;
			queue[rear] = data;
			size++;
			return true;
		}

		int dequeue() {
			if (isEmpty())
				return -1;
			int data = queue[front];
			front = (front + 1) % queue.length;
			size--;
			return data;
		}

		int peek() {
			if (isEmpty())
				return -1;
			return queue[front];
		}

		void print() {
			System.out.println(Arrays.toString(queue));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		CircleQueue queue = new CircleQueue(N);

		for (int i = 1; i <= N; i++) {
			queue.enqueue(i);
		}
		sb.append("<");
		boolean[] ch = new boolean[N + 1];
		int cycle = 0;
		while (!queue.isEmpty()) {
			if (ch[queue.peek()]) {
				queue.enqueue(queue.dequeue());
				continue;
			}
			cycle++;
			if (cycle == K) {
				int num = queue.dequeue();
				ch[num] = true;
				sb.append(num).append(", ");
				cycle = 0;
			} else {
				queue.enqueue(queue.dequeue());
			}
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb);

	}
}
