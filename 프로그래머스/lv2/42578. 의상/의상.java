import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] str : clothes){
            if(map.containsKey(str[1])){
                map.put(str[1], map.get(str[1]) + 1);
            }
            else{
                map.put(str[1], 1);
            }
        }
        List<Integer> list = new ArrayList<>(map.values());
        int answer = 1;
        for(int i = 0; i < list.size(); i++){
            answer *= list.get(i) + 1;
        }
        return answer - 1;
    }
    
}