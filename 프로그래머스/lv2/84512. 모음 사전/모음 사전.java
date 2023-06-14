import java.util.*;

class Solution {
    public static final char[] ele = {'A', 'E', 'I', 'O', 'U'};
    public String answer;
    public boolean flag;
    public int solution(String word) {
        
        var words = new ArrayList<String>();
        answer = word;
        
        for(int i = 0; i < ele.length; i++){
            dfs(words, "" + ele[i]);
        }
        return words.size() + 1;
    }
    
    public void dfs(List<String> words, String word){
        if(flag || word.length() > 5){
            return;
        }
        
        if(word.equals(answer)){
            flag = true;
            return;
        }
        
        words.add(word);
        
        for(int i = 0; i < ele.length; i++){
            dfs(words, word + ele[i]);
        }
    }
}