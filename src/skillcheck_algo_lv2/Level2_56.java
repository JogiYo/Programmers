package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Iterating through binary transformation
// using while loop
public class Level2_56 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String s = br.readLine();
		int[] result = solution(s);
		sb.append(result[0] + ", " + result[1]);;
		System.out.print(sb);
	}
	
	public static int[] solution(String s) {
        int[] answer = new int[2];
        int conv_cnt = 0;
        int zero_cnt = 0;
        
        while(!s.equals("1")) {
        	conv_cnt++;
        	int post_length = s.length();
        	s = s.replaceAll("0", "");
        	int cur_length = s.length();
        	zero_cnt += post_length - cur_length;
        	s = Integer.toBinaryString(cur_length);
        }
        
        answer[0] = conv_cnt;
        answer[1] = zero_cnt;
        return answer;
    }
}