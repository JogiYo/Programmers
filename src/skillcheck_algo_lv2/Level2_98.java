package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Programmers Level 2 : Sum of consecutive subsequences
// use Accumulated sum & Two Pointer
public class Level2_98 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int[] sequence = new int[st.countTokens()];
        for(int i = 0; i < sequence.length; ++i) sequence[i] = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        int[] result = solution(sequence, k);
        sb.append(result[0]).append(" ").append(result[1]);
        System.out.print(sb);
    }

    private static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int maxLen = Integer.MAX_VALUE;

        // use Accumulated sum
        int[] accumulatedSum = new int[sequence.length+1];
        for(int i = 0; i < sequence.length; ++i) accumulatedSum[i+1] = accumulatedSum[i] + sequence[i];

        // start two pointer
        /*
         * If the current sum is less than K, right is raised by +1.
         * If not, increment left by +1.
         */
        int left = 0, right = 0;
        while(left <= right) {
            if(left >= accumulatedSum.length || right >= accumulatedSum.length) break;
            int sum = accumulatedSum[right] - accumulatedSum[left];

            /*
             * When an answer sequence is found,
             * the length of the sequence is checked and converted into the sequence with the smallest length.
             */
            if(sum == k) {
                int curLen = right - left;
                if(maxLen > curLen) {
                    answer[0] = left;
                    answer[1] = right-1;
                    maxLen = curLen;
                }
            }

            if(sum < k)  right++;
            else left++;
        }

        return answer;
    }
}