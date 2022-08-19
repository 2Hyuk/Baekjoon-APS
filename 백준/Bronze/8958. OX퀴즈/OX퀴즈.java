import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i = 1; i <= tc; i++) {
			String ox = sc.next();
			int correctCnt = 0;
			int answer = 0;
			
			for(int j = 0; j < ox.length(); j++) {
				if(ox.charAt(j) == 'O') {
					answer += ++correctCnt;
				}
				else {
					correctCnt = 0;
				}
			}
			System.out.println(answer);
		}
	}
}
