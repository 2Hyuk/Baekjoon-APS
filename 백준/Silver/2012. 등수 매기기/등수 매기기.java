import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // |A-B|가 최소가되려면? 오름차순 정렬해서 원하는 등수에 가깝게 해준다.
        // 1 1 2 3 5
        // 0 1 1 1 0
        // 1 2 3 1 5
        // 0 0 0 3 0 이니깐 총합은 같다?
        int[] array = new int[N];

        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);

        long ans = 0;

        for (int i = 0; i < N; i++){
            ans += Math.abs(i + 1 - array[i]);
        }

        System.out.println(ans);
    }
}
