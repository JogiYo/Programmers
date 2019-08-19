package skillcheck_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers, skill_check Lv1 : Get center character
// Solve using 'substring' method
public class check_lv1_5 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();

		String answer = solution(input);
		sb.append(answer);
		System.out.print(sb);
	}
	
	public static String solution(String s) {
		String answer = "";
		int n = s.length()/2;
		if(s.length()%2 == 1) {
			answer = s.substring(n, n+1);
		}
		else {
			answer = s.substring(n-1, n+1);
		}
		return answer;
	}
}