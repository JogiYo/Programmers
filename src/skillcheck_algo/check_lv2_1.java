package skillcheck_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// Programmers, skill_check Lv2 : Find correct parentheses.
// Use the properties of the stack.
public class check_lv2_1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		
		boolean answer = solution(s);
		sb.append(answer);
		System.out.print(sb);
	}
	
	 static boolean solution(String s) {
		 boolean answer = false;
		 
		 Stack<Character> stk = new Stack<Character>();
	     
		 for(int i = 0; i < s.length(); i++) {
			 if(s.charAt(i) == '(') {
				 stk.push(s.charAt(i));
			 }
			 
			 else {
				 if(stk.isEmpty()) return answer;
				 else if(stk.pop() != '(') {
					 return answer;
				 }
			 }
		 }
		 
		 if(stk.isEmpty()) answer = true;
		 
	     return answer;
	 }
}