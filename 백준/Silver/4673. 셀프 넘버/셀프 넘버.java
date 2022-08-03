public class Main {
	public static void main(String[] args) {
		boolean[] num = new boolean[10001];
		
		for(int i = 1; i <= 10000; i++) {
			int number = i;
			int sum = i;
			while(number > 0) {
				sum += number % 10;
				number /= 10;
			}
	
			if(sum <= 10000) {
				num[sum] = true;
			}
		}
		for(int i = 1; i <= 10000; i++) {
			if(num[i] == false) {
				System.out.println(i);
			}
		}
	}
}
