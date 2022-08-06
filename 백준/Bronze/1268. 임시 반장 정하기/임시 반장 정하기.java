import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static int checkOverlap(int studentNum, String[][] arr) {
		boolean[] ch = new boolean[arr.length]; //defalut : false;
		
		for(int col = 0; col < 5; col++) {
			for(int row = 0; row < arr.length; row++) {
				if(studentNum == row) continue;
				else if(arr[studentNum][col].equals(arr[row][col])) {
					ch[row] = true;
				}
			}
		}
		int cnt = 0;
		for(boolean b : ch) {
			if(b == true) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int student = Integer.parseInt(br.readLine());
		String[][] classArr = new String[student][5];
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < student; i++) {
			classArr[i] = (br.readLine().split(" "));
		}
		br.close();
		int maxCount = Integer.MIN_VALUE;
		int classLeader = 1;
		for(int i = 0; i < student; i++) {
			int tmp = checkOverlap(i, classArr);
			if(maxCount < tmp) {
				maxCount = tmp;
				classLeader = i + 1;
			}
		}
		System.out.println(classLeader);
	}
}

