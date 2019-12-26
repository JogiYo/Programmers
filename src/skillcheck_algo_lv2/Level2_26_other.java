package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Level2_26_other {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static int solution(int n) {
        int answer = n+1;
        int one_count = Integer.bitCount(n);
        
        while(true) {
        	if(Integer.bitCount(answer) == one_count) break;
        	else answer++;
        }
        
        return answer;
    }
}