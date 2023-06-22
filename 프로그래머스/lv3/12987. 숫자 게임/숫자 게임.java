import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> teamA = new PriorityQueue<>(Collections.reverseOrder());
        Deque<Integer> teamB = new ArrayDeque<>();
        
        Arrays.sort(B);
        
        for(int i = B.length - 1; i >= 0; i--){
            teamA.offer(A[i]);
            teamB.offer(B[i]);
        }
        
        while(!teamA.isEmpty()){
            int num_A = teamA.poll();
            
            if(num_A >= teamB.peekFirst()){
                teamB.pollLast();
            }
            else if(num_A < teamB.pollFirst()){
                answer++;
            }
        }
        
        return answer;
    }
}