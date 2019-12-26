package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Find the largest square
// Using Dynamic Programming
public class Level2_25 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input_1 = br.readLine().split(", ");
		int n = Integer.parseInt(input_1[0]);
		int m = Integer.parseInt(input_1[1]);
		
		int[][] board = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(", ");
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		sb.append(solution(board) + "");
		System.out.print(sb);
	}
	
	public static int solution(int [][]board)
    {
        int answer = 0;
        int[][] dp = new int[board.length+1][board[0].length+1];
        
        // If rows and columns don't use a matrix with 1 greater than the existing matrix, 
        // does not handle cases where (1, 0), (0, 0).
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		if(board[i][j] == 1) dp[i+1][j+1] = 1;
        	}
        }
        
        for(int i = 1; i < dp.length; i++) {
        	for(int j = 1; j < dp[0].length; j++) {
        		// If dp[i][j] is not 0, find minimum value among adjacent values and add 1.
        		// Index values shall be less than i and j.
        		if(dp[i][j] != 0) {
        			dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
        			
        			if(answer < dp[i][j]) answer = dp[i][j];
        		}
        	}
        }
        
        // Square of answer is square area
        return answer * answer;
    }
}