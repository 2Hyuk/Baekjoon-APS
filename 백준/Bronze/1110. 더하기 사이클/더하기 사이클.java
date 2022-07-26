import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		//n을 임시로 저장시켜줄 tmp
		int tmp = n;
		//총 사이클 
		int cycle = 0;
		do {
			//새로운 수 = 주어진 수의 오른쪽자리를 십의자리로 한 수 + 주어진 수의 구한 합을 더한 수를 일의자리로(10을 넘을 경우가 있으므로 %10으로 뒤의자리만 뺴온다)
			tmp =  ((tmp % 10) * 10) + ((tmp / 10 + tmp % 10) % 10);
			// 사이클 증가
			cycle++;
			// tmp랑 n이랑 같지 않다면 계속 반복
		}while(tmp != n);
		System.out.println(cycle);
	}
}
