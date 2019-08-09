package skillcheck_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers, skill_check Lv1
// Problem of creating n sequence with x spacing when given x
public class check_lv1_4 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int x = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		
		long[] answer = solution(x, n);
		sb.append("{");
		for(int i = 0; i < answer.length-1; i++) {
			sb.append(answer[i] + ", ");
		}
		sb.append(answer[answer.length-1]+"}");
		System.out.print(sb);
	}
	
	public static long[] solution(int x, int n) {
	      long[] answer = new long[n];
	      long interval = x;
	      for(int i = 0; i < n; i++) {
	          answer[i] = interval;
	          interval += x;
	      }
	      return answer;
	}
}