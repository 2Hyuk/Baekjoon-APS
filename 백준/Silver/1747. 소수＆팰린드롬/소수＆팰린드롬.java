import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] isNotPrime = new boolean[1005000];

		isNotPrime[0] = isNotPrime[1] = true;
		for(int i = 2; i < isNotPrime.length; i++) {
			if(isNotPrime[i] == true)
				continue;
			for(int j = 2; i * j < isNotPrime.length; j++) {
				isNotPrime[i*j] = true;
			}
		}
		
		while(true) {
			if (!isNotPrime[N] && Palindrome(Integer.toString(N))) {
					System.out.println(N);
					break;
			}
			N++;
		}
	}
	public static boolean Palindrome(String s) {
		for(int i = 0; i < s.length()/2; i++) {		
			if(s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}

//	public static boolean isPrime(int n) {
//		for (int i = 2; i * i <= n; i++) {
//			if (n % i == 0)
//				return false;
//		}
//		return true;
//	}
	
}
