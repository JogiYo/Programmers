package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Programmers Level 1 : Three musketeers
// use Backtracking, DFS
public class Level1_49 {
    static int[] arr = new int[3];
    static int caseCount = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int[] number = new int[st.countTokens()];

        for(int i = 0; i < number.length; ++i) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(solution(number));
        System.out.print(sb);
    }

    public static int solution(int[] number) {
        dfs(0, 0, number);
        int answer = caseCount;
        return answer;
    }

    private static void dfs(int idx, int depth, int[] number) {
        if(depth == 3) {
            int sum = 0;
            for(int i = 0; i < 3; ++i) {
                sum += arr[i];
            }

            if(sum == 0) caseCount++;

            return;
        }

        for(int i = idx; i < number.length; ++i) {
            arr[depth] = number[i];
            dfs(i+1, depth+1, number);
        }
    }
}