import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        var stack = new Stack<Integer>();
        var times = new int[prices.length];
            
        for(int i = 0; i < prices.length; i++){
            int price = prices[i];
            int time = 1;
            while(!stack.isEmpty() && stack.peek() > price){
                if(times[i - time] == 0){
                    times[i - time] = time;
                    stack.pop();
                }
                time++;
            }
            stack.push(price);
        }
        
        int time = 1;
        for(int i = prices.length - 2; i >= 0; i--){
            if(times[i] == 0) 
                times[i] = time;
            time++;
        }
        
        return times;
    }
}