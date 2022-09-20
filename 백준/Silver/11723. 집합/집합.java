
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int bitMask = 0;
		// 1~20이 들어오는데 비트자리수는 0부터 시작이므로 -1해준다.
		// 1~20이 들어오는데 비트자리수로 들어왔을때 1, 아닐때 0으로 표현해준다.
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			int num;
			switch(order) {
				case "add":
					num = Integer.parseInt(st.nextToken());
					// | 연산으로 1이 들어오면 1로 바꿔준다.
					bitMask |= (1 << (num - 1));
					break;
				case "remove":
					num = Integer.parseInt(st.nextToken());
					// ~로 뒤집어서 삭제할 숫자가 있는 자리의 비트를 0으로 변경한다.
					// 이후 &연산을 하면 해당 비트는 무조건0으로 변경되므로 삭제가 된다.
					bitMask &= ~(1 << (num - 1));
					break;
				case "check":
					num = Integer.parseInt(st.nextToken());
					// 체크하고자 하는 숫자의 비트자리에 1이 있나 없나 검사한다. 있다면 0보다 무조건 크므로 1을 출력한다.
					sb.append(((bitMask & (1 << (num - 1))) > 0 ? "1" : "0" )).append("\n");
					break;
				case "toggle":
					num = Integer.parseInt(st.nextToken());
					// ^연산을 통해서 같다면 0 다르면 1를 넣게 되는데, 입력으로 1을 넣었으므로  같으면 삭제, 없으면 추가가 된다.
					bitMask ^= (1 << (num - 1));
					break;
				case "all":
					// ~0은 전부다 1이 되므로, 1 OR을 통해 모두 1로 변경한다.
					bitMask |= (~0);
					break;
				case "empty":
					// 0 AND를 통해 전부다 0으로 변경한다.
					bitMask &= 0;
					break;
				default:
					break;
			}
		}
		System.out.println(sb);
	}
}
