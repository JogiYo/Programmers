package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : 3-diagnosis inversion
// using loop
public class Level1_38 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	public static int solution(int n) {
        int answer = 0;
        String num = "";
        
        while(n > 0) {
        	num = n%3 + num;
        	n /= 3;
        }
        
        for(int i = 0; i < num.length(); i++) {
        	answer += Math.pow(3, i) * Character.getNumericValue(num.charAt(i));
        }
        
        return answer;
    }
}