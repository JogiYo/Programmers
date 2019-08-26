package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Greatest common divisor and Least common multiple(gcd, lcm)
// using Euclidean algorithm
public class Level1_25 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[] ans = solution(n, m);
		for(int i = 0; i < ans.length; i++) sb.append(ans[i] + " ");
		System.out.print(sb);
	}
	
	public static int[] solution(int n, int m) {
		int[] answer = new int[2];
		
		answer[0] = gcd(n,m);
		// Least common multiple = gcd(n,m) / n*m 
		answer[1] = (n*m) / answer[0];
		
		return answer;
	}
	
	// Find the greatest common divisor using the Euclidean algorithm
	public static int gcd(int a, int b) {
		int mod = a % b;
		
		while(mod > 0) {
			a = b;
			b = mod;
			mod = a%b;
		}
		
		return b;
	}
}