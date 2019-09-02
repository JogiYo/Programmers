package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers, Level 1 : Collatz Guess
// Out of range may occur during calculation.
// So we do the calculation with long instead of int.
public class Level1_26 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static int solution(int num) {
		int answer = 0;
		long l_num = num;
		while(answer <= 500) {
			if(l_num == 1) return answer;
			else if(l_num % 2 == 0) {
				l_num /= 2;
			}
			else {
				l_num = l_num*3 + 1;
			}
			answer++;
		}
		return -1;
	}
}