import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution {
    static int answer;
    static boolean[] check;
    static String[] selArr;
    static Set<String> set;
    public int solution(String[] user_id, String[] banned_id) {
        List<String>[] list = new ArrayList[banned_id.length];
        
        for(int i = 0; i < list.length; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < banned_id.length; i++){
            for(int j = 0; j < user_id.length; j++){
                if(compareId(banned_id[i], user_id[j])){
                    list[i].add(user_id[j]);
                }
            }
        }
        
        System.out.println(Arrays.toString(list));
        answer = 0;
        check = new boolean[user_id.length];
        selArr = new String[list.length];
        set = new HashSet<>();
        
        combination(0, list, user_id);
        return answer;
    }

    public void combination(int idx, List<String>[] list, String[] user_id){
        if(idx == list.length){
            String result = "";
            String[] tmp = selArr.clone();
            Arrays.sort(tmp);
            for(int i = 0; i < tmp.length; i++){
                result += tmp[i];
            }
            
            if(!set.contains(result)){
                answer++;
                set.add(result);
            }
            return;
        }
        

            for(int j = 0; j < list[idx].size(); j++){
                if(checkId(user_id, list[idx].get(j))){
                    selArr[idx] = list[idx].get(j);
                    combination(idx + 1, list, user_id);
                    unCheckId(user_id, list[idx].get(j));
                }
            }
        
    }
    
    public boolean checkId(String[] user_id, String id){
        for(int i = 0; i < user_id.length; i++){
            if(user_id[i].equals(id)  && !check[i]){
                    check[i] = true;
                    return true;
            }
        }
        return false;
    }
    
    public void unCheckId(String[] user_id, String id){
        for(int i = 0; i < user_id.length; i++){
            if(user_id[i].equals(id)){
                check[i] = false;
                break;
            }
        }
    }
    
    public boolean compareId(String banId, String userId){
        if(banId.length() != userId.length())
            return false;
        
        for(int i = 0; i < banId.length(); i++){
            char banChar = banId.charAt(i);
            char userChar = userId.charAt(i);
            
            if(banChar == '*')
                continue;
            
            if(banChar != userChar)
                return false;
        }
        return true;
    }
}