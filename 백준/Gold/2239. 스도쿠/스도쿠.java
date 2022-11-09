
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] board;
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];
		for(int i = 0; i < 9; i++) {
			String input = br.readLine();
			for(int j = 0; j < 9; j++) {
				board[i][j] = input.charAt(j) - '0';
			}
		}
		dfs(0, 0);
		
		
		
	}
	public static void dfs(int row, int col) {
		if(flag) return;
		
		if(col == 9) {
			row++;
			col = 0;
		}
		//기저조건
		if(row == 9) {
			flag = true;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			return;
		}
		
		//이미 값이 들어있다면 다음으로
		if(board[row][col] != 0)
			dfs(row, col + 1);
		else {
			for(int i = 1; i <= 9; i++) {
				board[row][col] = i;
				if(check(row, col)) {
					dfs(row, col + 1);
				}
				board[row][col] = 0;
			}
		}
	}
	
	public static boolean check(int row, int col) {
		boolean[] check = new boolean[10];
		//가로
		for(int i = 0; i < 9; i++) {
			if(board[row][i] == 0)
				continue;
			else if(check[board[row][i]]) {
				return false;
			}
			else {
				check[board[row][i]] = true;
			}
		}
		
		//세로
		Arrays.fill(check, false);
		for(int i = 0; i < 9; i++) {
			if(board[i][col] == 0)
				continue;
			else if(check[board[i][col]]) {
				return false;
			}
			else {
				check[board[i][col]] = true;
			}
		}
		
		//3x3
		Arrays.fill(check, false);
		int nr = (row / 3) + 2 * (row / 3);
		int nc = (col / 3) + 2 * (col / 3);
		for(int i = nr; i < nr + 3; i++) {
			for(int j = nc; j < nc + 3; j++) {
				if(board[i][j] == 0)
					continue;
				else if(check[board[i][j]]) {
					return false;
				}
				else {
					check[board[i][j]] = true;
				}
			}
		}
		return true;
	}
}
