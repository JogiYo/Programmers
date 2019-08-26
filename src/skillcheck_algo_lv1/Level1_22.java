package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1: Determine square root of integer
public class Level1_22 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long n = Long.parseLong(br.readLine());
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static long solution(long n) {
		long answer = (long) Math.sqrt(n);
		
		if(Math.pow(answer, 2) == n) return (long) Math.pow(answer+1, 2);
		
		return -1;
	}
}