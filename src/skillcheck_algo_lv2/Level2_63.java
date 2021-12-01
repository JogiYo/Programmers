package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : vowel dictionary
// number of cases
public class Level2_63 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String word = br.readLine();

        sb.append(solution(word) + "");
        System.out.print(sb);
    }

    private static int solution(String word) {
        int answer = word.length();
        String alpha = "AEIOU";
        int[] arr = {781, 156, 31, 6, 1};

        for(int i = 0 ; i < word.length(); ++i) {
            answer += arr[i] * alpha.indexOf(word.charAt(i));
        }

        return answer;
    }
}
