package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Pointing Rectangular star
public class Level1_30 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		sb.append(solution(a,b) + "");
		System.out.print(sb);
	}
	
	public static String solution(int a, int b) {
		String answer = "";
		
		for(int i = 0; i < b; i++) {
			for(int j = 0; j < a; j++) {
				answer += "*";
			}
			answer +="\n";
		}
		return answer;
	}
}