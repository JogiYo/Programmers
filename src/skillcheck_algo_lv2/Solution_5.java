package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input_1 = br.readLine().split(" ");
		int row = Integer.parseInt(input_1[0]);
		int col = Integer.parseInt(input_1[1]);
		
		int[][] monun = new int[col][row];
		
		String[] input_2 = br.readLine().split(" ");
		int find_row = Integer.parseInt(input_2[0]);
		int find_col = Integer.parseInt(input_2[1]);
		
		for(int i = 1; i < monun.length; i++) {
			monun[0][i] = 1;
			monun[i][0] = 1;
		}
		for(int i = 1; i < monun.length; i++) {
			for(int j = 1; j < monun[0].length; j++) {
				monun[i][j] = monun[i-1][j] + monun[i][j-1];
			}
		}
		
		System.out.print(find_col + find_row + "\n" + monun[find_row][find_col]);
	}
}