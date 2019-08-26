package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers, Level 1 : Create strange characters
public class Level1_19 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String n = br.readLine();
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static String solution(String s) {
		String answer = "";
		// split(regex, limit)
		// if limit value is '-1', array also contains a zero length string.
		String[] arr = s.split(" ", -1);
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length(); j++) {
				char c = arr[i].charAt(j);
				if(j%2 == 0)	c = Character.toUpperCase(c);
				else	c = Character.toLowerCase(c);
				answer += c;
			}
			answer += " ";
		}
		answer = answer.substring(0, answer.length()-1);
	
		return answer;
	}
}
