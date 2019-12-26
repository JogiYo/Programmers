package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2: the next big number
// Using while loop
public class Level2_26 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static int solution(int n) {
        int answer = n+1;
        int n_temp = n;
        int n_one_count = 0;
        
        while(n_temp != 0) {
        	if(n_temp % 2 == 1) n_one_count++;
        	n_temp /= 2;
        }
        
        while(true) {
        	int one_count = 0;
        	int answer_temp = answer;
        	
        	while(answer_temp != 0) {
        		if(answer_temp % 2 == 1) one_count++;
            	answer_temp /= 2;
        	}
        	
        	if(one_count == n_one_count) break;
        	else answer++;
        }
        
        return answer;
    }
}