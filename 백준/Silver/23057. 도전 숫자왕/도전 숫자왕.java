import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long M;
	static int[] arr;
	static Set<Long> set;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = 0;
		arr = new int[N];
		set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			int num = Integer.parseInt(st.nextToken());
			M += num;
			arr[i] = num;
		}

		powerSet(0, 0);
		System.out.println(M - set.size());
	}

	static public void powerSet(int idx, long sum){

		if(idx == N){
			if(sum != 0){
				set.add(sum);
			}
			return;
		}

		powerSet(idx + 1, sum + arr[idx]);
		powerSet(idx + 1, sum);
	}
}
