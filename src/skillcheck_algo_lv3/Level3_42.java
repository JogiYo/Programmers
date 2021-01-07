package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : N Queen
// using backtracking, recursion
// Math.abs(depth-i) == Math.abs(col[depth] - col[i]) The process of checking if it exists on the diagonal. I think it's good to know
public class Level3_42 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	static int answer = 0;
	static int x = 0;
	static int col[];
	
	public static int solution(int n) {
		// One queen can come in a row.
		// The col value ranges from 0 to n-1, and these values ​​indicate the position.
        col = new int[n];
        x = n;
        queen(0); // Start with the first row.
        return answer;
    }
	
	private static void queen(int depth) {
		if(depth == x) { // If you filled in the values ​​for each row, the condition was satisfied.
			answer++;
		}
		else {
			for(int i = 0; i < x; ++i) {
				col[depth] = i;
				if(isPossible(depth)) { // Checks by putting a value in the row.
					// If satisfied, proceed to next row
					queen(depth+1);
				}
			}
		}
	}
	
	private static boolean isPossible(int depth) {
		for(int i = 0; i < depth; ++i) {
			if(col[i] == col[depth]) return false; // When the queen is in a straight line
			if(Math.abs(depth-i) == Math.abs(col[depth] - col[i])) return false; // ** When the queen is on the diagonal **
		}
		
		return true;
	}
}