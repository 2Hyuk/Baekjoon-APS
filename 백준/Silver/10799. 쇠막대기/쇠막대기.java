import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int T = Integer.parseInt(br.readLine());
		//for(int tc = 1; tc <= T; tc++) {
			char[] inputArr = br.readLine().toCharArray();
			int stickCnt = 1;
			int sum = 0;
			for(int i = 1; i < inputArr.length; i++) {
				char prev = inputArr[i-1];
				//레이저일 때, 레이저인 경우에도 증가시켰으므로 감소부터 시키고나서 자른다.
				if(inputArr[i] == ')' && prev == '(') {
					stickCnt--;
					sum += stickCnt; 
				}
				//스틱 열 때, 레이저일 경우도 일단 증가시킨다.
				else if(inputArr[i] == '('){
					stickCnt++;
				}
				//스틱 닫을 때, 자르고 남은 나머지 부분 1개를 더한다.
				else {
					stickCnt--;
					sum++;
				}
			}
			System.out.println(sum);
			//System.out.println("#" + tc + " " + sum);
		//}
	}
}
