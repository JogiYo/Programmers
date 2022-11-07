package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Programmers Level 1 : Food fight contest
public class Level1_54 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] food = new int[st.countTokens()];

        for(int i = 0; i < food.length; ++i) {
            food[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(solution(food));
        System.out.print(sb);
    }

    private static String solution(int[] food) {
        String answer;

        StringBuilder str = new StringBuilder();
        StringBuilder reverse_str = new StringBuilder();

        for(int i = 1; i < food.length; ++i) {
            int k = food[i] / 2;
            while(k > 0) {
                str.append(i);
                reverse_str.insert(0, i);
                k--;
            }
        }

        answer = str + "0" + reverse_str;
        return answer;
    }
}