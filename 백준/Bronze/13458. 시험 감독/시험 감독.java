import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
        //시험장의 수
		int[] area = new int[N];
		for (int i = 0; i < N; i++) {
            //각 시험장의 사람 수
			area[i] = sc.nextInt();
		}
        
		int B = sc.nextInt(); // 감독
		double C = sc.nextDouble();//부감독

		long ans = 0;

		for (int i = 0; i < N; i++) {
			area[i] -= B; //감독이 케어할 수 있는만큼 빼준다
			ans++; //감독수 추가
			if (area[i] > 0) { // 그래도 사람이 남아있따면
				if(area[i] / C == 0) { // 한사람으로 커버되면 한명만
					ans++;
				}
				else {
					ans += Math.ceil(area[i] / C); //아니면 더 추가
				}
			}
		}
		System.out.println(ans);
	}
}
