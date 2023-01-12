package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level2_88 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int user_count = Integer.parseInt(br.readLine());
        int[][] users = new int[user_count][2];
        for(int i = 0; i < user_count; ++i) {
            st = new StringTokenizer(br.readLine());
            users[i][0] = Integer.parseInt(st.nextToken());
            users[i][1] = Integer.parseInt(st.nextToken());
        }

        int emoticon_count = Integer.parseInt(br.readLine());
        int[] emoticons = new int[emoticon_count];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < emoticon_count; ++i) {
            emoticons[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(users, emoticons);
        sb.append(result[0]).append(" ").append(result[1]);
        System.out.print(sb);
    }

    private static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        return answer;
    }
}
