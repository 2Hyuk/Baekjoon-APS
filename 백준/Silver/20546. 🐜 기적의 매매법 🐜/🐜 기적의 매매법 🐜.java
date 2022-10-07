
import java.util.Scanner;

public class Main{
	// 0:준현, 1:성민
	static int[] seedMoney = new int[2];
	static int[] stock = new int[2];
	static int[] price = new int[15];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		seedMoney[0] = seedMoney[1] = sc.nextInt();
		for (int i = 1; i <= 14; i++) {
			price[i] = sc.nextInt();
		}

		for (int i = 1; i <= 14; i++) {
			bnp(i);
			timing(i);
		}
		
		int bnpResult = seedMoney[0] + stock[0] * price[14];
		int timingResult = seedMoney[1] + stock[1] * price[14];

		if (bnpResult > timingResult)
			System.out.println("BNP");
		else if (bnpResult < timingResult)
			System.out.println("TIMING");
		else
			System.out.println("SAMESAME");

	}

	static void bnp(int day) {
		// 시드머니가 현재 주가 보다 크다면
		if (seedMoney[0] >= price[day]) {
			// 살수있는 만큼 주식을 사고
			stock[0] += seedMoney[0] / price[day];
			// 잔금은 시드머니로 다시 넣는다.
			seedMoney[0] = seedMoney[0] % price[day];
		}
	}

	static void timing(int day) {
		if (day >= 4) {
			//3연속 커지면?
			if (price[day-1] > price[day - 2] && price[day - 2] > price[day - 3]) {
				//다팔고
				seedMoney[1] += stock[1] * price[day];
				stock[1] = 0;
				
				//3연속작아지면
			} else if (price[day-1] < price[day - 2] && price[day - 2] < price[day - 3]) {
				//다팔고
				seedMoney[1] += stock[1] * price[day];
				stock[1] = 0;
				if (seedMoney[1] >= price[day]) {
					//다사고
					stock[1] += seedMoney[1] / price[day];
					seedMoney[1] = seedMoney[1] % price[day];
				}
			}
		}

	}

}
