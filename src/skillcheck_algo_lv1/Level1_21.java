package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// Programmers Level 1 : Place integers in descending order
public class Level1_21 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long n = Long.parseLong(br.readLine());
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static long solution(long n) {
		String[] arr = Long.toString(n).split("");
		Arrays.sort(arr, Collections.reverseOrder());
		String ans = "";
		
		for(int i = 0; i < arr.length; i++) {
			ans += arr[i];
		}
		
		long answer = Long.parseLong(ans);
		return answer;
	}
}