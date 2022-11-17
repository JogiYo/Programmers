package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Programmers Level 1 : fruit salesman
// use loop
public class Level1_56 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] score = new int[st.countTokens()];

        for(int i = 0; i < score.length; ++i) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(solution(k, m, score));
        System.out.print(sb);
    }

    private static int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        int recent = score.length - m;

        while(recent >= 0) {
            answer += score[recent] * m;
            recent -= m;
        }

        return answer;
    }
}
