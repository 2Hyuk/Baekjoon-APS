import java.util.Scanner;

public class Main {
	static int[][] arr = new int[1001][1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			
			for(int row = x; row < x + w; row++) {
				for(int col = y; col < y + h; col++) {
					arr[row][col] = i;
				}
			}
		}
		int[] areaArr = new int[N+1];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				areaArr[arr[i][j]]++;
			}
		}
		
		for(int i = 1; i < areaArr.length; i++) {
			System.out.println(areaArr[i]);
		}

	}
}
