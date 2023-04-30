import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();
        
        for(String city : cities){
            String cityName = city.toLowerCase();
            int idx = list.indexOf(cityName);
            if(idx < cacheSize && idx >= 0){
                answer += 1;
            }
            else{
                answer += 5;
            }
            if(list.contains(cityName)){
                list.remove(idx);
            }
            list.addFirst(cityName);
        }
        
        return answer;
    }
}


    
    