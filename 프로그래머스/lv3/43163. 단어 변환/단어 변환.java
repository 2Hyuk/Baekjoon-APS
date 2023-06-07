import java.util.*;

class Solution {
    class Word{
        int count;
        String changeWord;
        
        public Word(String changeWord, int count){
            this.changeWord = changeWord;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        var q = new LinkedList<Word>();
        var visited = new boolean[words.length];
        q.offer(new Word(begin, 0));
        
        while(!q.isEmpty()){
            Word word = q.poll();
            
            if(word.changeWord.equals(target)){
                return word.count;
            }
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && isChange(word.changeWord, words[i])){
                    visited[i] = true;
                    q.offer(new Word(words[i], word.count + 1));
                }
            }
        }
        
        return 0;
    }
    
    public boolean isChange(String from, String to){
        int count = 0;
        for(int i = 0; i < from.length(); i++){
            if(from.charAt(i) != to.charAt(i))
                count++;
        }
        return count == 1 ? true : false;
    }
}