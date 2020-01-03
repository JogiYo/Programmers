package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : N minimum common multiple
// Using greatest common divisor and least common multiple
public class Level2_37 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(",");
		int[] arr = new int[input.length];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		sb.append(solution(arr) + "");
		System.out.print(sb);
	}
	
	public static int solution(int[] arr) {
        int answer = 0;
        
        if(arr.length == 1) return arr[0];
        else {
        	answer = arr[0];
        	for(int i = 1; i < arr.length; i++) {
        		int GCD = gcd(answer, arr[i]);
        		answer = (answer * arr[i]) / GCD;
        	}
        }
        
        return answer;
    }
	
	private static int gcd(int a, int b) {
		int mod = a % b;
		
		while(mod > 0) {
			a = b;
			b = mod;
			mod = a%b;
		}
		
		return b;
	}
}