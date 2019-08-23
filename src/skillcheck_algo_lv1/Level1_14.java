package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Find prime number 
// Using Eratosthenes Algorithm!
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
		int[] number = new int[n+1];
	
		for(int i = 2; i <= n; i++)	number[i] = i;
		
		// 2 ~ i*i <= n
		// Clear each multiple.
		for(int i = 2; (i*i) <= n; i++) {
			if(number[i] != 0) {
				for(int j = i*2; j <= n; j += i) {
					number[j] = 0;
					// Since i * i has already been processed, 
					// the starting value of j can be optimized with i * i.
					// for(int j = i*i; j <= n; j += i)
				}
			}
		}
		// If the array value is not zero, it's prime number.
		for(int i = 0; i < number.length; i++) {
			if(number[i] != 0) answer++;
		}
		return answer;
	}
}