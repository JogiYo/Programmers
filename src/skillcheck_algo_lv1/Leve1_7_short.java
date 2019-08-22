package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
// Prorammers, Level 1 : short coding(1-7) using Arrays.stream
public class Leve1_7_short {
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
		
		if(answer.length == 1) sb.append("[" + answer[0] + "]");
		else {
			sb.append("[" + answer[0] + ", ");
			for(int i = 1; i < answer.length-1; i++) {
				sb.append(answer[i] + ", ");
			}
			sb.append(answer[answer.length-1] + "]");
		}
		System.out.print(sb);
	}
	
	public static int[] solution(int[] arr, int divisor) {
		int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
		if(answer.length == 0) {
			answer = new int[1];
			answer[0] = -1;
		}
		else Arrays.sort(answer);
		return answer;
	}
}
