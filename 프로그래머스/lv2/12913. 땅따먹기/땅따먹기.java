import java.util.*;

class Solution {
    int solution(int[][] land) {
        var point = new int[land.length][4];
        point[0] = land[0];
        
        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    if(j == k) continue;
                    point[i][j] = Math.max(point[i][j], land[i][j] + point[i - 1][k]);
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < 4; i++){
            answer = Math.max(answer, point[land.length - 1][i]);
        }
        
        return answer;
    }
}