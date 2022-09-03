
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		LinkedList<String> list = new LinkedList<>();
		ListIterator<String> iter = list.listIterator();
		
		String initStr = br.readLine();
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < initStr.length(); i++) {
			iter.add(""+initStr.charAt(i));
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			switch(order) {
				case "L":
					if(iter.hasPrevious())
						iter.previous();
					break;
				case "D":
					if(iter.hasNext())
						iter.next();
					break;
				case "B":
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
				case "P":
					iter.add(st.nextToken());
					break;
				default:
					break;
			}
		}
		
		for(String s : list) {
			sb.append(s);
		}
		System.out.println(sb);
	}
}
