import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		for(int i = 0; i < 8; i++) {
			String[] row = sc.next().split(""); // row 한줄을 입력받고 문자열을 배열로 쪼갬
			
			if(i % 2 == 0) { // (row, 0)이 하얀색
				for(int j = 0; j < row.length; j++) { 
					if(j % 2 == 0 && row[j].equals("F")) // 하얀색의 위치 && F가 있는지
						cnt++;
				}
			}
			else {	// (row, 0)이 검은색
				for(int j = 0; j < row.length; j++) {
					if(j % 2 != 0 && row[j].equals("F")) // 하얀색의 위치 && F가 있는지
						cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
