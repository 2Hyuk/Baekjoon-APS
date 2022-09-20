
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	/*
	 * alphabet을 미리 정렬해놔서 사전순으로 나오도록 한 다음, C개 중에서 L개를 조합한다.
	 * 조합 한 결과에 모음 자음 개수조건을 확인한다.
	 */
	static int L;
	static int C;
	static char[] alphabet;
	static boolean[] check;
	static char[] ch = { 'a', 'e', 'i', 'o', 'u' };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alphabet = new char[C];
		check = new boolean[C];

		String str = br.readLine();
		for (int i = 0, j = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
				alphabet[j++] = str.charAt(i);
		}
		Arrays.sort(alphabet);
		char[] arr = new char[L];
		makePW(0, 0, arr);
		System.out.println(sb);
	}

	public static void makePW(int idx, int selIdx, char[] arr) {
		
		if (selIdx == L) {
			if (!checkAlphabet(arr))
				return;
			print(arr);
			return;
		}

		for (int i = idx; i <= C - L + selIdx; i++) {
				arr[selIdx] = alphabet[i];
				makePW(i + 1, selIdx + 1, arr);
		}
	}

	public static boolean checkAlphabet(char[] arr) {
		int overlapCnt = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < ch.length; j++) {
				if (arr[i] == ch[j])
					overlapCnt++;
			}
		}
		if(overlapCnt > 0 && L - overlapCnt >= 2)
			return true;
		
		return false;
	}
	
	public static void print(char[] arr) {
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		sb.append("\n");
	}
}
