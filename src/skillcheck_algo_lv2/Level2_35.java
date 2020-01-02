package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : matrix multiplication
// Using loop
public class Level2_35 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] arr1_idx = br.readLine().split(" ");
		int a, b;
		a = Integer.parseInt(arr1_idx[0]);
		b = Integer.parseInt(arr1_idx[1]);
		int[][] arr1 = new int[a][b];
		for(int i = 0; i < a; i++) {
			String[] input = br.readLine().split(", ");
			for(int j = 0; j < b; j++) {
				arr1[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		String[] arr2_idx = br.readLine().split(" ");
		int c, d;
		c = Integer.parseInt(arr2_idx[0]);
		d = Integer.parseInt(arr2_idx[1]);
		int[][] arr2 = new int[c][d];
		for(int i = 0; i < c; i++) {
			String[] input = br.readLine().split(", ");
			for(int j = 0; j < d; j++) {
				arr2[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		sb.append(solution(arr1, arr2) + "");
		System.out.print(sb);
	}
	
	public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        // matrix[i][j] = arr1[i][0]*arr2[0][j] + arr1[i][1]*arr2[1][j] + ... + arr1[i][n]*arr2[n][j]
        for(int i = 0; i < answer.length; i++) {
        	for(int j = 0; j < answer[0].length; j++) {
        		int n = 0;
        		while(n < arr2.length) {
        			answer[i][j] += arr1[i][n] * arr2[n][j];
        			n++;
        		}
        	}
        }
        
        return answer;
    }
}