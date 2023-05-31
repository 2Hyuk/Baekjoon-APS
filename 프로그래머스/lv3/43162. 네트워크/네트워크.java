import java.util.*;
import java.util.stream.*;

class Solution {
    public static int[] network;
    public int solution(int n, int[][] computers) {
        network = new int[n];
        for(int i = 0; i < n; i++){
            network[i] = i;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                int px = findParent(i);
                int py = findParent(j);
                if(px != py && computers[i][j] == 1){
                    network[py] = px;
                }
            }
        }
        
        Set<Integer> set = Arrays.stream(network)
            .boxed()
            .collect(Collectors.toSet());
        
        return set.size();
    }
    
    public int findParent(int x){
        if(network[x] == x){
            return x;
        }
        return network[x] = findParent(network[x]);
    }
}
