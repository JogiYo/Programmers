package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Triangular snail (Monthly Code Challenge Season 1)
// using loop and conditional
public class Level2_54 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		int[] result = solution(n);
		for(int i = 0; i < result.length; i++) {
			sb.append(result[i] + " ");
		}
		System.out.print(sb);
	}
	
	public static int[] solution(int n) {
		int[] answer;
		int max_num = 0;
		for(int i = 1; i <= n; i++) {
			max_num += i;
		}
		answer = new int[max_num];
		
		int[][] arr = new int[n][n];
		int num = 1;
		int x = 0, y = 0;
		arr[x][y] = num++;
		
		// One cycle goes through three steps.
		while(num <= max_num) {
			// Step 1. Process to the down
			while(x + 1 < n && arr[x+1][y] == 0) {
				arr[++x][y] = num++;
			}
			if(num > max_num) break;
			

			// Step 2. Process to the right
			while(y + 1 < n && arr[x][y+1] == 0) {
				arr[x][++y] = num++;
			}
			if(num > max_num) break;
			
			// Step 3. Process to the top left
			while(x - 1 >= 0 && y - 1 >= 0 && arr[x-1][y-1] == 0) {
				arr[--x][--y] = num++;
			}
			if(num > max_num) break;
		}
		
		int idx = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				answer[idx++] = arr[i][j];
			}
		}
		
        return answer;
    }
}
