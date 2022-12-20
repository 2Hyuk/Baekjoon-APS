import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    
    public int[] solution(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        s = s.substring(1, s.length() - 1);
        String[] tupleArr = s.split(",");

        for(int i = 0; i < tupleArr.length; i++){
            String tuple = tupleArr[i];
            String ele = "";
            for(int j = 0; j < tuple.length(); j++){
                if(tuple.charAt(j) >= '0' && tuple.charAt(j) <= '9'){
                    ele += tuple.charAt(j);
                }
            }
            int key = Integer.parseInt(ele);
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }
            else{
                map.put(key, 1);
            }
            
        }
        
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return map.get(o2) - map.get(o1);
			}
		});
       
        int[] answer = new int[keyList.size()];
        for(int i = 0; i < keyList.size(); i++){
            answer[i] = keyList.get(i);
        }
        
        return answer;
    }
}