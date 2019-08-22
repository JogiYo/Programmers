package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers, Level 1
// Create a solution function that removes consecutive numbers from the array arr and returns the remaining numbers
public class Level1_6 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s_input = br.readLine().split(" ");
		int[] input = new int[s_input.length];
		
		for(int i = 0; i < s_input.length; i++) {
			input[i] = Integer.parseInt(s_input[i]);
		}
		int[] answer = solution(input);
		
		sb.append("[" + answer[0] + ", ");
		for(int i = 1; i < answer.length-1; i++) {
			sb.append(answer[i] + ", ");
		}
		sb.append(answer[answer.length-1] + "]");
		System.out.print(sb);
	}
	
	public static int[] solution(int[] arr) {
		int[] answer; 
		int[] temp_arr = new int[1000000];
		int ans_i = 0;
		int i = 0;

		temp_arr[ans_i++] = arr[i]; 
		int temp = arr[i++];
		
		while(i < arr.length) {
			if(temp != arr[i]) {
				temp_arr[ans_i++] = arr[i];
				temp = arr[i++];
			}
			else {
				i++;
			}
		}
		
		answer = new int[ans_i];
		
		for(int t = 0; t < answer.length; t++) {
			answer[t] = temp_arr[t];
		}
		return answer;
	}
}