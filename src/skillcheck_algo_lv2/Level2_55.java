package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        int[] answer = {};
        division(arr);
        
        return answer;
    }

	private static void division(int[][] arr) {
		int len = arr.length;
        int half = len/2;
        
        check(0, 0, half-1, half-1, half);
        check(0, half, half-1, len-1, half);
        check(half, 0, len-1, half-1, half);
        check(half, half, len-1, len-1, half);
	}

	private static void check(int start_row, int start_col, int end_row, int end_col, int half) {
		
		
	}
}