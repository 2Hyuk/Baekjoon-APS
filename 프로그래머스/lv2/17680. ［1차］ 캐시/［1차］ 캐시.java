import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if(cacheSize == 0)
            return cities.length * 5;
        int answer = 0;
        
        LinkedList<String> list = new LinkedList<>();
        
        for(String city : cities){
            String cityName = city.toLowerCase();
            int idx = list.indexOf(cityName);
          
            if(idx >= 0){
                answer += 1;
                list.remove(idx);
            }
            else{
                answer += 5;
                if(list.size() >= cacheSize){
                    list.remove(0);
                }
            }
            list.offer(cityName);
        }
        return answer;
    }
}


    
    