
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 1번선수의 입장에서 보면 1번 선수를 포함하는 팀과 포함하지 않는 팀으로 나눌 수 있다.
	// 1번을 포함하는 모든 경우의 수를 구하여  최소값을 찾는다.
	static int[][] arr;
	static boolean[] ch;
	static int N;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		ch = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 1번선수 포함하여 시작
		ch[0] = true;
		min = Integer.MAX_VALUE;
		makeTeam(1, 1);
		System.out.println(min);
	}
	//1번을 무조건 포함하고 나머지 선수 들 중에서 뽑는다.
	static void makeTeam(int idx, int sidx) {
		// 1명을 무조건 선택했고, 1명을 선택 안하는 범위
		if(sidx >= 1 && sidx <= N - 2) {
			int A = calcSynergy()[0];
			int B = calcSynergy()[1];
			min = Math.min(min, Math.abs(A - B));
		}
		else {
			return;
		}
		
		for(int i = idx; i < N; i++) {
			ch[i] = true;
			makeTeam(i + 1, sidx + 1);
			ch[i] = false;
		}
	}
	
	public static int[] calcSynergy() {
		int[] AB = new int[2];
		// true를 A팀 false를  B팀으로 한다.
		for(int i = 0; i < ch.length - 1; i++) {
			for(int j = i; j < ch.length; j++) {
				if(ch[i] == true && ch[j] == true) {
					AB[0] += arr[i][j] + arr[j][i];
				}
				else if(ch[i] == false && ch[j] == false) {
					AB[1] += arr[i][j] + arr[j][i];
				}
			}
		}
		
		return AB;
	}
}
