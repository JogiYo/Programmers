package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level2 : Number of country 124
// Using recursive function.
public class Level2_4 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static String solution(int n) {
		if(n == 0) {
			return "";
		}
		else if(n%3 == 0) {
			return solution((n/3) - 1) + "4";	
		}
		else {
			return solution(n/3) + n%3;
		}
	}
}