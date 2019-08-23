package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Find prime number
public class Level1_14 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int input = Integer.parseInt(br.readLine());
		sb.append(solution(input) + "");
		System.out.print(sb);
	}
	
	public static int solution(int n) {
		int answer = 0;
		
		if(n == 2) return 1;
		for(int i = 2; i <= n; i++) {
			boolean isPrime = true;
			
			for(int j = 2; j < i; j++) {
				if(i%j == 0) {
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) answer++;
		}
		return answer;
	}
}