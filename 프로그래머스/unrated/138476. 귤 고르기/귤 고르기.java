import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int[] count = new int[10000001];
        
        for(int i = 0; i < tangerine.length; i++){
            count[tangerine[i]]++;
        }
        
        Arrays.sort(count);
        
        int answer = 0;
        for(int i = 10000000; i > 0; i--){
            if(k <= 0) break;
            k -= count[i];
            answer++;
        }
        return answer;
    }
}