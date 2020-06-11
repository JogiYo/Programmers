package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// Programmers Level 3 : Integer Triangle
// using Dynamic Programming
public class Level3_12 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(", ");
			for(int j = 0; j < input.length; j++) {
				triangle[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		sb.append(solution(triangle) + "\n");
		System.out.print(sb);
	}
	
	public static int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++) {
        	for(int j = 0; j < i+1; j++) {
        		if(j == 0) {
        			dp[i][j] = dp[i-1][0] + triangle[i][0];
        		}
        		else if(j == i) {
        			dp[i][j] = dp[i-1][j-1] + triangle[i][i];
        		}
        		else {
        			dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
        		}
        	}
        }
        
        int n = dp.length;
        
        for(int i = 0; i < n; i++) {
        	if(answer < dp[n-1][i]) answer = dp[n-1][i];
        }
        
        return answer;
    }
	
	public int solution_other(int[][] triangle) {
		for(int i = 1; i < triangle.length; i++) {
			triangle[i][0] += triangle[i-1][0];
			triangle[i][i] += triangle[i-1][i-1];
			
			for(int j = 1; j < i; j++) {
				triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
			}
		}
		
		return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
	}
}
