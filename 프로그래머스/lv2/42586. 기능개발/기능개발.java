import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            queue.offer(new int[]{progresses[i], speeds[i]});
        }
        
        List<Integer> list = new ArrayList<>();
        int day = 1;
        int count = 0;
        while(!queue.isEmpty()){
            int[] work = queue.peek();
            if(work[0] + work[1] * day >= 100){
                queue.poll();
                count++;
            }
            else{
                day++;
                if(count > 0){
                    list.add(count);
                    count = 0;
                }
            }
        }
        if(count > 0){
            list.add(count);
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
}