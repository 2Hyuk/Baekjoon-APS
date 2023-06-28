import java.util.*;

class Solution {
    static boolean[] visited;
    static String[] numArr;
    static Set<Integer> answer;
    public int solution(String numbers) {
        numArr = numbers.split("");
        visited = new boolean[numArr.length];
        answer = new HashSet<>();
        
        dfs(0, "");
        return answer.size();
    }
    
    public void dfs(int cnt, String number){
        if(cnt > 0 && cnt <= numArr.length){
            int num = Integer.parseInt(number);
            if(isPrime(num) && num > 1){
                answer.add(num);
            }
        }
        
        for(int i = 0; i < numArr.length; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            dfs(cnt + 1, number + numArr[i]);
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}