import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int BASIC_TIME = fees[0];
        int BASIC_FEE = fees[1];
        int UNIT_TIME = fees[2];
        int UNIT_FEE= fees[3];
        
        Map<String, Integer> totalMinMap = new HashMap<>();
        Map<String, Integer> timeMap = new HashMap<>();
        
        for(String record : records){
            String[] s = record.split(" ");
            String strHour = s[0].split(":")[0];
            String strMin = s[0].split(":")[1];
            String carNum = s[1];
            String state = s[2];
           
            // 들어오고 나가는 시간을 분으로 계산
            int min = Integer.parseInt(strHour) * 60 + Integer.parseInt(strMin);
            
            // 처음 들어오는 차량이라면 등록
            if(!totalMinMap.containsKey(carNum)){
                totalMinMap.put(carNum, 0);
            }
            
            // 들어오는 차량이면 시간찍기
            if("IN".equals(state)){
                timeMap.put(carNum, min);
            }
            // 나가는 차량이면 시간계산
            else{
                int parkingMin = min - timeMap.get(carNum);
                
                totalMinMap.put(carNum, totalMinMap.get(carNum) + parkingMin);
                timeMap.remove(carNum);
            }
        }
        
        // 들어왔는데 출차하지 않았다면 23:59에 강제 출차
        for(String carNum : timeMap.keySet()){
            int parkingMin = 1439 - timeMap.get(carNum);
            totalMinMap.put(carNum, totalMinMap.get(carNum) + parkingMin);
        }
        
        int[] carNumArr = new int[10000];
        int[] result = new int[totalMinMap.size()];
        Arrays.fill(carNumArr, -1);
        
        // 요금 정산
        for(String carNum : totalMinMap.keySet()){
            int totalMin = totalMinMap.get(carNum);
            int fee = BASIC_FEE;
            if(totalMin > BASIC_TIME){
                fee = (int)(Math.ceil((float)(totalMin - BASIC_TIME) / UNIT_TIME)) * UNIT_FEE + BASIC_FEE;
            }
            carNumArr[Integer.parseInt(carNum)] = fee;
        }
        
        // 결과 배열 생성
        int idx = 0;
        for(int i = 0; i < 10000; i++){
            if(carNumArr[i] != -1){
                result[idx] = carNumArr[i];
                idx++;
            }
        }
        
        
        
        return result;
    }
}