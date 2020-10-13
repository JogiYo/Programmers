package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Counting after quad compression
// using Divide and Conquer
public class Level2_55 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(",");
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
		int[] result = solution(arr); 
		sb.append(result[0] + ", " + result[1]);
		System.out.print(sb);
	}
	
	static int zero_cnt = 0;
	static int one_cnt = 0;
	
	public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        division(arr);
        
        answer[0] = zero_cnt;
        answer[1] = one_cnt;
        return answer;
    }

	// Initial division
	private static void division(int[][] arr) {
		int len = arr.length;
        int half = len/2;
        
        // The area is divided into 4.
        int a = check(0, 0, len-1-half, len-1-half, half, arr);
        int b = check(0, half, len-1-half, len-1, half, arr);
        int c = check(half, 0, len-1, len-1-half, half, arr);
        int d = check(half, half, len-1, len-1, half, arr);
        // Finally, if they are the same, combine them.
        // all number 1
        if(a == 1 && a == b && b == c && c == d) {
        	one_cnt -= 3;
        }
        // all number 0
        else if(a == 0 && a == b && b == c && c == d) {
        	zero_cnt -= 3;
        }
	}

	// divide and conquer
	private static int check(int start_row, int start_col, int end_row, int end_col, int half, int[][] arr) {
		if(half == 1) {
			if(arr[start_row][start_col] == 0) {
				zero_cnt++;
				return 0;
			}
			else {
				one_cnt++;
				return 1;
			}
		}
		
		// The area is divided into 4.
		half /= 2;
		int a = check(start_row, start_col, end_row-half, end_col-half, half, arr);
        int b = check(start_row, start_col + half, end_row-half, end_col, half, arr);
        int c = check(start_row + half, start_col, end_row, end_row - half, half, arr);
        int d = check(start_row + half, start_col + half, end_row, end_col, half, arr);
        
        // all number 1
        if(a == 1 && a == b && b == c && c == d) {
        	one_cnt -= 3;
        	return 1;
        }
        // all number 0
        else if(a == 0 && a == b && b == c && c == d) {
        	zero_cnt -= 3;
        	return 0;
        }

		return 2;
	}
}