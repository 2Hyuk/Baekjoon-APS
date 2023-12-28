import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    1번째 위치는 1, 2번째 위치는 2... 와 같이 각 위치에 가중치를 부여하여 해당 숫자의 총 가중치 합을 구한다.
    이 때, 항상 변형된 데이터는 원래의 위치보다 앞으로 가도록 변형되어 있으므로 가장 가중치가 낮은 값은 위치가 변경되었을 가능성이 크다.
    따라서 해당 숫자의 가중치 합에서 최소 가중치를 빼서 최종 가중치를 구한다.
    이 가중치 순서대로 숫자를 정렬하면 정답이 나온다.
 */
public class Main {
    static class Node implements Comparable<Node>{
        int n, w;
        public Node(int n, int w){
            this.n = n;
            this.w = w;
        }

        @Override
        public int compareTo(Node n){
            return this.w - n.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        List<Integer>[] data = new ArrayList[3];
        for(int i = 0; i < 3; i++){
            data[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                data[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            int aw = i + 1;
            int bw = data[1].indexOf(data[0].get(i)) + 1;
            int cw = data[2].indexOf(data[0].get(i)) + 1;
            int sw = aw + bw + cw - Math.min(aw, Math.min(bw, cw));

            pq.add(new Node(data[0].get(i), sw));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll().n).append(" ");
        }

        System.out.println(sb);


    }
}