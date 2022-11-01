
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int ans = 0;
		//1일떄는 무조건 1
		if(N == 1) {
			ans = 1;
		}
		else if(M <= 4) {
			//위로 한칸이면 앞으로 2칸씩 감
			if(N == 2) {
				ans = 1 + (M - 1) / 2;
			}
			//위로 2칸 가능함 -> 앞으로 1칸씩 가는데 3번움직임
			else {
				ans = M;
			}
		}
		//4방향해야되는데 못함
		else if(M <= 6) {
			//위로 한칸이면 앞으로 2칸씩 감 근데 M이 5, 6인경우니까 최대 3
			if(N == 2) {
				ans = 3;
			}
			//위로 2칸 가능함 -> 앞으로 1칸씩 감 근데 3번까지밖에 못움직여서 최대 4
			else {
				ans = 4;
			}
		}
		//4방향 모두 가능
		else if(M == 7) {
			//위로 한칸이면 앞으로 2칸씩 감
			if(N == 2) {
				ans = 4;
			}
			//4방향 모두하면 최대 5
			else {
				ans = 5;
			}
		}
		else {
			//위로 한칸이면 앞으로 2칸씩 감 최대 3번이동가능하므로 4
			if(N == 2) {
				ans = 4;
			}
			//위로 2칸 가능함 -> 앞으로 1칸씩 감
			else {
				ans = M - 2;
			}
		}
		System.out.println(ans);
	}
}
