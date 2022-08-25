import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Queue {
		int[] queue;
		int size;
		int rear;
		int front;

		Queue(int length) {
			queue = new int[length];
			rear = -1;
			front = 0;
		}

		boolean isEmpty() {
			if (size == 0)
				return true;
			return false;
		}

		int size() {
			return this.size;
		}

		boolean offer(int data) {
			if (size == queue.length) {
				return false;
			}
			queue[++rear] = data;
			size++;
			return true;
		}

		int poll() {
			if (isEmpty())
				return -1;

			int data = queue[front++];
//			for (int i = 0; i < size - 1; i++) {
//				queue[i] = queue[i + 1];
//			}
			size--;
//			rear--;
			return data;
		}

		int front() {
			if (isEmpty())
				return -1;
			return queue[front];
		}

		int back() {
			if (isEmpty())
				return -1;
			return queue[rear];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Queue queue = new Queue(N);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			switch (order) {
				case "push":
					queue.offer(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					sb.append(queue.poll()).append("\n");
					break;
				case "empty":
					sb.append(queue.isEmpty() ? 1 : 0).append("\n");
					break;
				case "size":
					sb.append(queue.size()).append("\n");
					break;
				case "front":
					sb.append(queue.front()).append("\n");
					break;
				case "back":
					sb.append(queue.back()).append("\n");
					break;
			}
		}
		System.out.println(sb);
	}
}
