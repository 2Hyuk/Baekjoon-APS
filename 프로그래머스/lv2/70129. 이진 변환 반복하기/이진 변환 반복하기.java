class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int zeroCount = 0;
        int binaryConvertCount = 0;
        
        while(!"1".equals(s)){
            binaryConvertCount++;
            
            int n = s.length();
            s = s.replace("0", "");
            zeroCount += n - s.length();
            s = Integer.toBinaryString(s.length());
        }
     return new int[]{binaryConvertCount, zeroCount};
    }
}