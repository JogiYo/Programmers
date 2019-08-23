package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Caesar cipher
// Using ASCII Code
public class Level1_17 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		sb.append(solution(s, n) + "");
		System.out.print(sb);
	}
	
	public static String solution(String s, int n) {
		String answer = "";
		
		for(int i = 0; i < s.length(); i++) {
			if((int)s.charAt(i) >= 65 && (int)s.charAt(i) <= 90) {
				int char_int = (int)s.charAt(i) + n;
				if(char_int > 90) {
					char_int = char_int - 26;
				}
				answer += (char)char_int;
			}
			else if((int)s.charAt(i) >= 97 && (int)s.charAt(i) <= 122) {
				int char_int = (int)s.charAt(i) + n;
				if(char_int > 122) {
					char_int = char_int - 26;
				}
				answer += (char)char_int;
			}
			else answer += s.charAt(i);
		}
		return answer;
	}
}