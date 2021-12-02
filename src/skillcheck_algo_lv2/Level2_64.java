package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : fatigue
// use DFS
public class Level2_64 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dundeons = {{80, 20}, {50,40}, {30, 10}};

        sb.append(solution(80, dundeons) + "");
        System.out.print(sb);
    }

    private static int result = 0;
    private static int solution(int k, int[][] dungeons) {
        boolean[] visit = new boolean[dungeons.length];
        dfs(k, dungeons, 0, visit);
        return result;
    }

    private static void dfs(int k, int[][] dungeons, int cnt, boolean[] visit) {
        for(int i = 0; i < dungeons.length; ++i) {
            if(!visit[i] && dungeons[i][0] <= k) {
                visit[i] = true;
                dfs(k - dungeons[i][1], dungeons, cnt+1, visit);
                visit[i] = false;
            }
        }
        result = Math.max(result, cnt);
    }
}
