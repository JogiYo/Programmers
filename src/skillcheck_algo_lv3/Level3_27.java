package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : Longest palindrome
// using brute force
public class Level3_27 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String s = br.readLine();
		sb.append(solution(s) + "");
		System.out.print(sb);
	}
	
	public static int solution(String s) {
        int answer = 1;

        char[] ch = s.toCharArray();
        // Search the longest palindrome first
        for(int len = s.length(); len > 1; len--) {
        	// Search by length from the start index.
        	for(int start = 0; start + len <= s.length(); start++) {
        		boolean flag = true;
        		// After dividing the string in half, it is determined whether the characters at both ends are the same.
        		for(int i = 0; i < len/2; i++) {
        			if(ch[start + i] != ch[start + len - i - 1]) {
        				flag = false;
        				break;
        			}
        		}
        		
        		if(flag) {
        			return len;
        		}
        	}
        }
        
        return answer;
    }
}