package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Joy Stick
public class Level2_16 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		sb.append(solution(br.readLine()) + "");
		System.out.print(sb);
	}
	
	public static int solution(String name) {
		int answer = 0;
		
		answer += Math.min(name.charAt(0) - 65, 91 - name.charAt(0));
		
		// ascii A : 65 , Z : 90 , [ : 91
		return answer;
	}
}
