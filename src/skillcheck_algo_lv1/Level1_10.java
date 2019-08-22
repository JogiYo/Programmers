package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Number of p and y in the string
public class Level1_10 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		sb.append(solution(input) + "");
		System.out.print(sb);
	}
	
	public static boolean solution(String s) {
		s = s.toUpperCase();
		int p_count = 0;
		int y_count = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'P') p_count++;
			else if(s.charAt(i) == 'Y') y_count++;	
		}
		
		return (p_count == y_count)? true : false;
	}
}