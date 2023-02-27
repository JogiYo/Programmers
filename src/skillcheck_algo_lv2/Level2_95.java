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
        int answer = -1;

        int o_count = 0, x_count = 0;

        for(String str : board) {
            for(int i = 0; i < 3; ++i) {
                if(str.charAt(i) == 'O') o_count++;
                else if(str.charAt(i) == 'X') x_count++;
            }
        }

        if(o_count - x_count < 0 || o_count - x_count > 1) return 0;

        return answer;
    }
}
