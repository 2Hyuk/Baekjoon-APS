import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] switchArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int switchCnt = Integer.parseInt(br.readLine()); // 스위치 개수
		switchArr = new int[switchCnt]; // 스위치 배열
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < switchCnt; i++) {
			switchArr[i] = Integer.parseInt(st.nextToken());
		}

		int studentCnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < studentCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			// 배열 인덱스는 num - 1;
			int num = Integer.parseInt(st.nextToken());
			changeState(student, num);

		}
        //20개씩 끊어서 줄바꿈
		for(int i = 0; i < switchArr.length; i++) {
			sb.append(switchArr[i]).append(" ");
			if((i + 1) % 20 == 0)
				sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void changeState(int student, int num) {
		if (student == 1) { // 남자일때
			for (int i = 0; i < switchArr.length; i++) {
				if ((i + 1) % num == 0) { // i가 num의 배수일때
					switchArr[i] = switchArr[i] == 0 ? 1 : 0; // 스위치 변경
				}
			}
		} else { // 여자일때
			int idx = num - 1; // num번째 스위치의 인덱스는 num - 1;
			int around = 1;
			switchArr[idx] = switchArr[idx] == 0 ? 1 : 0; // 자기 자신의 스위치는 무조건 변경
			while (true) {
				if (idx - around >= 0 && idx + around <= switchArr.length - 1) { // idx 양옆으로 배열 범위 안에 있다면 if문 수행
					if(switchArr[idx - around] == switchArr[idx + around]) { // 양 옆이 스위치의 숫자가 같다면
						switchArr[idx - around] = switchArr[idx - around] == 0 ? 1 : 0; //왼쪽 변경
						switchArr[idx + around] = switchArr[idx + around] == 0 ? 1 : 0; //오른쪽 변경
						around++;
					}
					else {
						break; // 양옆이 같지 않다면 종료
					}
				}
				else {
					break; // 양옆이 배열안에 없다면 종료
				}
			}
		}
	}
}
