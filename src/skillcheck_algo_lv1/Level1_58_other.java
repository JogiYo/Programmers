package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Split string
// more effective solution
public class Level1_58_other {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        sb.append(solution(str));
        System.out.print(sb);
    }

    private static int solution(String s) {
        char prev = 'A';
        int x_count = 0, other_count = 0, answer = 0;

        for(char c : s.toCharArray()) {
            // when the first letter
            if(prev == 'A') {
                prev = c;
                x_count++;
                answer++;
            }
            // When it is a letter like x
            else if(prev == c) x_count++;
            else other_count++;

            // Split strings when number of characters are equal
            if(x_count == other_count) {
                prev = 'A';
                x_count = 0;
                other_count = 0;
            }
        }

        return answer;
    }
}