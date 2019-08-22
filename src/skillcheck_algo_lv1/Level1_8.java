package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers, Level1 : The sum of all values between two integers.
public class Level1_8 {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		
		sb.append(solution(a,b) + "");
		System.out.print(sb);
	}
	
	public static long solution(int a, int b) {
		long answer = 0;
		
		if(a > b) {
			int temp;
			temp = a;
			a = b;
			b = temp;
		}
		
		for(int i = a; i <= b; i++) {
			answer += i;
		}
		return answer;
	}
}
