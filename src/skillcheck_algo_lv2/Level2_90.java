package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// Programmers Level 2 : Big number behind
// use Stack
public class Level2_90 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[st.countTokens()];
        
        for(int i = 0; i < numbers.length; ++i) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(numbers);
        sb.append(result[0]);
        for(int i = 1; i < result.length; ++i) {
            sb.append(" ").append(result[i]);
        }

        System.out.print(sb);
    }

    private static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        // A stack stores indexes.
        Stack<Integer> stk = new Stack<>();

        /*
         * If the number at the current index is greater than the peek value on the stack,
         * it is the larger number located.
         */
        for(int i = 0; i < answer.length; ++i) {
            while(!stk.isEmpty() && numbers[i] > numbers[stk.peek()]) {
                answer[stk.pop()] = numbers[i];
            }

            stk.push(i);
        }

        /*
         * As long as there are still indices on the stack,
         * there is no number greater than them.
         */
        while(!stk.isEmpty()) {
            answer[stk.pop()] = -1;
        }

        return answer;
    }
}