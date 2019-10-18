package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] distance = new int[n];
		int[] seat = new int[n];
		String[] input = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			seat[i] = Integer.parseInt(input[i]);
		}
		
		int max = 0;
		for(int i = 0; i < distance.length; i++) {
			if(seat[i] == 1) distance[i] = 0;
			else {
				if(i == 0) distance[i] = right_search(seat, i);
				else if(i == distance.length-1) distance[i] = left_search(seat, i);
				else {
					int left = left_search(seat, i);
					int right = right_search(seat, i);
					distance[i] = Math.min(left, right);
				}
			}
			
			if(max < distance[i]) max = distance[i];
		}
		
		System.out.print(max);
	}
	
	public static int left_search(int[] seat, int n) {
		int dist = 0;
		int i = n - 1;
		while(i >= 0) {
			if(seat[i] == 0) dist++;
			else {
				dist++;
				break;
			}
			i--;
		}
		return dist;
	}
	
	public static int right_search(int[] seat, int n) {
		int dist = 0;
		int i = n + 1;
		while(i < seat.length) {
			if(seat[i] == 0) dist++;
			else {
				dist++;
				break;
			}
			i++;
		}
		return dist;
	}
}