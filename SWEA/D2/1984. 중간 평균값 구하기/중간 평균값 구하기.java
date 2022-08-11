
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[10001];
			int[] inputArr = new int[10];
			
			for(int j = 0; j < 10; j++) {
				int idx = Integer.parseInt(st.nextToken());
				arr[idx]++;
				inputArr[j] = idx;
			}
			
			for(int j = 1; j < arr.length; j++) {
				arr[j] += arr[j-1];
			}
			
			int[] sortArr = new int[10];
			for(int j = sortArr.length - 1; j >= 0; j--) {
				sortArr[--arr[inputArr[j]]] = inputArr[j];
			}
			
			int sum = 0;
			for(int j = 1; j < sortArr.length - 1; j++) {
				sum += sortArr[j];
			}
			System.out.println("#" + i + " " +Math.round((double)sum / (sortArr.length - 2)));
		}
	}
}
