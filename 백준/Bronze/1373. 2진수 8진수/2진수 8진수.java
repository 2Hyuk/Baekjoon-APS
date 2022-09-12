
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		sb.append(br.readLine()).reverse();
		while(sb.length() % 3 != 0) {
			sb.append("0");
		}
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
		System.out.println(result.reverse());
	}
}
