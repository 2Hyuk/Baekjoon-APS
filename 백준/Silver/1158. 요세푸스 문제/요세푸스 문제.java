import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        sb.append("<");

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            queue.add(i);
        }

        int cycle = 0;
        while(queue.size() != 1){
            cycle++;
            if(cycle == K){
                sb.append(queue.poll()).append(", ");
                cycle = 0;
            }
            else{
                queue.add(queue.poll());
            }
        }
        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}
