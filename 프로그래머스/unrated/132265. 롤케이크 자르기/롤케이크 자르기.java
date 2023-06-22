import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int leftCnt = 0;
        int rightCnt = 0;
        int[] leftArr = new int[10001];
        int[] rightArr = new int[10001];
        
        for(int i = 0; i < topping.length; i++){
            if(rightArr[topping[i]]++ == 0){
                rightCnt++;
            }
        }
        
        for(int i = 0; i < topping.length - 1; i++){
            if(leftArr[topping[i]]++ == 0){
                leftCnt++;
            }
            
            rightArr[topping[i]]--;
            if(rightArr[topping[i]] == 0){
                rightCnt--;
            }
            
            if(leftCnt == rightCnt){
                answer++;
            }
        }
        
        return answer;
    }
}