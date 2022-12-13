import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Chip implements Comparable<Chip>{
		double point;
		char name;
		
		public Chip(double point, char name) {
			super();
			this.point = point;
			this.name = name;
		}

		@Override
		public int compareTo(Chip o) {
			if(this.point > o.point)
				return -1;
			
			return 1;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine()); // 대회에 참가한 참가자 수
		int N = Integer.parseInt(br.readLine()); // 스태프의 수
		double cutLine = X * 0.05;
		
		int[] staffArr = new int[25];
		Arrays.fill(staffArr, -1);
		
		//PriorityQueue를 이용해서 상위 14개를 뽑는다.
		PriorityQueue<Chip> pq = new PriorityQueue<>();
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char staffName = st.nextToken().charAt(0); // 스태프 이름
			double voteCount = Double.parseDouble(st.nextToken()); // 총 득표 수
			
			// 5퍼이상일 경우
			if(voteCount >= cutLine) {
				staffArr[staffName - 'A'] = 0;
				
				//1~14로 나눈 값을 구하여 pq에 넣는다.
				for(int j = 1; j <= 14; j++) {
					pq.add(new Chip(voteCount / j, staffName));
				}
			}
			
		}
		
		//14등까지 칩 나눠준다.
		for(int i = 0; i < 14; i++) {
			Chip chip = pq.poll();
			staffArr[chip.name - 'A']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 25; i++) {
			//5프로 이상인 스태프에 대해서만
			if(staffArr[i] != -1) {
				sb.append((char)('A' + i)).append(" " + staffArr[i]).append("\n");
			}
		}
		System.out.println(sb);
		
	}
}
