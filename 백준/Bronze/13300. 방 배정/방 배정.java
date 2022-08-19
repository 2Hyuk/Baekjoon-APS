import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] manArr = new int[7]; // 1~6만 사용할거임
		int[] womanArr = new int[7]; // 1~6만 사용할거임
		for(int i = 0; i < N; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			
			if(gender == 0) {//여자
				womanArr[grade]++;
			}
			else {//남자
				manArr[grade]++;
			}
			
		}
		
		int roomCnt = 0;
		for(int idx = 1; idx <= 6; idx++) {
			roomCnt += (manArr[idx] % K == 0) ? (manArr[idx] / K) : (manArr[idx] / K) + 1;
			roomCnt += (womanArr[idx] % K == 0) ? (womanArr[idx] / K) : (womanArr[idx] / K) + 1;
		}
		System.out.println(roomCnt);
	}
}
