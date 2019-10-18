package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int qc = Integer.parseInt(input[1]);
		
		int[] time = new int[qc];
		
		int result = Integer.MIN_VALUE;
		int i = 1;
		time[0] = Integer.parseInt(br.readLine());
		
		while(i < n) {
			int msg = Integer.parseInt(br.readLine());
			int min = Integer.MAX_VALUE;
			int min_idx = 0;
			for(int j = 0; j < qc; j++) {
				if(time[j] < min) {
					min = time[j];
					min_idx = j;
				}
			}
			time[min_idx] += msg;
			if(time[min_idx] > result) result = time[min_idx];
			i++;
		}
		System.out.print(result);
	}
}