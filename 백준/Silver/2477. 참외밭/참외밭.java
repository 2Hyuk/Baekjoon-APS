import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		int[] dir = new int[6];
		int[] len = new int[6];
		int xMax = 0, yMax = 0; //가로 세로 최대길이
		int xMaxIdx = -1, yMaxIdx = -1;
		for(int i = 0; i < 6; i++) {
			// dir = 1 : 동쪽으로 가는 변의 방향이므로 남쪽의 길이
			// dir = 2 : 서쪽으로 가는 변의 방향이므로 북쪽의 길이
			// dir = 3 : 남쪽으로 가는 변의 방향이므로 서쪽의 길이
			// dir = 4 : 북쪽으로 가는 변의 방향이므로 동쪽의 길이
			st = new StringTokenizer(br.readLine());
			dir[i] = Integer.parseInt(st.nextToken());
			len[i] = Integer.parseInt(st.nextToken());
			
			//x방향
			if(dir[i] == 1 || dir[i] == 2) {
				if(xMax < len[i]) {
					xMax = len[i];
					xMaxIdx = i;
				}
			}
			//y방향
			else {
				if(yMax < len[i]) {
					yMax = len[i];
					yMaxIdx = i;
				}
			}
		}
		
		int bigRect = xMax * yMax;
		int smallRect = len[(xMaxIdx + 3) % 6] * len[(yMaxIdx + 3) % 6];
		int cnt = (bigRect - smallRect) * K;
		System.out.println(cnt);
			
	}
}
