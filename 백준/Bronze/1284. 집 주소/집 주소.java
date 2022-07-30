import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int num = sc.nextInt(); num != 0; num = sc.nextInt()) {
			int width = 1;
			while (num > 0) {
				if (num % 10 == 0) {
					width += 5;
				} else if (num % 10 == 1) {
					width += 3;
				} else {
					width += 4;
				}
				num /= 10;
			}
			System.out.println(width);
		}

	}
}
