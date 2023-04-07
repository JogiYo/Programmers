package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// Programmers Level 1 : running race
// use HashMap
public class Level1_68 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String[] players = new String[st.countTokens()];
        for(int i = 0; i < players.length; ++i) players[i] = st.nextToken();

        st = new StringTokenizer(br.readLine());
        String[] callings = new String[st.countTokens()];
        for(int i = 0; i < callings.length; ++i) callings[i] = st.nextToken();

        String[] result = solution(players, callings);
        sb.append(result[0]);
        for(int i = 1; i < result.length; ++i) sb.append(" ").append(result[i]);
        System.out.print(sb);
    }

    private static String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> player = new HashMap<>();
        HashMap<Integer, String> rank = new HashMap<>();
        String[] answer = new String[players.length];

        for(int i = 0; i < players.length; ++i) {
            player.put(players[i], i);
            rank.put(i, players[i]);
        }


        for(int i = 0; i < callings.length; ++i) {
            int curRank = player.get(callings[i]);
            String pastPlayer = rank.get(curRank-1);

            player.put(callings[i], curRank-1);
            player.put(pastPlayer, curRank);
            rank.put(curRank-1,  callings[i]);
            rank.put(curRank, pastPlayer);
        }

        for(int i = 0; i < answer.length; ++i) answer[i] = rank.get(i);
        return answer;
    }
}