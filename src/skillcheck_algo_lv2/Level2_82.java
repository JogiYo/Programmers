package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// Programmers Level 2 : Picking Tangerines
// use Map & List
public class Level2_82 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tangerine = new int[st.countTokens()];

        for(int i = 0; i  < tangerine.length; ++i) {
            tangerine[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(solution(k, tangerine));
        System.out.print(sb);
    }

    private static int solution(int k, int[] tangerine) {
        /*
         * After obtaining a list of the number of tangerines of each size,
         * sort them in descending order according to the number and
         * add them in order until K is selected.
         */
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> valueList = new ArrayList<>(map.values());
        Collections.sort(valueList, Collections.reverseOrder());

        int sum = 0;
        for(Integer count : valueList) {
            sum += count;
            answer++;
            if(sum >= k) return answer;
        }

        return answer;
    }
}