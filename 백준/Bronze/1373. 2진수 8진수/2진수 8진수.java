
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		//2진수를 String 으로 받아서 3의 배수개로 맞춰준다.
		sb.append(br.readLine()).reverse();
		while(sb.length() % 3 != 0) {
			sb.append("0");
		}
		//3개씩 끊은 후, 하나씩 보면서 1인 경우에는 자리별로 2^0, 2^1, 2^2를 더해준다.
		String bin = sb.toString();
		for(int i = 0; i < bin.length(); i += 3) {
			int sum = 0;
			for(int j = i, k = 0; j < i + 3; j++, k++) {
				if(bin.charAt(j) == '1') {
					sum += Math.pow(2, k);
				}
			}
			result.append(sum);
		}
		// 다시 뒤집어준다.
		System.out.println(result.reverse());
	}
}
