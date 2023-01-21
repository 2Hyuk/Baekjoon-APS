import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int count = 0;
		int num = 665;
		while(true){
			num += 1;
			if(isPossible(num)){
				count++;
				if(N == count){
					break;
				}
			}

		}
		System.out.println(num);
	}

	public static boolean isPossible(int num){

		int count = 0;

		while(num > 0){
			if(num % 10 == 6){
				count++;
				if(count == 3){
					return true;
				}
			}
			else{
				count = 0;
			}
			num /= 10;
		}


		return false;
	}
}
