package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmer Level 2 : Jump and Teleport
// Using loop
public class Level2_40 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	// If you can teleport, it is the minimum value to make the most of the teleport.
	public static int solution(int n) {
        int ans = 0;
        
        while(n > 0) {
        	if(n % 2 == 1) {
        		n -= 1;
        		ans++;
        	}
        	n /= 2;
        }
        
        return ans;
    }
}