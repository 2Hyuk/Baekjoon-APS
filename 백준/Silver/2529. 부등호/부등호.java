
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static boolean[] ch = new boolean[10];
	static String[] inequality;
	static int k;
	static long max;
	static long min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		inequality = br.readLine().split(" ");
		int[] arr = new int[k+1];
		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;
		makeEqualityNumber(-1, 0, arr);
		
		// String형으로 변경한 뒤 제일 앞에 0이 있었다면 0을 붙여준다.
		String strMax = Long.toString(max);
		String strMin = Long.toString(min);
		if(strMax.length() != k + 1)
			strMax = "0" + strMax;
		if(strMin.length() != k + 1)
			strMin = "0" + strMin;
		
		System.out.println(strMax);
		System.out.println(strMin);
		
	}
	
	public static void makeEqualityNumber(int num, int sidx, int[] arr) {
		// 숫자를 골랐고, 비교할 수 있도록 2개이상을 골랐을 때
		// 부등호와 비교해서 맞는지 아닌지 검사한다.
		if(num >= 0 && sidx > 1) {
			if(inequality[sidx-2].equals("<")) {
				if(arr[sidx-2] > arr[sidx-1]) {
					return;
				}
			}
			else {
				if(arr[sidx-2] < arr[sidx-1]) {
					return;
				}
			}
		}
		// k+1개 의 숫자를 다 골랐을 때 최대 최소를 찾는다.
		if(sidx == k + 1) {
			long number = 0;
			for(int i = 0; i < k+1; i++) {
				number = number * 10 + arr[i];
			}
			
			if(number > max)
				max = number;
			if(number < min)
				min = number;
			return;
		}
		
		for(int i = 0; i <= 9; i++) {
			if(ch[i] == false) {
				ch[i] = true;
				arr[sidx] = i;
				makeEqualityNumber(i, sidx + 1, arr);
				ch[i] = false;
			}
		}
	}
}
