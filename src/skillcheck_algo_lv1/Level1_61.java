package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

// Programmers Level 1 : Personal information collection validity period
public class Level1_61 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String today = br.readLine();

        int terms_n = Integer.parseInt(br.readLine());
        String[] terms = new String[terms_n];
        for(int i = 0; i < terms_n; ++i) {
            terms[i] = br.readLine();
        }

        int privacies_n = Integer.parseInt(br.readLine());
        String[] privacies = new String[privacies_n];
        for(int i = 0; i < privacies_n; ++i) {
            privacies[i] = br.readLine();
        }

        int[] result = solution(today, terms, privacies);
        sb.append(result[0]);
        for(int i = 1; i < result.length; ++i) {
            sb.append(" ").append(result[i]);
        }
        System.out.print(sb);
    }

    /*
     * Consider that a month has 28 days.
     * It is convenient to calculate the total number of days.
     */
    private static int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(String term : terms) {
            String[] str = term.split(" ");
            hm.put(str[0], Integer.parseInt(str[1]));
        }

        int total = getTotal(today);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < privacies.length; ++i) {
            String[] str = privacies[i].split(" ");

           if(getTotal(str[0]) + hm.get(str[1])*28 - 1 < total) list.add(i+1);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    private static int getTotal(String curday) {
        String[] date = curday.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);

        return 336*year + 28*month + day;
    }
}