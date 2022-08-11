import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		int cycle = 0;
		while(true) {
			cycle++;
			String[] case1 = br.readLine().split("");
			String[] case2 = br.readLine().split("");
			if(String.join("",case1).equals("END") && String.join("", case2).equals("END"))
				break;
			System.out.println("Case " + cycle + ": " + (compareWord(case1, case2) ? "same" : "different"));
			//sb.append("Case ").append(cycle).append(": ").append(compareWord(case1, case2) ? "same" : "different").append("\n");
		}
		//System.out.println(sb);
	}
	public static boolean compareWord(String[] case1, String[] case2) {
		if(case1.length != case2.length)
			return false;
		
		int len = case2.length;
		for(int i = 0; i < case1.length; i++) {
			for(int j = 0; j < case2.length; j++) {
				if (case1[i].equals(case2[j])) {
					case2[j] = "";
					len--;
					break;
				}
			}
		}
		if(len == 0)
			return true;
		return false;
	}
}
