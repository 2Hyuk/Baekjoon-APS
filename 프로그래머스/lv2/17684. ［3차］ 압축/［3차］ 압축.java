import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        String[] msgArr = msg.split(""); // 문장을 배열로 쪼개놓음
        
        int dictIdx = 1;
        for(int i = (int)'A'; i <= (int)'Z'; i++){
            dictionary.put(String.valueOf((char)i), dictIdx++);
        }
        
        List<Integer> indexList = new ArrayList<>(); // 인덱스 리스트
        int arrIdx = 0;
        StringBuilder sb = new StringBuilder();
        
        while(arrIdx < msgArr.length){
            sb.append(msgArr[arrIdx]);
            // 사전에 단어가 등록되어있으면 다음 배열로 넘어가서 진행
            if(dictionary.containsKey(sb.toString())){
                arrIdx++;
                if(arrIdx == msgArr.length){
                    indexList.add(dictionary.get(sb.toString()));
                }
            }
            // 사전에 등록되어있지 않다면 등록, 인덱스리스트에 추가, 문자열 초기화를 진행
            else{
                dictionary.put(sb.toString(), dictIdx++);
                sb.setLength(sb.length() - 1);
                indexList.add(dictionary.get(sb.toString()));
                sb.setLength(0);
            }
        }
        // 배열로 출력
        return indexList.stream().mapToInt(Integer::intValue).toArray();
    }
}