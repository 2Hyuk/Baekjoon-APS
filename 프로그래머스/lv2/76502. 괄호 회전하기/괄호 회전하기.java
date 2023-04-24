import java.util.*;

class Solution {
    public int solution(String s) {
        
        int answer = 0;
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(0);
            s = s.substring(1) + ch;
            if(isTrue(s)){
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isTrue(String s){
        Stack<Character> stack = new Stack<>();
       
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty())
                    return false;
                
                char prev = stack.peek();
                if((prev == '(' && ch == ')') || (prev == '{' && ch == '}') || (prev == '[' && ch == ']')){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        
        if(stack.isEmpty())
                return true;
            
        return false;
    }
}
