package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Programmers Level 2 : Seesaw partner
// use Binary Search
public class Level2_93 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] weights = new int[st.countTokens()];
        for(int i = 0; i < weights.length; ++i) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        long result = solution(weights);
        sb.append(result);

        System.out.print(sb);
    }

    private static long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);

        int count = 0;
        for(int i = 0; i < weights.length - 1; ++i) {
            // eliminate duplicates.
            if(i != 0 && weights[i] == weights[i-1]) {
                count--;
                answer += count;
                continue;
            }
            // find the upper limit
            int j = findUpper(weights, weights[i], i+1);
            count = 0;
            while(j > i) {
                // a : b = c : d -> a x d = c x b
                if(weights[i] == weights[j]
                        || weights[i] * 3 == weights[j] * 2
                        || weights[i] * 4 == weights[j] * 2
                        || weights[i] * 4 == weights[j] * 3
                    ) count++;
                j--;
            }
            answer += count;
        }

        return answer;
    }

    private static int findUpper(int[] weights, int weight, int i) {
        int left = i;
        int right = weights.length - 1;
        while(left > right) {
            int mid = left + (right - left)/2;

            /* Given the given ratio,
             * if the weight at mid is greater than twice the current weight,
             * there is no need to seek to the right.
             */
            if(weights[mid] > weight * 2) return mid;
            else left = mid + 1;
        }

        return left;
    }
}