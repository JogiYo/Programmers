package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level2 : Number of country 124
// Not use recursive function.
public class Level2_4_not_recursive {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static String solution(int n) {
		String answer = "";
		String[] num = {"4", "1", "2"};
		
		while(n > 0) {
			answer = num[n%3] + answer;
			n = (n-1) / 3;
		}
		
		return answer;
	}
}
