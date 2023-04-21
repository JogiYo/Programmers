package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Programmers Level 2 : Intercept system
// Sorts in ascending order by end time.
public class Level2_101 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] targets = new int[n][2];

        for(int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            targets[i][0] = Integer.parseInt(st.nextToken());
            targets[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = solution(targets);
        sb.append(result);
        System.out.print(sb);
    }

    private static int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int end = targets[0][1];
        answer++; // The first intercept system to be built

        for(int[] target : targets) {
            // Added a new intercept system
            // because the starting point is to the right of the upper limit of the intercept system
            if(target[0] >= end) {
                end = target[1];
                answer++;
            }
        }

        return answer;
    }
}
