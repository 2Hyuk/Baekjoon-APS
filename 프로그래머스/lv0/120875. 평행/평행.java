
class Solution {
    public int solution(int[][] dots) {
        if(isParallel(dots[0], dots[1]) == isParallel(dots[2], dots[3]))
            return 1;
        if(isParallel(dots[0], dots[2]) == isParallel(dots[1], dots[3]))
            return 1;
        if(isParallel(dots[0], dots[3]) == isParallel(dots[1], dots[2]))
            return 1;
        
        return 0;
        
    }
    
    public double isParallel(int[] dot1, int[] dot2){
        return (double)(dot2[1] - dot1[1]) / (dot2[0] - dot1[0]);
                            
    }
}