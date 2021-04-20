package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Adding negative and positive numbers (Monthly Code Challenge Season 2)
// using conditional sentence
public class Level1_41 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input_1 = br.readLine().split(",");
		String[] input_2 = br.readLine().split(",");
		
		int[] absolutes = new int[input_1.length];
		boolean[] signs = new boolean[input_2.length];
		
		for(int i = 0; i < signs.length; ++i) {
			absolutes[i] = Integer.parseInt(input_1[i]);
			signs[i] = Boolean.parseBoolean(input_2[i]);
		}
 		
		sb.append(solution(absolutes, signs) + "");
		System.out.print(sb);
	}
	
	public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i = 0; i < absolutes.length; ++i) {
        	if(signs[i]) answer += absolutes[i];
        	else answer -= absolutes[i];
        }
        
        return answer;
    }
}