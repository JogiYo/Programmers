package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Programmers Level 2 : Pseudo Cantor bitstream
public class Level2_87 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long l = Long.parseLong(st.nextToken());
        long r = Long.parseLong(st.nextToken());

        sb.append(solution(n, l, r));
        System.out.print(sb);
    }

    private static int solution(int n, long l, long r) {
        /*
         * n=0, 1
         * n=1, 11011
         * n=2, 11011 11011 00000 11011 11011
         */
        int answer = 0;

        for(long i = l; i <= r; ++i) {
            int flag = 1;
            if(i % 5 == 3) continue;

            long temp = i;

            // Check whether there is a zero or not by going up from the bottom line
            while(true) {
                if(temp % 5 == 0) temp /= 5;
                else temp = (temp / 5) + 1;

                if(temp %5 == 3) {
                    flag = 0;
                    break;
                }
                else if(temp <= 5) {
                    break;
                }
            }

            if(flag == 1) answer++;
        }

        return answer;
    }
}