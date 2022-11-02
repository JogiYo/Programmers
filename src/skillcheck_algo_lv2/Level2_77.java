package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// Programmers Level 2 : Discount event
// use HashMap
public class Level2_77 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String[] want = br.readLine().split(" ");

        st = new StringTokenizer(br.readLine());
        int[] number = new int[st.countTokens()];
        for(int i = 0; i < number.length; ++i) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        String[] discount = br.readLine().split(" ");
        sb.append(solution(want, number, discount));
        System.out.print(sb);
    }

    private static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        // Add the first 10 elements to the map.
        for(int i = 0; i < 10; ++i) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        // It is a possible day if you check the list and satisfy all of them.
        if(checkMatch(want, number, map)) answer++;

        for(int i = 10; i < discount.length; ++i) {
            // Decrease the first element, removes it, and then put the element.
            map.put(discount[i-10], map.getOrDefault(discount[i-10], 0) - 1);
            if(map.getOrDefault(discount[i-10], 0) <= 0) map.remove(discount[i-10]);
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            // After checking the list, if satisfied, answer++;
            if(checkMatch(want, number, map)) answer++;
        }

        return answer;
    }

    private static boolean checkMatch(String[] want, int[] number, HashMap<String, Integer> map) {
        for(int i = 0; i < want.length; ++i) {
            if(map.getOrDefault(want[i], 0) != number[i]) return false;
        }

        return true;
    }
}