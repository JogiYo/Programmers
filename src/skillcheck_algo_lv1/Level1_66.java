package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// Programmers Level 1 : Memory score
// use HashMap
public class Level1_66 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] name = new String[st.countTokens()];
        for(int i = 0; i < name.length; ++i) {
            name[i] = st.nextToken();
        }

        st = new StringTokenizer(br.readLine());
        int[] yearning = new int[st.countTokens()];
        for(int i = 0; i < yearning.length; ++i) {
            yearning[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());
        String[][] photo = new String[n][];
        for(int i = 0; i < n; ++i) {
            photo[i] = br.readLine().split(" ");
        }

        int[] result = solution(name, yearning, photo);
        sb.append(result[0]);
        for(int i = 1; i < result.length; ++i) sb.append(" ").append(result[i]);
        System.out.print(sb);
    }

    private static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> hm = new HashMap<>();

        for(int i = 0; i < name.length; ++i) {
            hm.put(name[i], yearning[i]);
        }

        for(int i = 0; i < photo.length; ++i) {
            int sum = 0;
            for(int j = 0; j < photo[i].length; ++j) {
                sum += hm.getOrDefault(photo[i][j], 0);
            }

            answer[i] = sum;
        }
        return answer;
    }
}