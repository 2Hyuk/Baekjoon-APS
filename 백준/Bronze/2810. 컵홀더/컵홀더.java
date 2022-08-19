import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String seat = br.readLine();
		seat = seat.replace("LL", "S");
		int max = seat.length() + 1;
		if(max > N) max = N;
		System.out.println(max);
	}
}
