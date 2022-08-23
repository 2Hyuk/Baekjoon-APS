import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static String[] nameArr;
	static int[] evolutionArr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		nameArr = new String[N];
		evolutionArr = new int[N];
		int maxValue = 0;
		int maxIdx = 0;
		int totalCnt = 0;
		for(int i = 0; i < N; i++) {
			nameArr[i] = br.readLine();
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			evolutionArr[i] = evolution(K, M);
			//가장 많이 진화한 종류
			if(maxValue < evolutionArr[i]) {
				maxValue = evolutionArr[i];
				maxIdx = i;
			}
			//진화하는 모든 마리 수
			totalCnt += evolutionArr[i];
		}
		System.out.println(totalCnt + "\n" + nameArr[maxIdx]);
		
	}
	
	static int evolution(int K, int M) {
		int need = K;
		int total = M;
		int cnt = 0;
		while(need <= total) {
			total -= need;
			total += 2;
			cnt++;
		}
		return cnt;
	}
}
