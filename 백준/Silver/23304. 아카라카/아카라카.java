import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String answer;

		answer = isAkaraka(s) ? "AKARAKA" : "IPSELENTI";

		System.out.println(answer);
	}

	public static boolean isAkaraka(String s){
		if(s.length() == 1)
			return true;

		if(!isPalindrome(s))
			return false;

		int rightStartIdx = s.length() / 2;
		if(s.length() % 2 == 1){
			rightStartIdx += 1;
		}

		String leftStr = s.substring(0, s.length() / 2);
		String rightStr = s.substring(rightStartIdx, s.length());

		if(!(isAkaraka(leftStr) && isAkaraka(rightStr)))
			return false;

		return true;
	}


	public static boolean isPalindrome(String s){
		int lt = 0;
		int rt = s.length() - 1;

		while(lt < rt && rt > lt){
			if(s.charAt(lt) != s.charAt(rt)){
				return false;
			}
			lt++;
			rt--;
		}
		return true;
	}
}

