import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.stream(works).forEach(pq::add);
        int remainTime = n;
        while(!pq.isEmpty() && remainTime > 0){
            int work = pq.poll();
            work--;
            remainTime--;
            if(work != 0){
                pq.add(work);
            }
        }
        
        long answer = 0;
        
        while(!pq.isEmpty()){
            int work = pq.poll();
            answer += work * work;
        }
        
        return answer;
    }
}