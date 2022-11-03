package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

// Programmers Level 2 : Cutting roll cake
// use Set & HashMap
public class Level2_78 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] topping = new int[st.countTokens()];

        for(int i = 0; i < topping.length; ++i) {
            topping[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(solution(topping));
        System.out.print(sb);
    }

    private static int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();

        // Insert the topping array into the hashmap.
        for (int top : topping) {
            hm.put(top, hm.getOrDefault(top, 0) + 1);
        }

        /*
         * Iterates through the topping array,
         * subtracts the corresponding element from the hashmap, and adds it to the set.
         */
        for(int top : topping) {
            hs.add(top);
            hm.replace(top, hm.get(top) - 1);

            if(hm.get(top) == 0) {
                hm.remove(top);
            }

            /*
             * If the size of the set and the map are the same,
             * the number of types is the same.
             */
            if(hm.size() == hs.size()) answer++;
        }

        return answer;
    }
}