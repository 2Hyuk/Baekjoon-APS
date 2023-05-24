import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> foods = new PriorityQueue<>();
        
        for(int i : scoville){
            foods.offer(i);
        }
        
        int answer = 0;
        while(true){

            int minScoville = foods.poll();
            if(minScoville >= K){
               break;
            }
            
            if(foods.isEmpty()){
                answer = -1;
                break;
            }
            
            int secondScoville = foods.poll();
            int mix = minScoville + secondScoville * 2;
            foods.offer(mix);
            answer++;
        }
        return answer;
    }
}