import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int MIN_NUMBER = 0;
    static final int MAX_NUMBER = 100000;
    static boolean[] visited;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;

        q = new LinkedList<>();
        q.offer(new int[]{N, 0});

        visited = new boolean[MAX_NUMBER + 1];

        while(!q.isEmpty()){
            int[] pos = q.poll();

            if(pos[0] == M){
                answer = pos[1];
                break;
            }

            int nextNum;

            nextNum = pos[0] + 1;
            move(nextNum, pos[1]);

            nextNum = pos[0] - 1;
            move(nextNum, pos[1]);

            nextNum = pos[0] + A;
            move(nextNum, pos[1]);

            nextNum = pos[0] - A;
            move(nextNum, pos[1]);

            nextNum = pos[0] + B;
            move(nextNum, pos[1]);

            nextNum = pos[0] - B;
            move(nextNum, pos[1]);

            nextNum = pos[0] * A;
            move(nextNum, pos[1]);

            nextNum = pos[0] * B;
            move(nextNum, pos[1]);

        }

        System.out.println(answer);
    }



    public static void move(int nextNum, int moveCnt){
        if(movable(nextNum)){
            q.offer(new int[]{nextNum, moveCnt + 1});
            visited[nextNum] = true;
        }
    }
    public static boolean movable(int nextNum){
        if(nextNum < 0 || nextNum > 100000 || visited[nextNum])
            return false;

        return true;
    }
}