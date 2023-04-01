class Solution {
    public int solution(int n) {
        int length = Integer.bitCount(n);
        
        while(n++ > 0){
            if(length == Integer.bitCount(n)){
                break;
            }
        }
        
        return n;
    }
}