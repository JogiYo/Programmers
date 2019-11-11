package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Stock Price
// for loop
public class Level2_10 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int[] prices = new int[input.length];
		for(int i = 0; i < input.length; i++) {
			prices[i] = Integer.parseInt(input[i]);
		}
		
		int[] result = solution(prices);
		
		for(int i = 0; i < result.length; i++) {
			sb.append(result[i] + " ");
		}
		System.out.print(sb);
	}
	
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < answer.length-1; i++) {
        	for(int j = i + 1; j < answer.length; j++) {
        		if(prices[i] > prices[j]) {
        			answer[i] = j-i;
        			break;
        		}
        		if(j == answer.length-1) answer[i] = j-i;
         	}
        }
        
        return answer;
    }
}
