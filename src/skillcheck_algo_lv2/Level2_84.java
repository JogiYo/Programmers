package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Programmers Level 2: Dot
public class Level2_84 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        sb.append(solution(k, d));
        System.out.print(sb);
    }

    private static long solution(int k, int d) {
        long answer = 0;

        /*
         * From the x-coordinate,
         * the number of y-coordinates less than d distance can be known.
         */
        for(int i = 0; i <= d; i += k) {
            int yMaxDist = findYMaxDist(i, d);
            // Since it also includes 0, add 1 to the value divided by k.
            answer += (yMaxDist/k) + 1;;
        }

        return answer;
    }

    /*
     * Use the Pythagorean Theorem
     * x^2 + y^2 = d^2
     * y^2 = d^2 - x^2
     */
    private static int findYMaxDist(int x, int d) {
        long xx = (long) Math.pow(x, 2);
        long dd = (long) Math.pow(d, 2);

        return (int)(Math.sqrt(dd-xx));
    }
}