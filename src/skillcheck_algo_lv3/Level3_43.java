package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// Programmers Level 3 : Moving 110
// Greedy algorithm
// ref : https://prgms.tistory.com/57
public class Level3_43 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] s = br.readLine().split(", ");
		
		String[] result = solution(s);
		sb.append(result[0] + "");

		for(int i = 1; i < result.length; ++i) {
			sb.append(", " + result[i]);
		}
		System.out.print(sb);
	}
	
	public static String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i = 0; i < s.length; ++i) {
        	String str = s[i];
        	Stack<Character> stk = new Stack<>();
        	int cnt = 0;
        	// '110' drawing and string transformation using stack
        	for(int j = 0; j < str.length(); ++j) {
        		char z = str.charAt(j);
        		
        		if(stk.size() >= 2) {
        			char y = stk.pop();
        			char x = stk.pop();
        			
        			if(x == '1' && y == '1' && z == '0') {
        				cnt++;
        				continue;
        			}
        			else {
        				stk.push(x);
        				stk.push(y);
        				stk.push(z);
        			}
        		}
        		else stk.push(z);
        	}
        	
        	if(cnt == 0) {
        		answer[i] = s[i];
        	}
        	else {
        		int idx = stk.size();
        		boolean flag = false;
        		StringBuilder strb = new StringBuilder();
        		
        		while(!stk.isEmpty()) {
        			if(!flag && stk.peek() == '1') idx--;
        			if(!flag && stk.peek() == '0') flag = true;
        			strb.insert(0, stk.pop());
        		}
        		
        		while(cnt > 0) {
        			strb.insert(idx,  "110");
        			idx += 3;
        			cnt--;
        		}
        		answer[i] = strb.toString();
        	}
        }
        return answer;
    }
}