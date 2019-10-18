package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Solution_3 {
	public static void main(String args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] toilet = new int[n][2];
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			toilet[i][0] = Integer.parseInt(input[0]);
			toilet[i][1] = Integer.parseInt(input[1]);
		}
		
		Arrays.sort(toilet);
		Stack<pair> stk = new Stack<pair>();
	}
	
	class pair {
		int a;
		int b;
		
		pair(int a, int b) {
			this.a = a;
			this.b=  b;
		}
	}
}