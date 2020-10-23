package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : Long jump
// using Dynamic Programming
public class Level3_26 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static long solution(int n) {
        long answer = 0;
        int[] dp = new int[n+1];
        // If n is 1, overflow occurs at dp[2] = 2.
        if(n == 1) return 1;
        
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
        	dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        
        answer = Long.valueOf(dp[n]);
        return answer;
    }
}
