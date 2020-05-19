package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : Tile decorations
// using dynamic programming (fibonacci dp)
public class Level3_7 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static long solution(int N) {
        long answer = 0;
        long[] dp = new long[81];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i <= N; i++) {
        	dp[i] = dp[i-1] + dp[i-2];
        }
        
        answer = 2*(2*dp[N] + dp[N-1]);  
        return answer;
    }
}