import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for(int i = 1; i <= testCase; i++) {
			int room = sc.nextInt();
			int round = 1;
			int student = 0;
			boolean[] roomArr = new boolean[room]; // false: 닫힘, true 열림
			while(room >= round) {
				for(int j = 1 * round; j <= room; j += round) { //방열고닫기
					if(roomArr[j - 1] == false) {
						roomArr[j - 1] = true;
					}
					else {
						roomArr[j - 1] = false;
					}
				}
				round++;
			}
			for(boolean b : roomArr) {
				if(b == true) {
					student++;
				}
			}
			System.out.println(student);
		}
	}
}
