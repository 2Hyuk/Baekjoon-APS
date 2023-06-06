import java.util.*;

class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    public int solution(int[][] maps) {
        int answer = -1;
        var q = new LinkedList<Location>();
        q.offer(new Location(0, 0, 1));
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        while(!q.isEmpty()){
            Location loc = q.poll();
            
            if(loc.row == n - 1 && loc.col == m - 1){
                answer = loc.block;
                break;
            }
            
            for(int i = 0; i < 4; i++){
                int nr = loc.row + dr[i];
                int nc = loc.col + dc[i];
                
                if(nr < 0 || nr >= n || nc < 0 || nc >= m || maps[nr][nc] == 0)
                    continue;
                
                if(!visited[nr][nc]){
                    q.offer(new Location(nr, nc, loc.block + 1));
                    visited[nr][nc] = true;
                }
            }
        }
        
        return answer;
    }
    
    public class Location{
        int row;
        int col;
        int block;
        
        public Location(int row, int col, int block){
            this.row = row;
            this.col = col;
            this.block = block;
        }
        
    }
}