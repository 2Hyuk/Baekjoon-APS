import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String K = sc.next();
		int count = 0;
		
		loop1 : for(int h = 0; h <= N; h++) {
			for(int m = 0; m <= 59; m++) {
				for(int s = 0; s <= 59; s++) {
					String str = "";
					str += h < 10 ? "0" + h : h;
					str += m < 10 ? "0" + m : m;
					str += s < 10 ? "0" + s : s;
					for(String ele : str.split("")) {
						if(K.equals(ele)) {
							count++;
							break;
						}
					}
				}
			}
		}
		System.out.println(count);

	}
}
