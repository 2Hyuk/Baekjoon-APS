import java.util.*;

class Solution {
    
    /*
        민호를 루트로하는 linkedList
    */
    class Node{
        String name, referral;
        int profit;
        
        public Node(String enroll, String referral, int profit){
            this.name = name;
            this.referral = referral;
            this.profit = profit;
        }

    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // LinkedList<Node> group = new LinkedList<>();
        Map<String, Node> groupMap = new HashMap<>();
        // group.add(new Node("-", "-", "-", 0));     
        for(int i = 0; i < enroll.length; i++){
            String name = enroll[i];
            String ref = referral[i];
            Node node = new Node(name, ref, 0);
            groupMap.put(name, node);
        }
        
        // for(String key : groupMap.keySet()){
        //     System.out.println(key + " " + groupMap.get(key).referral);
        // }
        
        for(int i = 0; i < seller.length; i++){
            String name = seller[i];
            int price = amount[i] * 100;
            
            while(true){
                int parentProfit = price / 10;
                int myProfit = price - parentProfit;
                
                Node node = groupMap.get(name);
                node.profit += myProfit;
                groupMap.put(name, node);
                
                name = node.referral;
                price = parentProfit;
                
                if("-".equals(name) || price < 1){
                    break;
                }
            }
            
        }
        
        int[] answer = new int[enroll.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = groupMap.get(enroll[i]).profit;
        }
        
        return answer;
    }
}