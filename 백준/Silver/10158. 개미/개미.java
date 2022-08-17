import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		
		if(p + t > w) {
			int tmp = t - (w - p);
			if((tmp / w) % 2 == 0) {
				p = w - (tmp % w);
			}
			else {
				p = tmp % w;
			}
		}
		else {
			p += t;
		}
		
		if(q + t > h) {
			int tmp = t - (h - q);
			if((tmp / h) % 2 == 0) {
				q = h - (tmp % h);
			}
			else {
				q = tmp % h;
			}
		}
		else {
			q += t;
		}
		

		System.out.println(p + " " + q);
		//시간초과
//		boolean xDir = true, yDir = true;
//		int[] dir = {-1, 1};
//		int hour = 0;
//		while(hour++ != t) {
//			if(xDir) {
//				p++;
//				xDir = (p == w) ? false : true;
//			}
//			else {
//				p--;
//				xDir = (p == 0) ? true : false;
//			}
//			
//			if(yDir) {
//				q++;
//				yDir = (q == h) ? false : true;
//			}
//			else {
//				q--;
//				yDir = (q == 0) ? true : false;
//			}
//		}
//		System.out.println(p + " " + q);
	}
}
