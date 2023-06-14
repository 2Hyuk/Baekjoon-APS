class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skillTree : skill_trees){
            int order = 0;
            boolean flag = true;
            
            for(int i = 0; i < skillTree.length(); i++){
                char ch = skillTree.charAt(i);
                int idx = skill.indexOf(ch);
                
                if(idx != -1){
                    if(order != idx){
                        flag = false;
                        break;
                    }
                    order++;
                }
            }
            if(flag){
                answer++;
            }
        }
        return answer;
    }
}