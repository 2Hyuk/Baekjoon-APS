
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	static String[][] mapArr;
	static Set<Integer> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			set = new HashSet<>();
			mapArr = new String[4][4];
			for (int i = 0; i < 4; i++) {
				mapArr[i] = br.readLine().split(" ");
			}
			for(int row = 0; row < 4; row++) {
				for(int col = 0; col < 4; col++) {
					move(0, row, col, mapArr[row][col]);
				}
			}
			System.out.println("#" + tc + " " + set.size());
		}
	}
	
	static void move(int cnt, int row, int col, String str) {
		if(cnt == 6) {
			set.add(Integer.parseInt(str));
			return;
		}
		
			if(col > 0) {
				move(cnt + 1, row, col - 1, str + mapArr[row][col-1]);
			}
			if(col < 3) {
				move(cnt + 1, row, col + 1, str + mapArr[row][col+1]);
			}
			if(row > 0) {
				move(cnt + 1, row - 1, col, str + mapArr[row-1][col]);
			}
			if(row < 3) {
				move(cnt + 1, row + 1, col, str + mapArr[row+1][col]);
		}
	}
}