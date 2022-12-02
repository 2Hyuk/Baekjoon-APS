
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N : 자리 바꾸는 회수
		int[] cup = new int[4]; // 1,2,3번컵의 위치를 나타낼 배열
		
		//초기 위치 설정
		for(int i = 1; i <= 3; i++) {
			cup[i] = i;
		}
		
		for(int i = 0; i < N; i++) {
			int cup1 = sc.nextInt();
			int cup2 = sc.nextInt();
			
			//같은 컵이 아닐경우 컵의 자리를 바꾼다.
			if(cup1 != cup2) {
				int tmp = cup[cup1];
				cup[cup1] = cup[cup2];
				cup[cup2] = tmp;
			}
		}
		//공은 첫번째 자리의 컵에 들어있다.
		for(int i = 1; i <= 3; i++) {
			if(cup[i] == 1) {
				System.out.println(i);
				break;
			}
		}
		
	}
}
