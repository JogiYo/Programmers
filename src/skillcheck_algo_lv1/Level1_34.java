package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Darts Game
// String comparison
public class Level1_34 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String n = br.readLine();
		
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static int solution(String dartResult) {
		int answer = 0;
		int post_num = 0;
		int current_num = 0;
		
		for(int i = 0; i < dartResult.length(); i++) {
			// character is number (Score)
			if(dartResult.charAt(i) >= 48 && dartResult.charAt(i) <= 57) {
				post_num = current_num;
				if(i != dartResult.length()-1 && dartResult.charAt(i) == '1' && dartResult.charAt(i+1) == '0') {
					current_num = 10;
					i++;
				}
				else current_num = dartResult.charAt(i) - '0';
			}
			
			// character is 'S' or 'D' or 'T' (Bonus)
			else if(dartResult.charAt(i) == 'S' || dartResult.charAt(i) == 'D' || dartResult.charAt(i) == 'T') {
				if(dartResult.charAt(i) == 'S') {
					current_num = (int) Math.pow(current_num,1);
				}
				else if(dartResult.charAt(i) == 'D') {
					current_num = (int) Math.pow(current_num,2);
				}
				else if(dartResult.charAt(i) == 'T') {
					current_num = (int) Math.pow(current_num,3);
				}
				
				// If no option or last character
				if((i != dartResult.length()-1 && dartResult.charAt(i+1) >= 48 && dartResult.charAt(i+1) <= 57) || i == dartResult.length()-1 ) {
					answer += current_num;
				}
			}
			// character is '*' or '#' (Option)
			// Subtract post_num once since post_num and current_num double each and add to the result.
			else if(dartResult.charAt(i) == '*') {
				current_num *= 2;
				answer += post_num + current_num;
			}
			else if(dartResult.charAt(i) == '#') {
				current_num *= -1;
				answer += current_num;
			}
		}
		return answer;
	}
}