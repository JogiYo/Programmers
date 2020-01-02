package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Create a JadenCase String
// Using to---Case conversion and substring
public class Level2_36 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String s = br.readLine();
		
		sb.append(solution(s) + "");
		System.out.print(sb);
	}
	
	// It is important to consider the case where there is a continuous space " ".
	public static String solution(String s) {
        s = s.toLowerCase();
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        for(int i = 1; i < s.length(); i++) {
        	if(s.charAt(i-1) == ' ') {
        		s = s.substring(0, i) + s.substring(i, i+1).toUpperCase() + s.substring(i+1);
        	}
        }
      
        return s;
    }
}