package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Number of factors and addition (Monthly Code Challenge Season 2)
public class Level1_43 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(", ");
		int left = Integer.parseInt(input[0]);
		int right = Integer.parseInt(input[1]);
 		
		sb.append(solution(left, right) + "");
		System.out.print(sb);
	}
	
	public static int solution(int left, int right) {
        int answer = 0;
        
        // When dividing by a square number, 
        // if the remainder is 0, the number of factors is odd.
        for(int i = left; i <= right; ++i) {
        	if(i % Math.sqrt(i) == 0) answer -= i;
        	else answer += i;
        }
        
        return answer;
    }
	
	public static int solution_use_for(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; ++i) {
        	int count = 0;
        	for(int j = 1; j <= i; ++j) {
        		if(i % j == 0) count++;
        	}
        	
        	if(count % 2 == 0) answer += i;
        	else answer -= i;
        }
        
        return answer;
    }
}