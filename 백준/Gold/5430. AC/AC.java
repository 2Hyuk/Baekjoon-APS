
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	/*
	 * R로 뒤집은 뒤 D로 제일 앞의 원소를 뺀다는 것은 뒤집지 않고 뒤에서 빼는 것 과 같다.
	 * 따라서 뒤집혔는지 안뒤집혔는지 확인하는 boolean 값을 통해서 앞에서 뺄지 뒤에서뺼지 정하면 된다.
	 * RR이나오는경우 뒤집을 필요가 없다.
	 * */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new LinkedList<>();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String func = br.readLine();
			int n = Integer.parseInt(br.readLine());
			//입력받은 배열
			String arr = br.readLine();
			
			//arr의 숫자를 뽑아서 덱에 넣음
			int num = 0;
			//[ 다음부터 실행
			int idx = 1;
			while(n > 0) {
				if(arr.charAt(idx) >= '0' && arr.charAt(idx) <= '9') {
					num = num * 10 + arr.charAt(idx) - '0';
				}
				else {
					deque.offer(num);
					n--;
					num = 0;
				}
				idx++;
			}
			//처음은 안뒤집힌 상태 : 앞에서 부터 뺀다.
			boolean isReverse = false;
			boolean flag = false;
			for (int i = 0; i < func.length(); i++) {
				char function = func.charAt(i);
				//R인경우 뒤집는다.
				if(function == 'R') {
					isReverse = !isReverse;
				}
				else {
					//빈 덱일 경우 종료
					if(deque.isEmpty()) {
						flag = true;
						break;
					}
					//뒤집혀있다면 뒤에서부터
					if(isReverse) {
						deque.pollLast();
					}
					//뒤집혀있지않다면 앞에서부터
					else {
						deque.pollFirst();
					}
				}
			}
			
			if(flag) {
				System.out.println("error");
			}
			else {
				sb.append("[");
				if(deque.size() != 0) {
					if(isReverse) {
						while(deque.size() > 1) {
							sb.append(deque.pollLast()).append(",");
						}
						sb.append(deque.pollLast()).append("]");
					}
					else {
						while(deque.size() > 1) {
							sb.append(deque.poll()).append(",");
						}
						sb.append(deque.poll()).append("]");
					}
				}
				else {
					sb.append("]");
				}
				System.out.println(sb);
				sb.setLength(0);
			}
			deque.clear();
			//sb.append("\n");
		}
	}
}
