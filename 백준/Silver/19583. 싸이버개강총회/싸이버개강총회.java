import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int count = 0;

		String startValue = st.nextToken();
		String endValue = st.nextToken();
		String finalValue = st.nextToken();

		String value = br.readLine();

		HashSet<String> user = new HashSet<>();
		HashSet<String> attendance = new HashSet<>();

		while(!value.isEmpty() && (value = br.readLine()) != null) {
			st = new StringTokenizer(value, " ");
			String timeValue = st.nextToken();
			String userName = st.nextToken();

			if(timeValue.compareTo(startValue) <=0) {
				user.add(userName);
			}
			else if(timeValue.compareTo(endValue) >= 0 && timeValue.compareTo(finalValue) <= 0) {
				attendance.add(userName);
			}

		}

		for(String s : user) {
			if(attendance.contains(s)) {
				count++;
			}
		}

		System.out.println(count);
	}
}
