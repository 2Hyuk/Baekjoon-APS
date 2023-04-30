class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int arr1Row = arr1.length;
        int arr1Col = arr1[0].length;
        int arr2Row = arr2.length;
        int arr2Col = arr2[0].length;
        int[][] answer = new int[arr1Row][arr2Col];
        
        for(int i = 0; i < arr1Row; i++){
            for(int j = 0; j < arr2Col; j++){
                int sum = 0;
                for(int k = 0; k < arr2Row; k++){
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}