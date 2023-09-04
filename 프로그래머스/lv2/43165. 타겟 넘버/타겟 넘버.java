class Solution {
    public static int answer;
    public static int[] numberArr;
    public static int targetNum;
    public int solution(int[] numbers, int target) {
        answer = 0;
        numberArr = numbers;
        targetNum = target;
        
        dfs(0, 0);
        
        return answer;
    }
    
    public void dfs(int idx, int sum){
        if(idx == numberArr.length){
            if(sum == targetNum){
                answer++;
            }
            return;
        }
        
        dfs(idx + 1, sum + numberArr[idx]);
        dfs(idx + 1, sum - numberArr[idx]);
    }
}