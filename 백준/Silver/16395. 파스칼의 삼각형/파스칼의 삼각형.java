
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] pascal;
	static int n;
	static int k;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		//n줄 k번째 까지 구할꺼니깐 nxn이 최대
		pascal = new int[n][n];
		//초기 값
		pascal[0][0] = 1;
		//n줄 k번째의 인덱스는 n-1, k-1
		System.out.println(pascalsTriangle(n - 1, k - 1));

	}
	
	static int pascalsTriangle(int nidx, int kidx) {
		//삼각형 테두리 부분은 다 1이다.
		if(kidx <= 0 || kidx >= nidx) {
			return pascal[nidx][kidx] = 1;
		}
		//값이 구해지지 않았다면 구한다.
		if(pascal[nidx][kidx] == 0) {
			pascal[nidx][kidx] = pascalsTriangle(nidx - 1, kidx - 1) + pascalsTriangle(nidx - 1, kidx);
		}
		return pascal[nidx][kidx];
	}
}
