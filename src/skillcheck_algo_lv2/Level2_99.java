package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// Programmers Level 2 : Ricochet Robot
// use BFS
public class Level2_99 {
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] board = new String[n];
        for(int i = 0; i < n; ++i) board[i] = br.readLine();

        int result = solution(board);
        sb.append(result);
        System.out.print(sb);
    }

    private static int solution(String[] board) {
        char[][] newBoard = new char[board.length][board[0].length()];
        int sRow = -1;
        int sCol = -1;

        // Create a new array of type char for searching.
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length(); ++j) {
                if(board[i].charAt(j) == 'R') {
                    sRow = i;
                    sCol = j;
                    newBoard[i][j] = '.';
                }
                else {
                    newBoard[i][j] = board[i].charAt(j);
                }
            }
        }

        // Calculate the shortest distance through BFS.
        Queue<int[]> queue = new LinkedList<>();
        /*
         * If you visit the same coordinates, an infinite loop will occur,
         * so visits are recorded.
         */
        boolean[][] visited = new boolean[newBoard.length][newBoard[0].length];
        queue.offer(new int[] {sRow, sCol, 0});
        visited[sRow][sCol] = true;

        // BFS
        while(!queue.isEmpty()) {
            int[] curPos = queue.poll();

            /*
             * In searching up, down, left, and right,
             * you have to go all the way until you meet D or the end point.
             */
            for(int i = 0; i < 4; ++i) {
                int row = curPos[0];
                int col = curPos[1];
                int count = curPos[2];

                boolean flag = true;
                while(flag) {
                    row += dRow[i];
                    col += dCol[i];
                    // If 'D' is encountered in the range
                    if(row >= 0 && col >= 0 && row < newBoard.length && col < newBoard[0].length) {
                        if(newBoard[row][col] == 'D') {
                            row -= dRow[i];
                            col -= dCol[i];
                            flag = false;
                        }
                    }
                    // out of range
                    else {
                        row -= dRow[i];
                        col -= dCol[i];
                        flag = false;
                    }
                }

                if(!visited[row][col]) {
                    if(newBoard[row][col] == 'G') {
                        return count+1;
                    }
                    else {
                        visited[row][col] = true;
                        queue.offer(new int[] {row, col, count+1});
                    }
                }
            }
        }

        return -1;
    }
}