package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2: numerical representation
// Using double loop. can use hydrostatic theory, but I don't know.
public class Level2_31 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static int solution(int n) {
        int answer = 1;
        int range = n/2 + 1;
        int x = 1;
        int sum = 0;
        // Except for n itself, you only need to search half the way.
        while(x <= range) {
        	for(int i = x; i <= range; i++) {
        		sum += i;
        		if(sum == n) {
        			answer++;
        			break;
        		}
        	}
        	sum = 0;
        	x++;
        }
        
        return answer;
    }
}