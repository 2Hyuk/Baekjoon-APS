import java.util.*;

class Solution {
    class Road{
        int row, col, price, direction;
        
        public Road(int row, int col, int price, int direction){
            this.row = row;
            this.col = col;
            this.price = price;
            this.direction = direction;
        }
    }
    public static int N, minCost;
    public static final int STRAIGHT_PRICE = 100;
    public static final int CORNER_PRICE = 500;
    public static int[][][] visited;
    // direction -> left : 0, up : 1, right : 2, down : 3
    public static int[] dr = {0, -1, 0, 1};
    public static int[] dc = {-1, 0, 1, 0};
    public int solution(int[][] board) {
        minCost = Integer.MAX_VALUE;
        N = board.length;
        
        visited = makeArr(N);
        dfs(board, new Road(0, 0, 0, 2));
        
        visited = makeArr(N);
        dfs(board, new Road(0, 0, 0, 3));
        
        return minCost;
    }
    
    public void dfs(int[][] board, Road road){
        
        if(road.price >= minCost) return;
        
        if(road.row == N - 1 && road.col == N - 1){
            minCost = Math.min(minCost, road.price);
            return;
        }

        
         for(int i = 0; i < 4; i++){
            int nr = road.row + dr[i];
            int nc = road.col + dc[i];
            
            // 진행하려는 방향이 같지 않으면서, 둘다 홀수 또는 짝수라면 180도 이므로 갈 수 없다
            if(road.direction != i && road.direction % 2 == i % 2) continue;
            int price = roadPrice(road.direction, i);
            
            if(nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == 1) continue;
             
            if(road.price + price <= visited[nr][nc][i]){
                visited[nr][nc][i] = road.price + price;
                dfs(board, new Road(nr, nc, road.price + price, i));
             }
        } 
    }
    
    public int roadPrice(int currDir, int nextDir){
        if(currDir == nextDir) return STRAIGHT_PRICE;
        else return CORNER_PRICE + STRAIGHT_PRICE;
    }
    
    public int[][][] makeArr(int n){
        int[][][] arr = new int[n][n][4];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < 4; k++){
                    arr[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        return arr;
    }
}