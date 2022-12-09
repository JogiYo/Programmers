package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// Programmers Level 1 : nearest identical letter
// use HashMap
public class Level1_59 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        int[] result = solution(s);

        sb.append(result[0]);
        for(int i = 1; i < result.length; ++i) {
            sb.append(" ").append(result[i]);
        }

        System.out.print(sb);
    }

    private static int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); ++i) {
            if(!map.containsKey(s.charAt(i))) {
                answer[i] = -1;
            }
            else {
                // The distance is the value obtained by subtracting the most recent index from the current index.
                answer[i] = i - map.get(s.charAt(i));
            }
            // Adds the character's current index to the map.
            map.put(s.charAt(i), i);
        }

        return answer;
    }
}