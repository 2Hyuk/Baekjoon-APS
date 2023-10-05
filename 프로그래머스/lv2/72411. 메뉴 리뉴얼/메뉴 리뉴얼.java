import java.util.*;

class Solution {
    class CourseMenu implements Comparable<CourseMenu>{
        String menu;
        int length;
        int count;
        
        public CourseMenu(String menu, int length, int count){
            this.menu = menu;
            this.length = length;
            this.count = count;
        }
        
        @Override
        public int compareTo(CourseMenu cm){
            if(this.length == cm.length){
                if(cm.count == this.count){
                    return this.menu.compareTo(cm.menu);
                }
                return cm.count - this.count;
            }
            return this.length - cm.length;
        }
    }
    
    public static Map<String, CourseMenu> menuMap;
    public String[] solution(String[] orders, int[] course) {
        menuMap = new HashMap<>();
        PriorityQueue<CourseMenu> pq = new PriorityQueue<>();
        List<String> courseList = new ArrayList<>();
        
        for(String str : orders){
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            for(int i : course){
                 findCourse(chArr, "", 0, 0, i);
            }
        }
        
        for(Map.Entry<String, CourseMenu> entry : menuMap.entrySet()){
            pq.offer(entry.getValue());
        }
        
        List<String> list = new ArrayList<>();
        int length = 0;
        int count = 0;
        while(!pq.isEmpty()){
            CourseMenu cm = pq.poll();
             System.out.println(cm.menu + " " + cm.count);
            if(cm.count > 1 && cm.length > length){
                length = cm.length;
                count = cm.count;
                list.add(cm.menu);
            }
            else if(cm.count > 1 && cm.length == length && cm.count == count){
                list.add(cm.menu);
            }
        }
        
        Collections.sort(list);
        
        
        return list.toArray(new String[0]);
    }
    
    public void findCourse(char[] chArr, String combi, int idx, int cnt, int courseLength){
        if(courseLength == cnt){
            CourseMenu cm = new CourseMenu(combi, cnt, 1);
            if(menuMap.containsKey(combi)){
                cm.count = menuMap.get(combi).count + 1;
            }
            menuMap.put(combi, cm);
            return;
        }
        
        for(int i = idx; i < chArr.length; i++){
            findCourse(chArr, combi + Character.toString(chArr[i]), i + 1, cnt + 1, courseLength);
        }
    }
}