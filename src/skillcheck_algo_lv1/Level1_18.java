package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Sum of all divisors
public class Level1_18 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static int solution(int n) {
		int answer = 0;
		
		// search for half and add n.
		// It only takes half the loop to search.
		for(int i = 1; i <= n/2; i++) {
			if(n%i == 0) answer += i;
		}
		return answer + n;
	}
}