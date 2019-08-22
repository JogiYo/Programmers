package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// Programmers Level 1 : Arrange strings in descending order
// Use ASCII : 'A-Z' -> '65 - 90' , 'a-z' -> '97 - 122'
public class Level1_11 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		sb.append(solution(input) + "");
		System.out.print(sb);
	}
	
	public static String solution(String s) {
		String answer = "";
		String[] arr = s.split("");
		Arrays.sort(arr, Collections.reverseOrder());
		answer = String.join("", arr);
		return answer;
	}
}