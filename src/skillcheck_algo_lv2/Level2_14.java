package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Create a large number
// Greedy Algorithm
// Find the maximum of the possible numbers that can be matched at each position.
// if Using the stack, consumes a lot of time and memory.
public class Level2_14 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		String number = input[0];
		int k = Integer.parseInt(input[1]);
		
		sb.append(solution(number, k));
		System.out.print(sb);
	}
	
	public static String solution(String number, int k) {
		String answer = "";
		StringBuilder sbuild = new StringBuilder();
		int index = 0;
		char max;		
		// You must create a number of length 'number.length ()-k'.
		for(int i = 0; i < number.length()-k; i++) {
			max = '0';
			// Taking '1924' as an example, the first possible digit is 1, 9, 2.
			// Find the maximum of them and start by index + 1 at the location you find.
			// In this for statement, the value of k is equal to increasing by one.
			for(int j = index; j <= k + i; j++) {
				if(max < number.charAt(j)) {
					max = number.charAt(j);
					index = j + 1;
				}
			}
			sbuild.append(max);
		}
		
		answer = sbuild.toString();
		
		return answer;
	}
}