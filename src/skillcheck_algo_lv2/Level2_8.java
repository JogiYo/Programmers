package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// Programmers Level 2 : iron bar
// Using Stack
public class Level2_8 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		sb.append(solution(input) + "");
		System.out.print(sb);
	}
	
	public static int solution(String arrangement) {
		int answer = 0;
		Stack<Character> stk = new Stack<Character>();
		
		for(int i = 0; i < arrangement.length(); i++) {
			if(arrangement.charAt(i) == '(') {
				stk.push(arrangement.charAt(i));
			}
			// '(' In front means there is a laser, -> answer += stk.size(); 
			// and ')' means the end of the stick. -> answer++;
			else {
				stk.pop();
				if(arrangement.charAt(i-1) == '(') {
					answer += stk.size();
				}
				else answer++;
			}
		}
		return answer;
	}
}