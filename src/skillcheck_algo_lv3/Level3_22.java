package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : Road to school
// using Dynamic Programming
public class Level3_22 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	

		String[] input = br.readLine().split(", ");
		int n = Integer.parseInt(input[1]);
		int m = Integer.parseInt(input[0]);
		
		int x = Integer.parseInt(br.readLine());
		int[][] puddles = new int[x][2];
		for(int i = 0; i < x; i++) {
			String[] input2 = br.readLine().split(", ");
			puddles[i][0] = Integer.parseInt(input2[0]);
			puddles[i][1] = Integer.parseInt(input2[1]);
		}
		
		
		sb.append(solution(m, n, puddles) + "");
		System.out.print(sb);
	}
	
	public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        long[][] dp = new long[n][m];
        
        for(int i = 0; i < puddles.length; i++) {
        	dp[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        
        for(int i = 1; i < m; i++) {
        	if(dp[0][i] == -1) break;
        	dp[0][i] = 1;
        }
        
        for(int i = 1; i < n; i++) {
        	if(dp[i][0] == -1) break;
        	dp[i][0] = 1;
        }
        // It can only be moved to the right and down.
        for(int i = 1; i < n; i++) {
        	for(int j = 1; j < m; j++) {
        		if(dp[i][j] != -1) {
        			if(dp[i-1][j] == -1 && dp[i][j-1] == -1) {
        				dp[i][j] = 0;
        			}
        			else if(dp[i][j-1] == -1) {
        				dp[i][j] = dp[i-1][j];
        			}
        			else if(dp[i-1][j] == -1) {
        				dp[i][j] = dp[i][j-1];
        			}
        			else {
        				dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000007;
        			}
        		}
        	}
        }
        
        answer = Long.valueOf(dp[n-1][m-1]%1000000007).intValue();
        return answer;
    }
}