
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 에라토스테네스의 체를 이용해서 소수는 false, 소수가 아니면 true인 배열로 만든다.
		boolean[] notPrime = new boolean[1000000];
		notPrime[0] = notPrime[1] = true;
		
		for(int i = 2; i < notPrime.length; i++) {
			if(notPrime[i] == true)
				continue;
			for(int j = 2; i * j < notPrime.length; j++) {
				if(notPrime[i * j] == false)
					notPrime[i * j] = true;
			}
		}
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				break;
			
			boolean flag = false;
			for(int i = n - 1; i > 1; i--) {
				if(notPrime[i] == true)
					continue;
				
				if(notPrime[n - i] == false) {
					flag = true;
					sb.append(n + " = " + (n - i) + " + " + i).append("\n");
					break;
				}
			}
			if(!flag)
				sb.append("Goldbach's conjecture is wrong.").append("\n");
		}
		System.out.println(sb);
	}
}
