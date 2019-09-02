package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Hide cell phone number
public class Level1_28 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String n = br.readLine();
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static String solution(String phone_number) {
		String answer = "";
		String[] input = phone_number.split("");
		for(int i = 0; i < phone_number.length(); i++) {
			if(i < phone_number.length()-4) answer += "*";
			else answer += input[i];
		}
		return answer;
	}
}