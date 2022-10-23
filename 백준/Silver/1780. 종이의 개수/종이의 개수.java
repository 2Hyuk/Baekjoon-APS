
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static class Node{
		int row, col, len;

		public Node(int row, int col, int len) {
			super();
			this.row = row;
			this.col = col;
			this.len = len;
		}
	}
	static int N;
	static String[][] paper;
	static Queue<Node> q = new ArrayDeque<>();
	static int[] result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new String[N][N];
		result = new int[3];
		for(int i = 0; i < N; i++) {
			paper[i] = br.readLine().split(" ");
		}
		
		q.offer(new Node(0, 0, N));
		bfs();
		
		for(int i : result) {
			System.out.println(i);
		}
	}
	static void bfs() {
		
		while(!q.isEmpty()) {
			Node node = q.poll();
 			if(checkPaper(node)) {
 				if(paper[node.row][node.col].equals("1")) {
 					result[2]++;
 				}
 				else if(paper[node.row][node.col].equals("0")) {
 					result[1]++;
 				}
 				else {
 					result[0]++;
 				}
 			}
 			else {
 				if(node.len == 3) {
 					for(int i = node.row; i < node.row + node.len; i++) {
 						for(int j = node.col; j < node.col + node.len; j++) {
 							if(paper[i][j].equals("1")) {
 			 					result[2]++;
 			 				}
 			 				else if(paper[i][j].equals("0")) {
 			 					result[1]++;
 			 				}
 			 				else {
 			 					result[0]++;
 			 				}
 						}
 					}
 				}
 				else {
 					int len = node.len / 3;
 					for(int i = node.row; i < node.row + node.len; i += len) {
 						for(int j = node.col; j < node.col + node.len; j += len) {
 							q.offer(new Node(i, j, len));
 						}
 					}
 					
 				}
 			}
		}
	}
	
	static boolean checkPaper(Node node) {
		int row = node.row;
		int col = node.col;
		int len = node.len;
		for(int i = row; i < row + len; i++) {
			for(int j = col; j < col + len; j++) {
				if(!paper[row][col].equals(paper[i][j])) {
					return false;
				}
			}
		}
		return true;
	}
}
