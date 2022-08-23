
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static class Heap {
		int[] heap;
		int size;

		Heap(int length) {
			size = 0;
			heap = new int[length + 1];
		}

		void insert(int data) {
			size++;
			heap[size] = data;
			insertPos();
			
		}
		void insertPos() {
			int i = size;
			while(i != 1) {
				//부모노드가 자식노드보다 작다면
				if(heap[i/2] < heap[i]) {
					int tmp = heap[i];
					heap[i] = heap[i/2];
					heap[i/2] = tmp;
					i = i/2;
				}
				//부모보다 크지않다면 종료
				else {
					break;
				}
			}
		}

		int delete() {
			if(size == 0) return -1;
			int data = heap[1];
			heap[1] = heap[size];
			size--;	
			DeletePos();
			return data;
		}

		void DeletePos() {
			int i = 1;
			while (true) {
				boolean isLeft = true;
				// 오른쪽 배열이 존재할 때
				if (2 * i + 1 <= size) {
					// 왼쪽오른쪽 비교해서 더 큰쪽으로 선택
					if (heap[2 * i + 1] > heap[2 * i])
						isLeft = false;
				}
				// 오른쪽 배열일 떄, 위에서 사이즈 2*i+1 이 존재한다는걸 확인했으므로 사이즈 확인 필요 X
				if (!isLeft) {
					if (heap[i] < heap[2 * i + 1]) {
						int tmp = heap[i];
						heap[i] = heap[2 * i + 1];
						heap[2 * i + 1] = tmp;
						i = 2 * i + 1;
					}
					else {
						break;
					}
				}
				// 왼쪽배열일때, 오른쪽 배열이 없을 경우 2*i가 사이즈 내에 존재하는 지도 확인해야됨.
				else if (2 * i <= size && isLeft) {
					// 부모노드가 더 작으므로 자리바꾼다.
					if (heap[i] < heap[2 * i]) {
						int tmp = heap[i];
						heap[i] = heap[2 * i];
						heap[2 * i] = tmp;
						// 이제 2*i번쨰에서 시작
						i = 2 * i;
					}
					else {
						break;
					}
				}
				// 자식노드가 존재하지 않거나, 바꿀필요가 없는 경우
				else {
					break;
				}

			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st;
			int N = Integer.parseInt(br.readLine());
			Heap heap = new Heap(N);
			sb.append("#"+ tc + " ");
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int type = Integer.parseInt(st.nextToken());
				if(type == 1) {
					heap.insert(Integer.parseInt(st.nextToken()));
				}
				else {
					sb.append(heap.delete()).append(" ");
				}
			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
