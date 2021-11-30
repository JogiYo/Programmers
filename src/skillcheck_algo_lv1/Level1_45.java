package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Finds a number whose remainder is 1.
public class Level1_45 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String n = br.readLine();

        sb.append(solution(Integer.parseInt(n)) + "");
        System.out.print(sb);
    }

    private static int solution(int n) {
        // Find a number that is divisible by n-1.
        for(int i = 2; i <= n-1; ++i) {
            if((n-1) % i == 0) {
                return i;
            }
        }

        return -1;
    }
}
