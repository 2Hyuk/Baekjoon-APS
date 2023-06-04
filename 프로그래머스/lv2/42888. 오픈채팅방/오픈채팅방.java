import java.util.*;

class Solution {
    public static Map<String, String> user;
    public static List<String[]> messages;
    public String[] solution(String[] record) {
        user = new HashMap<>();
        messages = new ArrayList<>();
                
        for(String s : record){
            String[] data = s.split(" ");
            String behavior = data[0];
            String uid = data[1];
            
            switch(behavior){
                    case "Enter" -> enterTalk(uid, data[2]);
                    case "Leave" -> leaveTalk(uid);
                    case "Change" -> changeNickname(uid, data[2]);
            }
        }
        
        String[] answer = new String[messages.size()];
        for(int i = 0; i < messages.size(); i++){
            String uid = messages.get(i)[0];
            String message = messages.get(i)[1];
            String nickname = user.get(uid);
            answer[i] = nickname + message;
        }
        
        return answer;
    }
    
    public void enterTalk(String uid, String nickname){
        user.put(uid, nickname);
        messages.add(new String[]{uid, "님이 들어왔습니다."});
    }
    
    public void leaveTalk(String uid){
        messages.add(new String[]{uid, "님이 나갔습니다."});
    }
    
    public void changeNickname(String uid, String nickname){
        user.put(uid, nickname);
    }
}