
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 * arr배열의 인덱스는 높이, 값은 화살 수 
	 * 풍선의 높이에 해당하는 값을 받고, 해당 높이의 화살이 존재하면 화살의 높이를 1 낮춘다.
	 * 존재 하지 않는다면, 사용한화살 개수를 늘리고 , 현재 높이의 풍선을 터트려서 화살의 높이를 1 낮춘다.
	 * 이걸 풍선의 개수인 N번 반복하여 총 사용한화살의 개수를 구한다.
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//최대 1000001개의 인덱스
		int[] arr = new int[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(arr[num] == 0) {
				ans++;
				arr[num - 1]++;
			}
			else if(arr[num] > 0){
				arr[num]--;
				arr[num - 1]++;
			}
		}
		
		System.out.println(ans);
		
	}
	
}