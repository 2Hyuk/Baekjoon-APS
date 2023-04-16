class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int row = 0;
        int col = 0;
        
        for(int i = 3; i * i <= total; i++){
            if(total % i == 0){
                int j = total / i;
                if(yellow == (j - 2) * (i - 2)){
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        return new int[]{col, row};
    }
}