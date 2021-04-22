package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
 
// Programmers Level 2 : Rotate parentheses
// using Stack
public class Level2_60 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		
		sb.append(solution(s) + "");
		System.out.print(sb);
	}
	
	public static int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); ++i) {
        	String rotate_s = s.substring(i) + s.substring(0, i);
        	Stack<Character> stk = new Stack<>();
        	
        	for(int j = 0; j < rotate_s.length(); ++j) {
        		if(rotate_s.charAt(j) == '[' || rotate_s.charAt(j) == '(' || rotate_s.charAt(j) == '{') {
        			stk.push(rotate_s.charAt(j));
        		}
        		else if(!stk.isEmpty()) {
        			if(rotate_s.charAt(j) == ']' && stk.peek() == '[') {
        				stk.pop();
        			}
        			else if(rotate_s.charAt(j) == ')' && stk.peek() == '(') {
        				stk.pop();
        			}
        			else if(rotate_s.charAt(j) == '}' && stk.peek() == '{') {
        				stk.pop();
        			}
        			else break;
        		}
        		else {
        			stk.push(rotate_s.charAt(j));
        			break;
        		}
        	}
        	
        	if(stk.isEmpty()) answer++;
        }
        return answer;
    }
}