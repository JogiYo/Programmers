package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Level2_95 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] board = new String[3];
        for(int i = 0; i < 3; ++i) {
            board[i] = br.readLine();
        }

        sb.append(solution(board));
        System.out.print(sb);
    }

    private static int solution(String[] board) {
        int o_count = 0, x_count = 0;

        for(String str : board) {
            for(int i = 0; i < 3; ++i) {
                if(str.charAt(i) == 'O') o_count++;
                else if(str.charAt(i) == 'X') x_count++;
            }
        }
        /*
         * If there are more O than X, there must be only one more,
         * and the number of X must equal the number of O.
         */
        if(o_count - x_count < 0 || o_count - x_count > 1) return 0;

        // Is the number of X suitable when O is made in one line?
        if(o_count >= 3) {
            if(matchCheck(board, 'O')) {
                if(o_count - x_count == 1) return 1;
                else return 0;
            }
        }

        // Is the number of O suitable when X is made in one line?
        if(x_count >= 3) {
            if(matchCheck(board, 'X')) {
                if(o_count - x_count == 0) return 1;
                else return 0;
            }
        }

        return 1;
    }

    private static boolean matchCheck(String[] board, char ch) {
        // horizontal check
        for(int i = 0; i < 3; ++i) {
            boolean flag = true;
            for(int j = 0; j < 3; ++j) {
                if(board[i].charAt(j) != ch) {
                    flag = false;
                    break;
                }
            }

            if(flag) return true;
        }

        // vertical check
        for(int i = 0; i < 3; ++i) {
            boolean flag = true;
            for(int j = 0; j < 3; ++j) {
                if(board[j].charAt(i) != ch) {
                    flag = false;
                    break;
                }
            }

            if(flag) return true;
        }

        // diagonal check
        if(board[0].charAt(0) == ch && board[1].charAt(1) == ch && board[2].charAt(2) == ch) return true;
        if(board[0].charAt(2) == ch && board[1].charAt(1) == ch && board[2].charAt(0) == ch) return true;

        return false;
    }
}
