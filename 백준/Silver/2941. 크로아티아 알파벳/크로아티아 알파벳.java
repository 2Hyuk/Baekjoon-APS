import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		br.close();
		for(int i = 0; i < croatia.length; i++) {
			if(str.indexOf(croatia[i]) != -1) {
				str = str.replace(croatia[i], " ");
			}
		}
		int result = str.length();
		System.out.println(result);
	}
}
