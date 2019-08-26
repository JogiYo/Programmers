package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Remove the smallest number
public class Level1_23 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int[] arr = new int[input.length];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		int[] ans = solution(arr);
		for(int i = 0; i < ans.length; i++) sb.append(ans[i] + " ");
		System.out.print(sb);
	}
	
	public static int[] solution(int[] arr) {
		
		if(arr.length == 1) {
		 int[] answer = new int[1];
		 answer[0] = -1;
		 return answer;
		}
		
		int[] answer = new int[arr.length-1];
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < min) min = arr[i];
		}
		
		int idx = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != min) {
				answer[idx++] = arr[i];
			}
		}
		
		return answer;
	}
}