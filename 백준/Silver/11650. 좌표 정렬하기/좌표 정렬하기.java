import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class XY{
		int x;
		int y;
		XY(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List<XY> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new XY(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, new Comparator<XY>(){
			@Override
			public int compare(XY o1, XY o2) {
				if(o1.x == o2.x) {
					return o1.y - o2.y;
				}
				return o1.x - o2.x;
			}});
		
		for(XY xy : list) {
			sb.append(xy.x).append(" ").append(xy.y).append("\n");
		}
		System.out.println(sb);
	}
}
