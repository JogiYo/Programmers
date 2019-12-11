package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// Programmers Level 2 : H-Index
// The problem is to find the maximum value of h-index after sorting.
public class Level2_20 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int[] citations = new int[input.length];
		
		for(int i = 0; i < citations.length; i++) {
			citations[i] = Integer.parseInt(input[i]);
		}
		
		sb.append(solution(citations) + "");
		System.out.print(sb);
	}
	
	public static int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		
		// Think about the number of elements
		for(int i = 0; i < citations.length; i++) {
			if(citations.length - i <= citations[i]) {
				answer = citations.length - i;
				break;
			}
		}
		
		return answer;
	}
}
