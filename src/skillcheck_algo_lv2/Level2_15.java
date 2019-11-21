package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// Programmers Level 2 : Convert parentheses
// recursion problem, Solve according to the condition.
public class Level2_15 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		sb.append(solution(br.readLine()));
		System.out.print(sb);
	}
	
	public static String solution(String p) {
		String answer = "";
		
		// condition 1. 
		// If the input is an empty string, it returns an empty string.
		if(p.isEmpty()) return "";
		
		String u = "";
		String v = "";
		int left = 0;
		int right = 0;
		
		// condition 2. 
		// Separate the string w into two "balanced parentheses strings" u and v. 
		// However, u must no longer be separated by a "balanced parenthesis string", 
		// and v can be an empty string.
		for(int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == '(') {
				left++;
			}
			else {
				right++;
			}
			// if left equals right, u is "balanced parentheses strings"
			if(left == right) {
				u = p.substring(0, i+1);
				v = p.substring(i+1, p.length());
				break;
			}
		}
		
		// Determine if u is the correct parenthesis
		Stack<Character> stk = new Stack<>();
		boolean correct_paren = true;
		
		try {
			for(int i = 0; i < u.length() ; i++) {
				if(u.charAt(i)=='(')
					stk.push('(');
				else
					stk.pop();
			}
		} catch(Exception e) {
			correct_paren = false;
		}
		
		// condition 3. 
		// If the string u is a "correct parenthesis string", repeat from step 1 on the string v.
		// 3-1 : The result is a string that is appended to u and returned.
		if(stk.isEmpty() && correct_paren) {
			answer = u + solution(v);
		}
		// condition 4.
		// If the string u is not a "correct parenthesis string", follow the procedure below.
		// 4-1 : Append '(' as the first character to an empty string.
		// 4-2: Recursively join the resulting strings from step 1 on the string v.
		// 4-3 : append ')'
		// 4-4 : Remove the first and last characters of u, reverse the parentheses direction of the rest of the string and append it after.
		// 4-5 : Returns the generated string.
		else {
			answer += '(';
			answer += solution(v) + ')';
			
			for(int i = 1; i < u.length()-1; i++) {
				if(u.charAt(i) == '(') answer += ')';
				else answer += '(';
			}
		}
		return answer;
	}
}