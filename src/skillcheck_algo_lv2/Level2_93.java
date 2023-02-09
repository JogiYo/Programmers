package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
        int len = weights.length;
        Arrays.sort(weights);


        return answer;
    }
}
