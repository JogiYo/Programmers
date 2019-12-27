package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Hopscotch
// Using Dynamic Programming
public class Level2_28 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		int[][] land = new int[n][4];
		
		while(n-- > 0) {
			String[] input = br.readLine().split(", ");
			
			for(int  i = 0; i < 4; i++) {
				land[n][i] = Integer.parseInt(input[i]);
			}
		}
		
		sb.append(solution(land) + "");
		System.out.print(sb);
	}
	
	public static int solution(int[][] land) {
        int answer = 0;
        int len = land.length;
        int[][] dp = new int[len][4];
        
        for(int i = 0; i < 4; i++) {
        	dp[0][i] = land[0][i];
        }
        
        // If current index is not equal to the previous index, Find the best value.
        for(int i = 1; i < len; i++) {
        	for(int j = 0; j < 4; j++) {
        		for(int k = 0; k < 4; k++) {
        			if(j != k) {
        				dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i-1][k]);
        			}
        		}
        	}
        }
        // Navigate to the maximum value in the last row.
        for(int i = 0; i < 4; i++) {
        	if(dp[len-1][i] > answer) answer = dp[len-1][i]; 
        }
        
        return answer;
    }
}