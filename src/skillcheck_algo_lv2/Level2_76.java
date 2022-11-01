package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

// Level 2 : Number of sums of consecutive subsequences
// use DP & Set
public class Level2_76 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] elements = new int[st.countTokens()];

        for(int i = 0; i < elements.length; ++i) {
            elements[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(solution(elements));
        System.out.print(sb);
    }

    private static int solution(int[] elements) {
        int[] dp = new int[elements.length];
        // Since it may start from the last element, the existing array is copied once more.
        int[] copy = new int[elements.length*2];

        System.arraycopy(elements, 0, copy, 0, elements.length);
        System.arraycopy(elements, 0, copy, elements.length, elements.length);

        // Set is used because there should be no duplicate values.
        TreeSet<Integer> ts = new TreeSet<>();

        /*
         * You can get the value through dp.
         * [7, 9, 1, 1, 4] => [7, 9, 1, 1, 4, 7, 9, 1, 1, 4]
         * dp = [0, 0, 0, 0, 0]
         * dp = [0+7, 0+9, 0+1, 0+1, 0+4] = [7, 9, 1, 1, 4], i = 0
         * dp = [7+9, 9+1, 1+1, 1+4, 4+7] = [16, 10, 2, 5, 11] , 1 = 1
         * ...
         */
        for(int i = 0; i < elements.length; ++i) {
            for(int j = 0; j < elements.length; ++j) {
                dp[j] = dp[j] + copy[j + i];
                ts.add(dp[j]);
            }
        }
        // return the number of sums
        return ts.size();
    }
}