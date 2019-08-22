package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Number of p and y in the string(short coding.)
// using stream and lambda
public class Level1_10_short {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		sb.append(solution(input) + "");
		System.out.print(sb);
	}
	
	public static boolean solution(String s) {
		s = s.toUpperCase();
		// using stream and lambda
		return s.chars().filter(factor -> 'P' == factor).count() == s.chars().filter(factor -> 'Y' == factor).count();
	}
}