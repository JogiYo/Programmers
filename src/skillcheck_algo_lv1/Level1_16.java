package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : String to Integer
public class Level1_16 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		sb.append(solution(input) + "");
		System.out.print(sb);
	}
	
	public static int solution(String n) {
		int answer = 0;
		answer = Integer.parseInt(n);
		return answer;
	}
}