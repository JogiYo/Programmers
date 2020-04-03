package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// Programmers Level 1 : Crane doll drawing game (KAKAO 2019 Winter InternShip)
// using Stack
public class Level1_35 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		
		int[][] board = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(",");
			for(int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		String[] input2 = br.readLine().split(",");
		int[] moves = new int[input2.length];
		for(int i = 0; i < input2.length; i++) {
			moves[i] = Integer.parseInt(input2[i]);
		}
		
		sb.append(solution(board, moves) + "");
		
		System.out.print(sb);
	}
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<Integer>();
        
        for(int i = 0; i < moves.length; i++) {
        	for(int j = 0; j < board.length; j++) {
        		if(board[j][moves[i]-1] != 0) {
        			int num = board[j][moves[i]-1];
        			board[j][moves[i]-1] = 0;
        			
        			if(bucket.isEmpty()) {
        				bucket.push(num);
        			}
        			else if(bucket.peek() == num) {
        				bucket.pop();
        				answer += 2;
        			}
        			else bucket.push(num);
        			
        			break;
        		}
        	}
        }
        
        return answer;
    }
}