package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Water melon
public class Level1_15 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int input = Integer.parseInt(br.readLine());
		sb.append(solution(input) + "");
		System.out.print(sb);
	}
	
	public static String solution(int n) {
		String answer = "";
	
		if(n%2 == 1) {
			answer = "수";
			for(int i = 0; i < (n/2); i++) answer += "박수";
		}
		else {
			for(int i = 0; i < (n/2); i++) answer += "수박";
		}
		return answer;
	}
}