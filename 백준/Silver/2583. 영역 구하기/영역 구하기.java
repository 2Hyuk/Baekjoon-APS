import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	
	static int M;
	static int N;
	static int[] xDir = {-1, 0, 1, 0};
	static int[] yDir = {0, -1, 0, 1};
	static int blankArea;
	static int blankCount;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] paper = new int[M][N];
		int[] xyPoint = new int[4];

		for(int i = 0; i < K; i++){
			st = new StringTokenizer(br.readLine());
			// left-bottom x
			xyPoint[0] = Integer.parseInt(st.nextToken());
			// left-bottom y
			xyPoint[1] = Integer.parseInt(st.nextToken());
			// right-top x
			xyPoint[2] = Integer.parseInt(st.nextToken());
			// right-top y
			xyPoint[3] = Integer.parseInt(st.nextToken());

			paper = drawRect(paper, xyPoint);
		}

		blankArea = 0;
		List<Integer> list = new ArrayList<>();

		for(int i = 0; i < M; i++){
			for(int j = 0; j < N; j++){
				if(paper[i][j] == 0){
					blankArea++;
					blankCount = 0;
					findBlank(paper, i, j);
					list.add(blankCount);
				}
			}
		}

		Collections.sort(list);
		System.out.println(blankArea);
		for(int i : list){
			System.out.print(i + " ");
		}
	}

	public static int[][] drawRect(int[][] paper, int[] xyPoint){

		int startRow = M - xyPoint[3];
		int startCol = xyPoint[0];
		int endRow = M - xyPoint[1];
		int endCol = xyPoint[2];

		for(int i = startRow; i < endRow; i++){
			for(int j = startCol; j < endCol; j++){
				paper[i][j] = 2;
			}
		}
		return paper;
	}

	public static void findBlank(int[][] paper, int row, int col){
		
		paper[row][col] = blankArea;
		blankCount++;

		for(int i = 0; i < 4; i++){
			int nr = row + xDir[i];
			int nc = col + yDir[i];

			if(nr < 0 || nr >= M || nc < 0 || nc >= N || paper[nr][nc] != 0){
				continue;
			}

			findBlank(paper, nr, nc);
		}

	}

}
