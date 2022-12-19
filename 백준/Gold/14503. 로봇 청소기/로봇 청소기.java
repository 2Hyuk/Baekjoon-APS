import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] areaArr;
	static int ans;
	public static class Robot{
		int row, col, dir;
		boolean move;
		
		public Robot() {
			super();
		}

		public Robot(int row, int col, int dir ,boolean move) {
			super();
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.move = move;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int currRow = Integer.parseInt(st.nextToken());
		int currCol = Integer.parseInt(st.nextToken());
		int currDir = Integer.parseInt(st.nextToken());
		Robot robot = new Robot(currRow, currCol, currDir, false);
		
		areaArr = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				areaArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		while(true) {
			cleanArea(robot);
			robot = searchArea(robot);
			if(!robot.move)
				break;
			robot.move = false;
		}
		System.out.println(ans);
	}
	
	//1
	public static void cleanArea(Robot robot) {
		if(areaArr[robot.row][robot.col] == 0) {
			areaArr[robot.row][robot.col] = 2;
			ans++;
		}
	}
	
	//2
	public static Robot searchArea(Robot robot) {
		int dir = robot.dir;
		
		for(int i = 0; i < 4; i++) {
			switch(dir) {
			case 0:
				dir = 3;
				if(areaArr[robot.row][robot.col - 1] == 0) {
					return new Robot(robot.row, robot.col - 1, dir, true);
				}
				break;
			case 1:
				dir = 0;
				if(areaArr[robot.row - 1][robot.col] == 0) {
					return new Robot(robot.row - 1, robot.col, dir, true);
				}
				break;
			case 2:
				dir = 1;
				if(areaArr[robot.row][robot.col + 1] == 0) {
					return new Robot(robot.row, robot.col + 1, dir, true);
				}
				break;
			case 3:
				dir = 2;
				if(areaArr[robot.row + 1][robot.col] == 0) {
					return new Robot(robot.row + 1, robot.col, dir, true);
				}
				break;
			}
		}
		
		switch(robot.dir) {
		case 0:
			if(areaArr[robot.row + 1][robot.col] != 1) {
				return new Robot(robot.row + 1, robot.col, robot.dir, true);
			}
			break;
		case 1:
			if(areaArr[robot.row][robot.col - 1] != 1) {
				return new Robot(robot.row, robot.col - 1, robot.dir, true);
			}
			break;
		case 2:
			if(areaArr[robot.row - 1][robot.col] != 1) {
				return new Robot(robot.row - 1, robot.col, robot.dir, true);
			}
			break;
		case 3:
			if(areaArr[robot.row][robot.col + 1] != 1) {
				return new Robot(robot.row, robot.col + 1, robot.dir, true);
			}
			break;
		}
		return new Robot(robot.row, robot.col, robot.dir, false);
	}
}
