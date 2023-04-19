package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Programmers Level 2 : Integer pairs between two circles
// Using the properties of a circle (x^2 + y^2 = r^2)
public class Level2_100 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());

        long result = solution(r1, r2);
        sb.append(result);
        System.out.print(sb);
    }

    private static long solution(int r1, int r2) {
        long answer = 0;

        long r1pow = (long)Math.pow(r1, 2);
        long r2pow = (long)Math.pow(r2, 2);

        // y^2 = r^2 - x^2
        for(int i = 1; i <= r2; ++i) {
            /*
             * Since it is a pair of integers,
             * floor function and ceil function are used.
             */
            long y2 = (long)Math.floor(Math.sqrt(r2pow - (long)Math.pow(i,2)));
            long y1 = (long)Math.ceil(Math.sqrt(r1pow - (long)Math.pow(i,2)));

            answer += (y2 - y1 + 1);
        }

        return answer * 4;
    }
}