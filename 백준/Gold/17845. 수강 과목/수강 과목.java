import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 공부시간
        K = Integer.parseInt(st.nextToken()); //과목수

        int[] priority = new int[K + 1];
        int[] time = new int[K + 1];
        int[][] dp = new int[K + 1][N + 1];

        for(int i = 1; i <= K; i++){
            st = new StringTokenizer(br.readLine());
            priority[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= K; i++){
            for(int j = 1; j <= N; j++){
                if(time[i] > j){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - time[i]] + priority[i]);
                }
            }
        }

        System.out.println(dp[K][N]);

    }

}