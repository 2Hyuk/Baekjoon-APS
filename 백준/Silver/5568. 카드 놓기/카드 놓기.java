import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static boolean[] ch;
	static String[] cardArr;
	static int k;
	static Set<String> set = new HashSet<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		k = sc.nextInt();
		
		//카드 숫자 배열
		cardArr = new String[n];
		for(int i = 0; i < n; i++) {
			cardArr[i] = sc.next();
		}
		
		//숫자를 사용했는지 체크하는 배열
		ch = new boolean[n];
		combineNum("", 0);
		
		System.out.println(set.size());

	}
	
	static void combineNum(String num, int cnt) {
		//cnt = k일 때 set안에 값이 없다면 넣는다.
		if(cnt == k) {
			if(!set.contains(num)) {
				set.add(num);
			}
			return;
		}
		
		for(int i = 0; i < ch.length; i++) {
			if(ch[i] == false) {
				ch[i] = true;
				combineNum(num + cardArr[i], cnt + 1);
				ch[i] = false;
			}
		}
	}
}
