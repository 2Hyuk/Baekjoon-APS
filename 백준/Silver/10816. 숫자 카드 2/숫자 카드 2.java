import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			String key = st.nextToken(); // 키값 하나씩 받음
			if(map.containsKey(key)) { // 키가 있다면
				map.put(key, map.get(key) + 1); // 키의 밸류 +1
			}
			else {
				map.put(key, 1); //키가 없다면 키 추가
			}
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			String key = st.nextToken();
			if(map.containsKey(key)) {
				sb.append(map.get(key)).append(" "); // 키가 있다면 밸류를 추가하고
			}
			else {
				sb.append(0).append(" "); // 없다면 0추가
			}
		}
		System.out.println(sb);
	}
}
