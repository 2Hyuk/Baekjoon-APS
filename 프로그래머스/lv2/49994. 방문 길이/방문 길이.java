import java.util.*;

class Solution {
    int answer;
    Set<String> path;
    int currX;
    int currY;
    
    public int solution(String dirs) {
        path = new HashSet<>();
        currX = 5;
        currY = 5;
        answer = 0;
        
        for(int i = 0; i < dirs.length(); i++){
            switch(dirs.charAt(i)){
                case 'L' -> moveLeft();
                case 'U' -> moveUp();
                case 'R' -> moveRight();
                case 'D' -> moveDown();
            }
        }
        
        return answer;
    }
    
    public void moveLeft(){
        if(currX - 1 < 0)
            return;
        
        int nextX = currX - 1;
        String path1 = currX + " " + currY + " " + nextX + " " + currY;
        String path2 = nextX + " " + currY + " " + currX + " " + currY;
        
        calcVisitedPath(path1, path2);
        currX = nextX;
    }
    
    public void moveRight(){
        if(currX + 1 > 10)
            return;
        
        int nextX = currX + 1;
        String path1 = currX + " " + currY + " " + nextX + " " + currY;
        String path2 = nextX + " " + currY + " " + currX + " " + currY;
        
        calcVisitedPath(path1, path2);
        currX = nextX;
    }
    
    public void moveUp(){
        if(currY + 1 > 10)
            return;
        
        int nextY = currY + 1;
        String path1 = currX + " " + currY + " " + currX + " " + nextY;
        String path2 = currX + " " + nextY + " " + currX + " " + currY;
        
        calcVisitedPath(path1, path2);
        currY = nextY;
    }
    
    public void moveDown(){
        if(currY - 1 < 0)
            return;
        
        int nextY = currY - 1;
        String path1 = currX + " " + currY + " " + currX + " " + nextY;
        String path2 = currX + " " + nextY + " " + currX + " " + currY;
        
        calcVisitedPath(path1, path2);
        currY = nextY;
    }
    
    public void calcVisitedPath(String path1, String path2){

        if(!(path.contains(path1) || path.contains(path2))){
            answer++;
            path.add(path1);
            path.add(path2);
        }
    }
    
    
}