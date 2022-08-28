
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc = 1; tc <= T; tc++) {
			Queue<Integer> queue = new LinkedList<>();
			int[] ch = new int[10];
			int targetIdx = 0;
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			targetIdx = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				ch[num]++;
				queue.offer(num);
			}
			int cnt = 0;
			loop : for(int i = 9; i >= 1; i--) {
				while(ch[i] != 0) {
					if(!queue.isEmpty() && queue.peek() == i) {
						ch[i]--;
						queue.poll();
						cnt++;
						if(targetIdx == 0) {
							break loop;
						}
						else {
							targetIdx--;
						}
					}
					else {
						queue.offer(queue.poll());
						if(targetIdx == 0) {
							targetIdx = queue.size() -1;
						}
						else {
							targetIdx--;
						}
					}
				}
			}
			System.out.println(cnt);
		}
		
	}
}

/*
 * 우선순위 배열을 만들어서 입력받은 우선순위의 개수를 체크해준다.
 * 배열을 뒤에서 부터 돌면서 개수를 하나씩 줄여가면서 큐에서 빼낸다.
 * peek값이 가장 우선순위가 높은 숫자와 맞지 않다면 큐에서 빼서 뒤로 보낸다.
 * targetIdx는 계속해서 뺀다.
 * 만약 targetIdx가 0일 때 peek값이 i와 같다면 그건 targetIdx가 출력될 차례이므로
 * 출력하고 반복문을 종료한다.*/
