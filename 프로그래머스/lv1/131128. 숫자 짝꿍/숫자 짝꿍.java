import java.util.*;
import java.io.*;

class Solution {
    public String solution(String X, String Y) {
        
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        
        for(int i = 0; i < X.length(); i++){
            xCount[X.charAt(i) - '0']++;
        }
        
        for(int i = 0; i < Y.length(); i++){
            yCount[Y.charAt(i) - '0']++;
        }
            
        StringBuilder answer = new StringBuilder();
            
        int idx = 9;
        while(idx > 0){
            if(xCount[idx] > 0 && yCount[idx] > 0){
                xCount[idx]--;
                yCount[idx]--;
                answer.append(idx);
            }
            else{
                idx--;
            }
        }
        
        if(answer.length() == 0){
            if(xCount[idx] > 0 && yCount[idx] > 0){
                answer.append("0");
            }
            else{
                answer.append("-1");
            }
        }
        else{
            while(idx == 0){
                if(xCount[idx] > 0 && yCount[idx] > 0){
                xCount[idx]--;
                yCount[idx]--;
                answer.append(idx);
                }
                else{
                    idx--;
                }
            }
        }
        return answer.toString();
       
    }
}