package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// Programmers Level 1 : Rough keyboard
// use Hashmap
public class Level1_64 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] keymap = br.readLine().split(" ");
        String[] target = br.readLine().split(" ");

        int[] result = solution(keymap, target);
        sb.append(result[0]);
        for(int i = 1; i < result.length; ++i) {
            sb.append(" ").append(result[i]);
        }

        System.out.print(sb);
    }

    private static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> hm = new HashMap<>();

        // Update the minimum number of presses for each alphabet
        for(int i = 0; i < keymap.length; ++i) {
            String key = keymap[i];

            for(int j = 0; j < key.length(); ++j) {
                if(hm.getOrDefault(key.charAt(j), 101) > j+1) hm.put(key.charAt(j), j+1);
            }
        }

        for(int i = 0; i < targets.length; ++i) {
            String str = targets[i];
            int total_count = 0;

            // Searching
            for(int j = 0; j < str.length(); ++j) {
                if(hm.getOrDefault(str.charAt(j), -1) == -1) {
                    total_count = -1;
                    break;
                }
                else total_count += hm.get(str.charAt(j));
            }

            answer[i] = total_count;
        }

        return answer;
    }
}