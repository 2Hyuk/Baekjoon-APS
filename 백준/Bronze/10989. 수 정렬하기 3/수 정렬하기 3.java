import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, input[i]);
			min = Math.min(min, input[i]);
		}
		
		//인풋값을 인덱스로 해서 몇개있는지 세어준다.
		int[] sumArr = new int[max - min + 1];
		for(int i = 0; i < N; i++) {
			sumArr[input[i]-min]++;
		}
		
		//누적 합 구한다.
		for(int i = 1; i < sumArr.length; i++) {
			sumArr[i] += sumArr[i-1];
		}
		
		//카운팅 배열 만든다.
		int[] countingArr = new int[N]; 
		//뒤에서 부터 input값을 입력받는다.
		//누적합에 맞는 인덱스를 찾고, 값은 1 감소시키고, 감소시킨 값을 인덱스로 하여 카운팅배열에 input값을 넣는다.
		for(int i = input.length-1; i >= 0; i--) {
			countingArr[--sumArr[input[i]-min]] = input[i];
		}
		
		for(int i : countingArr) {
				sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}
