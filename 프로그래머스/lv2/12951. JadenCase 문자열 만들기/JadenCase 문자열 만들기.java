import java.util.*;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        String[] arr = s.split("");
        StringBuilder sb = new StringBuilder();
        char ch = arr[0].charAt(0);
        if(ch >= 'a' && ch <= 'z'){
            ch = (char)(ch + 'A' - 'a');
        }
            sb.append(ch);
        
        for(int i = 1; i < arr.length; i++){
            ch = arr[i].charAt(0);
            if(ch >= 'a' && ch <= 'z' && arr[i - 1].equals(" ")){
                ch = (char)(ch + 'A' - 'a');
            }
            sb.append(ch);
        }
       
        return sb.toString();
    }
}