package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// Programmers Level 2 : Life boat
// Category : Greedy Algorithm
// Rather than just sorting one after another, we compare the minimum and maximum values.
public class Level2_21 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int[] people = new int[input.length];
		
		for(int i = 0; i < people.length; i++) {
			people[i] = Integer.parseInt(input[i]);
		}
		
		int limit = Integer.parseInt(br.readLine());
		
		sb.append(solution(people, limit) + "");
		System.out.print(sb);
	}
	
	public static int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		
		int i =0, j =0;
		
		for(i = people.length-1; i > j; i--) {
			// When the sum of the minimum and maximum is less than the limit
			if(people[i] + people[j] <= limit) {
				j++;
				answer++;
			}
			else answer++;
		}
		
		// If i and j are the same, the last one is left 
		// and it is not processed in the loop, so it is processed separately.
		if(i == j) answer++;
		
		return answer;
	}
}
