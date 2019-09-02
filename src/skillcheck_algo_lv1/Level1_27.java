package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Find the average of an Array
public class Level1_27 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int[] arr = new int[input.length];
		for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(input[i]);
		
		sb.append(solution(arr) + "");
		System.out.print(sb);
	}
	
	public static double solution(int[] arr) {
		double answer = 0;
		for(int i = 0; i < arr.length; i++) answer += arr[i];
		answer /= arr.length;
		return answer;
	}
}