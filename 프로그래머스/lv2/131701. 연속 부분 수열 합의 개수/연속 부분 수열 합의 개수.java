import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int count = 1; count <= elements.length; count++){
            for(int start = 0; start < elements.length; start++){
                int select = 0;
                int sidx = start;
                int sum = 0;
                while(count > select){
                    select++;
                    if(sidx == elements.length){
                        sidx = 0;
                    }
                    sum += elements[sidx];
                    sidx++;
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}