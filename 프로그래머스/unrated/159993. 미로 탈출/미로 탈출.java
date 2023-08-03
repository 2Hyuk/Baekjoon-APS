import java.util.*;

class Solution {
    class Point{
        int row, col, time;
        public Point(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    
    public static String[][] board;
    public static boolean[][] visited;
    public static Queue<Point> q;
    public static int time, N, M;
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        board = new String[N][M];
        q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            board[i] = maps[i].split("");
        }
        
        time = -1;
        int[] leverPoint = new int[2];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if("S".equals(board[i][j])){
                    q.clear();
                    visited = new boolean[N][M];
                    q.offer(new Point(i, j, 0));
                    leverPoint = findLever();
                }
            }
        }
        
        if(leverPoint[0] != -1){
            q.clear();
            visited = new boolean[N][M];
            q.offer(new Point(leverPoint[0], leverPoint[1], 0));
            
            if(!findExit()) 
                time = -1;
        }
        
        return time;
    }
    
    public int[] findLever(){
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            if("L".equals(board[p.row][p.col])){
                time = p.time;
                return new int[]{p.row, p.col};
            }
            move(p.row, p.col, p.time);
        }
        
        return new int[]{-1, -1};
    }
    
    public boolean findExit(){
        
         while(!q.isEmpty()){
            Point p = q.poll();
            
            if("E".equals(board[p.row][p.col])){
                time += p.time;
                return true;
            }
            move(p.row, p.col, p.time);
        }
        
        return false;
    }
    
    public void move(int row, int col, int time){
        int[] dr = {0, -1, 0, 1};
        int[] dc = {-1, 0, 1, 0};
        
        for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
            
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || "X".equals(board[nr][nc]))
                    continue;
                
                visited[nr][nc] = true;
                q.offer(new Point(nr, nc, time + 1));
            }
    }
}