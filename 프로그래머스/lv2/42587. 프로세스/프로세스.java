import java.util.*;

class Solution {
    public class Process{
        public int index;
        public int order;
        
        public Process(int index, int order){
            this.index = index;
            this.order = order;
        }
    }
    
    public static int[] arr;
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Process> processQueue = new LinkedList<>();
        arr = new int[10];
        for(int i = 0; i < priorities.length; i++){
            processQueue.offer(new Process(i, priorities[i]));
            arr[priorities[i]]++;
        }
        
        while(!processQueue.isEmpty()){
            Process p = processQueue.poll();
            int priorityValue = findPriority();
            
            if(p.order < priorityValue){
                processQueue.offer(p);
                continue;
            }
            arr[priorityValue]--;
            
            if(p.index == location){
                break;
            }
            
            answer++;
        }
        return answer;
    }
    
    public int findPriority(){
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] > 0){
                return i;
            }
        }
        return -1;
    }
}