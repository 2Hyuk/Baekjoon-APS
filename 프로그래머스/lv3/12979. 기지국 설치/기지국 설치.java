import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int answer = 0;
        int idx = 1;
        int area = 2 * w + 1;
        
        for(int station : stations){
            int min = station - w >= 1 ? station - w : 1;
            int max = station + w <= n ? station + w : n;
            
            if(idx < min){
                int count = min - idx;
                answer += count % area == 0 ? count / area : count / area + 1;
            }
            idx = max + 1;
        }
       
        if(idx < n + 1){
            int count = n + 1 - idx;
            answer += count % area == 0 ? count / area : count / area + 1;
        }
        
        
        
        return answer;
    }
}