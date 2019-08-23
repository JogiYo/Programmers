package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers, Level 1: String handling
public class Level1_12 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		sb.append(solution(input) + "");
		System.out.print(sb);
	}
	
	public static boolean solution(String s) {
		boolean answer = true;
		int length = s.length();
		
		if(length == 4 || length == 6) {
			for(int i = 0; i < length; i++) {
				if(s.charAt(i) < '0' || s.charAt(i) > '9') {
					answer = false;
					break;
				}
			}
		}
		else answer = false;
		
		return answer;
	}
}