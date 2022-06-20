package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : 3 x n Tiling
// dynamic programming
// Ref : https://uyoo-story.tistory.com/22
public class Level2_73 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        sb.append(solution(n));

        System.out.print(sb);
    }

    private static int solution(int n) {
        int mod = 1000000007;
        long[] dp = new long[5001];

        dp[0] = 1;
        dp[2] = 3;

        for(int i = 4; i <= n; i+=2) {
            dp[i] = dp[i-2] * 3;
            for(int j = i - 4; j >= 0; j-=2) {
                dp[i] += dp[j] * 2;
            }
            dp[i] %= mod;
        }
        return (int)dp[n];
    }
}