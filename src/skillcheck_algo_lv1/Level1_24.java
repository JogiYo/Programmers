package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Even and odd
public class Level1_24 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static String solution(int num) {
		return num%2 == 0 ?  "Even" : "Odd";
	}
}