package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : 2 x n Tiling
// Using dynamic programming(fibonacci)
public class Level3_3 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static int solution(int n) {
		int[] dp = new int[60001];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
		}
		
		return dp[n];
    }
}