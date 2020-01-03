package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// Programmers Level 2 : Remove by pairing
// Using Stack
public class Level2_38 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String s = br.readLine();
		sb.append(solution(s) + "");
		System.out.print(sb);
	}
	
	public static int solution(String s) {
        Stack<Character> stk = new Stack<>();
   
        for(int i = 0; i < s.length(); i++) {
        	if(stk.isEmpty()) stk.push(s.charAt(i));
        	else {
        		if(stk.peek() == s.charAt(i)) stk.pop();
        		else stk.push(s.charAt(i));
        	}
        }
        
        return stk.isEmpty() ? 1 : 0;
    }
}