package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level2_94 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] maps = new String[n];

        for(int i = 0; i < n; ++i) {
            maps[i] = br.readLine();
        }

        sb.append(solution(maps));
        System.out.print(sb);
    }

    private static int solution(String[] maps) {
        int answer = 0;
        return answer;
    }
}
