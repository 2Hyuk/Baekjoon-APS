import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] board = new String[N][N];
        for(int i = 0; i < N; i++){
            board[i] = br.readLine().split("");
           // System.out.println(Arrays.toString(board[i]));
        }
        int[] dr = {0, -1, 0, 1, 0};
        int[] dc = {-1, 0, 1, 0, 0};
        int maxCount = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < 5; k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= N)
                        continue;

                    String tmp = board[i][j];
                    board[i][j] = board[nr][nc];
                    board[nr][nc] = tmp;

                    int count = continuous(i, j, board);
                    maxCount = Math.max(maxCount, count);

                    board[nr][nc] = board[i][j];
                    board[i][j] = tmp;
                }
            }
        }
        System.out.println(maxCount);
    }

    public static int continuous(int row, int col, String[][] board){

        int rowCount = 1;
        int maxRowCount = 0;
        int colCount = 1;
        int maxColCount = 0;

        for(int i = 1; i < board.length; i++){
            if(board[row][i].equals(board[row][i-1])){
                rowCount++;
            }
            else{
                maxRowCount = Math.max(maxRowCount, rowCount);
                rowCount = 1;
            }

            if(board[i][col].equals(board[i-1][col])){
                colCount++;
            }
            else{
                maxColCount = Math.max(maxColCount, colCount);
                colCount = 1;
            }
        }
        maxRowCount = Math.max(maxRowCount, rowCount);
        maxColCount = Math.max(maxColCount, colCount);

        return Math.max(maxRowCount, maxColCount);
    }
}
