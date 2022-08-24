import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //참가자수
		int B = sc.nextInt(); //예산
		int H = sc.nextInt(); //호텔의 수
		int W = sc.nextInt(); //고를수 있는 주의 수
		int[] hotelPrice = new int[H];
		int minPrice = Integer.MAX_VALUE;
		boolean isPossible = false;
		
		for(int i = 0; i < H; i++) {
			int price = sc.nextInt();
			for(int j = 0; j < W; j++) {
				int maxPerson = sc.nextInt();
				if(N <= maxPerson) {
					int totalPrice = N * price;
					if(totalPrice <= B) {
						minPrice = Math.min(minPrice, totalPrice);
						isPossible = true;
					}
				}
			}
		}
		System.out.println((isPossible == true) ? minPrice : "stay home");
	}
}