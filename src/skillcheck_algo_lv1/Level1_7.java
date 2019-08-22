package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// Programmers, Level 1 : Create Divided Numeric Arrangement
// It would be nice to study 'Arrays.stream'.
public class Level1_7 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int divisor = Integer.parseInt(br.readLine());
		String[] s_input = br.readLine().split(" ");
		int[] input = new int[s_input.length];
		
		for(int i = 0; i < s_input.length; i++) {
			input[i] = Integer.parseInt(s_input[i]);
		}
		int[] answer = solution(input, divisor);
		
		sb.append("[" + answer[0] + ", ");
		for(int i = 1; i < answer.length-1; i++) {
			sb.append(answer[i] + ", ");
		}
		sb.append(answer[answer.length-1] + "]");
		System.out.print(sb);
	}
	
	public static int[] solution(int[] arr, int divisor) {
		int[] answer;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]%divisor == 0) list.add(arr[i]);
		}
		
		if(list.isEmpty()) {
			answer = new int[1];
			answer[0] = -1;
		}
		else {
			answer = new int[list.size()];
			for(int i = 0; i < answer.length; i++) {
				answer[i] = list.get(i);
			}
			Arrays.sort(answer);
		}
		return answer;
	}
}