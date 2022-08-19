
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			//입력받은 원래상태를 char배열로 저장하고, '0'으로 초기화된 char배열을 준비한다.
			char[] originBit = br.readLine().toCharArray();
			char[] initBit = new char[originBit.length];
			for(int i = 0; i < initBit.length; i++) {
				initBit[i] = '0';
			}
			//총 고치는 횟수는 fixBit함수로부터 반환받는다.
			int count = fixBit(originBit, initBit);
			System.out.println("#" + tc + " " + count);
		}
	}
	
	public static int fixBit(char[] originBit, char[] initBit) {
		char[] bit = initBit;
		int idx = 0;
		int cnt = 0;
		while(idx < initBit.length) { // idx는 0 부터 배열길이-1 까지 돌면서 내용물을 비교해보고 다르면 수정한다.
			if(originBit[idx] != bit[idx]) { // 다를떄
				bit = changeBit(bit, idx); // changeBit함수를 통해서 idx부터 끝까지 수정한다.
				cnt++; //수정한 횟수
			}
			idx++; //다음 인덱스로 증가
		}
		return cnt;
	}
	
	public static char[] changeBit(char[] bit, int idx) {
		char ch = bit[idx] == '0' ? '1' : '0'; // 고쳐야되는 인덱스의 값이 0이라면 1로, 1이라면 0으로 수정한다.
		for(int i = idx; i < bit.length; i++) {
			bit[i] = ch; // 인덱스부터 끝까지 수정
		}
		return bit;
	}
}
