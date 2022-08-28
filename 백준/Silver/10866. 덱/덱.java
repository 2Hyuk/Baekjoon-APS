
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Deque {
		private int[] deque;
		private int front;
		private int rear;

		Deque(int n) {
			deque = new int[n + 1];
			front = 0;
			rear = 0;
		}

		int size() {
			if (front <= rear)
				return rear - front;
			return deque.length - front + rear;
		}

		boolean isEmpty() {
			return size() == 0;
		}

		boolean isFull() {
			return deque.length == size() + 1;
		}

		boolean pushFront(int data) {
			if (isFull())
				return false;
			deque[front] = data;
			front = (front - 1 + deque.length) % deque.length;
			return true;
		}

		boolean pushBack(int data) {
			if (isFull())
				return false;
			rear = (rear + 1) % deque.length;
			deque[rear] = data;
			return true;
		}

		int popFront() {
			if (isEmpty())
				return -1;
			front = (front + 1) % deque.length;
			return deque[front];
		}

		int popBack() {
			if (isEmpty())
				return -1;
			int data = deque[rear];
			rear = (rear - 1 + deque.length) % deque.length;
			return data;
		}

		int front() {
			if (isEmpty())
				return -1;
			return deque[(front + 1) % deque.length];
		}

		int back() {
			if (isEmpty())
				return -1;
			return deque[rear];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque deque = new Deque(N);
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			switch(order) {
				case "push_front" :
					deque.pushFront(Integer.parseInt(st.nextToken()));
					break;
				case "push_back" :
					deque.pushBack(Integer.parseInt(st.nextToken()));
					break;
				case "pop_front" :
					sb.append(deque.popFront()).append("\n");
					break;
				case "pop_back" :
					sb.append(deque.popBack()).append("\n");
					break;
				case "size" :
					sb.append(deque.size()).append("\n");
					break;
				case "empty" :
					sb.append(deque.isEmpty() == true ? 1 : 0).append("\n");
					break;
				case "front" :
					sb.append(deque.front()).append("\n");
					break;
				case "back" :
					sb.append(deque.back()).append("\n");
					break;
			}
			
		}
		System.out.println(sb);
	}
}
