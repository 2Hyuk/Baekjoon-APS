
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// N:동생 수, S: 수빈이의 현재 위치
		// 하나의 D값으로 모든 동생의 위치를 찾을 수 있어야 하며 D값은 그중에서 가장 큰 수 이어야 한다. -> 최대공약수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		// 수빈이의 위치와 동생들의 위치의 차를 구해서 배열에 넣는다.
		// 배열에 넣은 값들의 최대공약수를 구해야 한다.
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int A = Integer.parseInt(st.nextToken());
			arr[i] = Math.abs(A - S);
		}
		
		// N이 1인 경우에는 수빈이와 동생의 거리의 차이가 최대공약수이다.
		if(N == 1) {
			System.out.println(arr[0]);
		}
		// N이 2인경우에는 두 수 의 최대공약수를 구해서 출력한다.
		else if(N == 2) {
			System.out.println(gcd(Math.max(arr[0], arr[1]), Math.min(arr[0], arr[1])));
		}
		// N이 3이상인 경우 배열의 처음 인덱스부터 최대공약수를 구한다.
		// 구한 최대공약수를 이용해서 계속해서 최대공약수를 구한다.
		// 최대공약수 1이 나오는 경우가 생긴다면 답은 1이다.
		else {
			int gcd = 0;
			boolean flag = false;
			for(int i = 0; i < arr.length - 1; i++) {
				gcd = gcd(arr[i], arr[i+1]);
				arr[i+1] = gcd;
				if(gcd == 1) {
					flag = true;
					break;
				}
			}
			if(flag == true) {
				System.out.println(1);
			}
			else {
				System.out.println(gcd);
			}
		}
		
	}
	
	
	static int gcd(int a, int b) {
		if(b == 0) 
			return a;
		
		return gcd(b, a % b);
	}
}
