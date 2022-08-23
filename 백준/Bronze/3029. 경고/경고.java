import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] start = br.readLine().split(":");
		String[] end = br.readLine().split(":");
		for(int i = 2; i >= 0; i--) {
			int st = Integer.parseInt(start[i]);
			int et = Integer.parseInt(end[i]);
			if(et < st) {
				if(i != 0) {
					end[i-1] = Integer.toString((Integer.parseInt(end[i-1]) - 1));
					et = 60 + et - st;
				}
				else {
					et = 24 + et - st;
				}
			}
			else {
				et -= st;
			}
			end[i] = et < 10 ? "0" + Integer.toString(et) : Integer.toString(et);
		}
		if(end[0].equals("00")&& end[1].equals("00") && end[2].equals("00")) {
			end[0] = "24";
		}
		System.out.println(end[0]+":"+end[1]+":"+end[2]);
	}
}
