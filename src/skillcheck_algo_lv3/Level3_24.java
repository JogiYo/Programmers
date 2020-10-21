package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : Pedestrian heaven(2017 KAKAO Code Qualifier)
// using Dynamic Programming
public class Level3_24 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	

		String[] input = br.readLine().split(", ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		
		int[][] cityMap = new int[m][n];
		for(int i = 0; i < m; i++) {
			String[] input2 = br.readLine().split(", ");
			for(int j = 0; j < n; j++) {
				cityMap[i][j] = Integer.parseInt(input2[j]);
			}
		}
		
		sb.append(solution(m, n, cityMap) + "");
		System.out.print(sb);
	}
	
	static int MOD = 20170805;
	public static int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        // Since the direction of travel is important, we add an array for it.
        // Create a three-dimensional array from a two-dimensional array. ex) dp[m][n] -> dp[m][n][2]
        int[][][] dp = new int[m+1][n+1][2];
        // 0 down, 1 right
        // The values ​​of dp[1][1][0] and dp[1][1][1] are to be set to 1.
        dp[0][1][0] = 1;
        
        for(int i = 1; i <= m; i++) {
        	for(int j = 1; j <= n; j++) {
        		if(cityMap[i-1][j-1] == 0) {
        			dp[i][j][0] = (dp[i-1][j][0] + dp[i][j-1][1]) % MOD;
        			dp[i][j][1] = (dp[i-1][j][0] + dp[i][j-1][1]) % MOD;
        		}
        		else if(cityMap[i-1][j-1] == 1) {
        			dp[i][j][0] = 0;
        			dp[i][j][1] = 0;
        		}
        		else { // cityMap[i-1][j-1] == 2
        			dp[i][j][0] = dp[i-1][j][0];
        			dp[i][j][1] = dp[i][j-1][1];
        		}
        	}
        }
        
        answer = dp[m][n][0];
        return answer;
    }
}