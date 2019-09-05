package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Tower
// It was a stack / queue category, but it can be simply implemented as a loop.
public class Level2_7 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input = br.readLine().split(" ");
		int[] height = new int[input.length];
		
		for(int i = 0; i < input.length; i++) {
			height[i] = Integer.parseInt(input[i]);
		}
		int[] answer = solution(height);
		for(int i = 0; i < answer.length; i++) {
			sb.append(answer[i] + " ");
		}
		System.out.print(sb);
	}
	
	public static int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		
		for(int i = heights.length-1; i > 0; i--) {
			for(int j = i-1; j >= 0; j--) {
				if(heights[i] < heights[j]) {
					answer[i] = j+1;
					break;
				}
			}
		}
		answer[0] = 0;
		
		return answer;
	}
}