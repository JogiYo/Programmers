package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// Programmers Level 1 : personality type test
// switch statement
public class Level1_48 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String[] survey = br.readLine().split(" ");
        st = new StringTokenizer(br.readLine());

        int[] choices = new int[survey.length];
        for(int i = 0; i < choices.length; ++i) {
            choices[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(solution(survey, choices));
        System.out.print(sb);
    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        char[] type = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};

        HashMap<Character, Integer> index = new HashMap<>();
        int[] score = new int[8];

        // Index in order of type
        for(int i = 0; i < 8; ++i) {
            index.put(type[i], i);
        }

        for(int i = 0; i < survey.length; ++i) {
            char[] alpha = survey[i].toCharArray();
            switch (choices[i]) {
                case 1 : score[index.get(alpha[0])] += 3;
                    break;
                case 2 : score[index.get(alpha[0])] += 2;
                    break;
                case 3 : score[index.get(alpha[0])] += 1;
                    break;
                case 5 : score[index.get(alpha[1])] += 1;
                    break;
                case 6 : score[index.get(alpha[1])] += 2;
                    break;
                case 7 : score[index.get(alpha[1])] += 3;
                    break;
                default : break;
            }
        }

        for(int i = 0; i < 8; i += 2) {
            if(score[i] >= score[i+1]) answer += type[i];
            else answer += type[i+1];
        }
        return answer;
    }
}
