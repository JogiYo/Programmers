package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Recommend new ID
// using Regular Expression
public class Level1_40 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		sb.append(solution(input) + "");
		
		System.out.print(sb);
	}
	
	public static String solution(String new_id) {
        String answer = "";
        // step 1
        answer = new_id.toLowerCase();
        // step 2
        answer = answer.replaceAll("[^-_.a-z0-9]", "");
        // step 3
        answer = answer.replaceAll("[.]{2,}", ".");
        // step 4
        answer = answer.replaceAll("^[.]|[.]$", "");
        // step 5
        if(answer.isEmpty()) answer = "a";
        // step 6
        if(answer.length() > 15) {
        	answer = answer.substring(0, 15);
        	answer = answer.replaceAll("^[.]|[.]$", "");
        }
        // step 7
        if(answer.length() < 3) {
        	while(answer.length() < 3) {
        		answer += answer.charAt(answer.length() - 1);
        	}
        }
        return answer;
    }
}