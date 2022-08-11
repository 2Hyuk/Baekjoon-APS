import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] inputArr = new int[N];
		// List<Integer> list = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			inputArr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, inputArr[i]);
			// list.add(Integer.parseInt(br.readLine()));
		}
		br.close();
		int[] arr = new int[2000001];
		for (int i = 0; i < N; i++) {
			arr[inputArr[i] + 1000000]++;
		}
//누적
		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
		}
		int[] countingSort = new int[N];
//
		for (int i = N - 1; i >= 0; i--) {
			countingSort[--arr[inputArr[i] + 1000000]] = inputArr[i];
		}
		
		// System.out.println(Arrays.toString(countingSort));
		for(int i : countingSort) {
			sb.append(i + "\n");
		}
		System.out.println(sb);
//		Collections.sort(list);
//		for(int i : list) {
//			sb.append(i).append("\n");
//		}
//		System.out.println(sb);
	}
}
