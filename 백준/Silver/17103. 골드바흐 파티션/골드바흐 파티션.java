
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// 에라토스테네스의 체를 이용해서 N범위의 소수를 구해놓는다. 1000000까지
	static boolean[] arr = new boolean[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 에라토스테네스의체 , false인 것 들은 소수이다.
		arr[0] = arr[1] = true;
		for(int i = 2; i < arr.length; i++) {
			if(arr[i] == true)
				continue;
			for(int j = 2; i * j < arr.length; j++) {
				arr[i * j] = true;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			int count = 0;
			int N = Integer.parseInt(br.readLine());
			//순서만 바꾼것은 같은것으로 친다고 했으므로 N/2만큼만 반복한다.
		    //차례대로 i가 소수이고, N-i 가 소수일경우 카운트를 증가시킨다.
			for(int i = 2; i <= N / 2; i++) {
				if(arr[i] == false && arr[N - i] == false) {
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}
