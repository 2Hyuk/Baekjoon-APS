
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		List<String> list = new ArrayList<>();
		while(word.length() > 0) {
			list.add(word);
			word = word.substring(1);
		}
		
		Collections.sort(list, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				int n = Math.min(o1.length(), o2.length());
				for(int i = 0; i < n; i++) {
					if(o1.charAt(i) != o2.charAt(i)) {
						return o1.charAt(i) - o2.charAt(i);
					}
				}
				return o1.length() - o2.length();
			}
		});
		
		for(int i = 0;  i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
