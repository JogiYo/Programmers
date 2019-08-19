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
		 Stack<Character> stk = new Stack<Character>();
	     
		 try {
			 for(int i = 0; i < s.length(); i++) {
				 if(s.charAt(i) == '(') stk.push('(');
				 else stk.pop();
			 }
		 } catch(Exception e) {
			 return false;
		 }
		 
		 if(stk.isEmpty()) return true;
		 return false;
	 }
}