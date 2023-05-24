class Solution {
    public String solution(int n, int t, int m, int p) {
        String word = "";
        int maxSize = t * m;
        int idx = 0;
        while(word.length() < maxSize){
            String s = Integer.toString(idx, n);
            word += s.toUpperCase();
            idx++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = p - 1; i < maxSize; i += m){
            sb.append(word.charAt(i));
        }
        
        return sb.toString();
    }
}