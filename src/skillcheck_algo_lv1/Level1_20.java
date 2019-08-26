package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Create array by reversing each digit of natural number
public class Level1_20 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long n = Long.parseLong(br.readLine());
		int[] answer = solution(n);
		for(int i = 0; i < answer.length; i++) {
			sb.append(answer[i] + " ");
		}
		System.out.print(sb);
	}
	
	public static int[] solution(long n) {
		String[] arr = Long.toString(n).split("");
		int[] answer = new int[arr.length];
		int index = 0;
		
		while(n > 0) {
			answer[index] = (int)(n%10);
			n /= 10;
			index++;
		}
		
		return answer;
	}
}