
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dpMax = new int[2][3];
		int[][] dpMin = new int[2][3];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			int num = Integer.parseInt(st.nextToken());
			dpMax[0][i] = num;
			dpMin[0][i] = num;
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3 = Integer.parseInt(st.nextToken());
			
			//최대 찾는거
			dpMax[1][0] = Math.max(dpMax[0][0], dpMax[0][1]) + num1;
			dpMax[1][1] = Math.max(dpMax[0][0], Math.max(dpMax[0][1], dpMax[0][2])) + num2;
			dpMax[1][2] = Math.max(dpMax[0][2], dpMax[0][1]) + num3;
			//최소 찾는거
			dpMin[1][0] = Math.min(dpMin[0][0], dpMin[0][1]) + num1;
			dpMin[1][1] = Math.min(dpMin[0][0], Math.min(dpMin[0][1], dpMin[0][2])) + num2;
			dpMin[1][2] = Math.min(dpMin[0][2], dpMin[0][1]) + num3;
			//최대 값 옮겨주기
			dpMax[0][0] = dpMax[1][0];
			dpMax[0][1] = dpMax[1][1];
			dpMax[0][2] = dpMax[1][2];
			//최소 값 옮겨주기
			dpMin[0][0] = dpMin[1][0];
			dpMin[0][1] = dpMin[1][1];
			dpMin[0][2] = dpMin[1][2];
			
		}
		
		int max = Math.max(dpMax[0][0], Math.max(dpMax[0][1], dpMax[0][2]));
		int min = Math.min(dpMin[0][0], Math.min(dpMin[0][1], dpMin[0][2]));
		
		System.out.println(max + " " + min);
	}
}