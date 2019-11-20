package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Convert parentheses
// recursion problem
public class Level2_15 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		sb.append(solution(br.readLine()));
		System.out.print(sb);
	}
	
	public static String solution(String p) {
		String answer = "";
		
		if(p.isEmpty()) return "";
		
		return answer;
	}
}