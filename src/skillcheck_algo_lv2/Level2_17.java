package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// Programmers Level 2 : The largest number
// sorting, Using comparator
public class Level2_17 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int[] number = new int[input.length];
		
		for(int i = 0; i < number.length; i++) {
			number[i] = Integer.parseInt(input[i]);
		}
		
		sb.append(solution(number));
		System.out.print(sb);
	}
	
	public static String solution(int[] numbers) {
		String answer = "";
		
		String[] s_number = new String[numbers.length];
		
		for(int i = 0; i < s_number.length; i++) {
			s_number[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(s_number, new Comparator<String>() {
			@Override
			public int compare(String n1, String n2) {
				return (n2+n1).compareTo(n1+n2);
			}
		});
		
		// Consider when there are multiple zeros. ex) "0000" = 0
		if(s_number[0].equals("0")) {
			answer = "0";
		} else {
			for(int i = 0; i < s_number.length; i++) {
				answer += s_number[i];
			}
		}
		
		return answer;
	}
}