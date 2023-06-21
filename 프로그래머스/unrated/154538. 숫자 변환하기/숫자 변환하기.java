import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        queue.offer(new int[]{x, 0});
        
        while(!queue.isEmpty()){
            int[] i = queue.poll();
            
            if(i[0] == y){
                return i[1];
            }
            
            int add = i[0] + n;
            int mul2 = i[0] * 2;
            int mul3 = i[0] * 3;
            
            if(add <= y && !visited[add]){
                queue.offer(new int[]{add, i[1] + 1});
                visited[add] = true;;
            }
            
            if(mul2 <= y && !visited[mul2]){
                queue.offer(new int[]{mul2, i[1] + 1});
                visited[mul2] = true;
            }
            
            if(mul3 <= y && !visited[mul3]){
                queue.offer(new int[]{mul3, i[1] + 1});
                visited[mul3] = true;
            }
        }
        return -1;
    }
}