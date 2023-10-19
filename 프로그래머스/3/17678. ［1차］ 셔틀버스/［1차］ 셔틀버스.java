import java.util.*;

class Solution {
    // 타임테이블 배열을 시간순 정렬
    // 버스 도착시간에 차례대로 빼간다.
    // 근데 다음 도착 버스가 없다 1. 자리가 남는다면 버스 도착시간이 정답, 자리가 남지 않는다면 마지막에 탄사람보다 1분일찍
    // 버스가 있다면 계속 진행
    public String solution(int n, int t, int m, String[] timetable) {
        List<Integer> timeList = new ArrayList<>();
        int busTime = 540;
        int conTime = 0;
    
        for(int i = 0; i < timetable.length; i++){
            String[] time = timetable[i].split(":");
            int min = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            timeList.add(min);
        }
        Collections.sort(timeList);
        
        int idx = 0;
        for(int i = 1; i <= n; i++){
            int sits = m;
            // 버스가 왔을 때 순서대로 탑승
            while(sits > 0 && idx < timeList.size()){
                if(timeList.get(idx) <= busTime){
                    idx++;
                    sits--;
                }
                else{
                    break;
                }
            }
            
            if(i == n){
                if(sits > 0){
                    conTime = busTime;
                }
                else{
                    conTime = timeList.get(idx - 1) - 1;
                }
            }
            busTime += t;
        }
        
        int hour = conTime / 60;
        int min = conTime % 60;
        String conHour = hour < 10 ? "0" + Integer.toString(hour) : Integer.toString(hour);
        String conMin = min < 10 ? "0" + Integer.toString(min) : Integer.toString(min);
        return conHour + ":" + conMin;
    }
}