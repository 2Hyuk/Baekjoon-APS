
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 1번선수의 입장에서 보면 1번 선수를 포함하는 팀과 포함하지 않는 팀으로 나눌 수 있다.
	// 그러므로 1번선수를 포함하는 모든 경우를 구하여 ch배열에서 체크하고, 팀원을 다 골랐다면 true인 선수들과 false인 선수들의 능력치의 차를 구한다.
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
		ch[0] = true;
		min = Integer.MAX_VALUE;
		makeTeam(1, 1);
		System.out.println(min);
	}
	//1번을 무조건 포함하고 나머지 선수 들 중에서 뽑는다.
	static void makeTeam(int idx, int sidx) {
		if(sidx == N / 2) {
			int[] teamStart = new int[N/2]; //true
			int[] teamLink = new int[N/2];  // false
			int startIdx = 0;
			int LinkIdx = 0;
			for(int i = 0; i < ch.length; i++) {
				if(ch[i] == true)
					teamStart[startIdx++] = i;
				else {
					teamLink[LinkIdx++] = i;
				}
			}
			min = Math.min(min, Math.abs(calcAbility(teamStart) - calcAbility(teamLink)));
			return;
		}
		
		for(int i = idx; i <= N - N/2 + sidx; i++) {
			ch[i] = true;
			makeTeam(i + 1, sidx + 1);
			ch[i] = false;
		}
	}
	
	static int calcAbility(int[] idx) {
		int sum = 0;
		for(int i = 0; i < idx.length - 1; i++) {
			for(int j = i; j < idx.length; j++) {
				sum += arr[idx[i]][idx[j]] + arr[idx[j]][idx[i]];
			}
		}
		return sum;
	}
}
