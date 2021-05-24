package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

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
        	Stack<String> stk = new Stack<>();
        	
        	while(str.indexOf("110") != -1) {
        		int idx = str.indexOf("110");
        		str = str.substring(0, idx) + str.substring(idx + 3);
        		stk.push("110");
        	}
        	
        	String add_str = "";
        	while(!stk.isEmpty()) {
        		add_str += stk.pop();
        	}
        	
        	if(str.length() >= 3) {
        		if(str.indexOf("111") != -1) {
            		int idx = str.indexOf("111");
            		str = str.substring(0, idx) + add_str + str.substring(idx);
            	}
            	else {
            		str += add_str;
            	}
        	}
        	else if(str.length() == 2) {
        		if(str.indexOf("11") != -1) {
            		int idx = str.indexOf("11");
            		str = str.substring(0, idx) + add_str + str.substring(idx);
            	}
            	else {
            		str += add_str;
            	}
        	}
        	else {
        		if(str.indexOf("1") != -1) {
            		int idx = str.indexOf("1");
            		str = str.substring(0, idx) + add_str + str.substring(idx);
            	}
            	else {
            		str += add_str;
            	}
        	}
        	
        	answer[i] = str;
        }
        return answer;
    }
}