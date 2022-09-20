import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	/*
	 * N개의 식재료가 있을 때 A팀, B팀으로 식재료를 반으로 나눠 팀을 맺는다.
	 * 이때 식재료 1의 시점에서 식재료1이 포함된 팀과 포함되지 않는 팀으로 나눌 수 있고, 이 경우 A, B팀을 만들 수 있는 모든 경우의 수를 구할 수 있다.
	 * 따라서  식재료1가 무조건 포함된 팀을 구하는 조합을 구하면 된다.
	 *  식재료1이 포함된 팀을 true, 포함되지 않은 팀을 false로 한 뒤
	 * true인 인덱스들의 시너지와 false를 가지는 인덱스들의 시너지의 차를 구하여 min값과 비교하여 정답을 구한다.
	 */
	static int[][] map;
	static boolean[] check;
	static int N;
	static int minValue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
	
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			check = new boolean[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			minValue = Integer.MAX_VALUE;
			check[0] = true;
			// 첫번째 식재료는 추가했다고 생각하고 1,1부터 시작한다.
			makeTeam(1, 1);
			sb.append("#" + tc + " " + minValue).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void makeTeam(int idx, int selIdx) {
		// N/2개를 다골라서 팀을 만들었다.
		if(selIdx == N / 2) {
			int A = calcSynergy()[0];
			int B = calcSynergy()[1];
			minValue = Math.min(minValue, Math.abs(A - B));
			return;
		}
		
		for(int i = idx; i <= N - N/2 + selIdx; i++) {
			check[i] = true;
			makeTeam(i + 1, selIdx + 1);
			check[i] = false;
		}
	}
	
	public static int[] calcSynergy() {
		int[] AB = new int[2];
		// true를 A팀 false를  B팀으로 한다.
		for(int i = 0; i < check.length - 1; i++) {
			for(int j = i; j < check.length; j++) {
				if(check[i] == true && check[j] == true) {
					AB[0] += map[i][j] + map[j][i];
				}
				else if(check[i] == false && check[j] == false) {
					AB[1] += map[i][j] + map[j][i];
				}
			}
		}
		
		return AB;
	}
}
