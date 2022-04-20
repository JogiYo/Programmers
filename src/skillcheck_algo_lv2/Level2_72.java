package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : archery competition
// use DSF, backtracking
public class Level2_72 {
    static int[] result = {-1};
    static int[] ryan;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(",");
        int[] info = new int[input.length];

        for(int i = 0; i < info.length; ++i) {
            info[i] = Integer.parseInt(input[i]);
        }

        result = solution(n, info);

        for(int i = 0; i < result.length; ++i) {
            sb.append(result[i] + " ");
        }
        System.out.print(sb);
    }

    public static int[] solution(int n, int[] info) {
        ryan = new int[11];
        dfs(info, 1, n);
        return result;
    }

    private static void dfs(int[] info, int cnt, int n) {
        if(cnt == n+1) {
            int apeachp = 0;
            int ryanp = 0;

            for(int i = 0; i < 11; ++i) {
                if(info[i] != 0 || ryan[i] != 0) {
                    if(info[i] < ryan[i]) ryanp += 10 - i;
                    else apeachp += 10 - i;
                }
            }

            if(ryanp > apeachp) {
                if(ryanp - apeachp > max) {
                    result = ryan.clone();
                    max = ryanp - apeachp;
                }
            }

            return;
        }

        for(int i = 0; i < 11 && ryan[i] <= info[i]; ++i) {
            ryan[i]++;
            dfs(info, cnt + 1, n);
            ryan[i]--;
        }
    }
}
