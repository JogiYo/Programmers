package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// Programmers Level 2 : Divide number cards
// use Set
public class Level2_80 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arrayA = new int[st.countTokens()];

        for(int i = 0; i < arrayA.length; ++i) {
            arrayA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int[] arrayB = new int[st.countTokens()];

        for(int i = 0; i < arrayB.length; ++i) {
            arrayB[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(solution(arrayA, arrayB));
        System.out.print(sb);
    }

    private static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        // Only numbers less than or equal to the minimum value of each array can satisfy the condition.
        int minA = Arrays.stream(arrayA).min().getAsInt();
        int minB = Arrays.stream(arrayB).min().getAsInt();

        Set<Integer> set = new HashSet<>();
        for(int i = 2; i <= minA; ++i) {
            if(minA % i == 0) set.add(i);
        }

        for(int i = 2; i <= minB; ++i) {
            if(minB % i == 0) set.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        for (Integer num : list) {
            // If only the condition of ChulSu is satisfied
            boolean flag = true;
            for(int i = 0; i < arrayA.length; ++i) {
                if(arrayA[i] % num != 0 || arrayB[i] % num == 0) {
                    flag = false;
                    break;
                }
            }
            // If the condition is satisfied, the next number is checked.If the condition is satisfied,
            // the next number is checked.
            if(flag) {
                answer = Math.max(answer, num);
                continue;
            }

            // // If only the condition of YoungHee is satisfied
            flag = true;
            for(int i = 0; i < arrayB.length; ++i) {
                if(arrayB[i] % num != 0 || arrayA[i] % num == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer = Math.max(answer, num);
        }

        return answer;
    }
}