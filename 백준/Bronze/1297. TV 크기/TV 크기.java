import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double D = sc.nextInt();
		double H = sc.nextInt();
		double W = sc.nextInt();
		
		double x = Math.sqrt(D*D / (H*H + W*W));
		
		System.out.println((int)(H * x) +" "+(int)(W * x));
	}
}
