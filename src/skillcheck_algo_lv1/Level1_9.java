package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// Programmers, Level 1 : Arrange strings at will.
public class Level1_9 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		String[] answer = solution(str, n);
		
		sb.append("[" + answer[0] +",");
		for(int i = 1; i < answer.length-1; i++) {
			sb.append(answer[i] + ",");
		}
		sb.append(answer[answer.length-1] +"]");
		System.out.print(sb);
	}
	
	public static String[] solution(String[] strings, int n) {
		// Sort using Comparator. (Most important!)
		Arrays.sort(strings, new Comparator<String>() {

			@Override
			// Use charAt to compare the nth character.
			// Ascending order
			public int compare(String o1, String o2) {
				if(o1.charAt(n) > o2.charAt(n)) return 1;
				// compareTo() sorts two characters alphabetically.
				else if(o1.charAt(n) == o2.charAt(n)) return o1.compareTo(o2);
				else return -1;
			}
		});
		return strings;
	}
}
