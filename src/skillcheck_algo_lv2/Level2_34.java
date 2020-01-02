package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Fibonacci number % 1234567
// Using Dynamic Programming, not recursion
public class Level2_34 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static int solution(int n) {
        int[] fibo = new int[100001];
        fibo[0] = 0;
        fibo[1] = 1;
        
        for(int i = 2; i <= n; i++) {
        	fibo[i] = (fibo[i-1] + fibo[i-2]) % 1234567;
        }
        
        return fibo[n];
    }
}