package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Programmers, check_lv1_2
// Problems of arrangement d with the amount requested by department 
// and how many departments can support the goods when given as parameters.
public class check_lv1_2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int budget = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] d = new int[st.countTokens()];
		for(int i = 0; i < d.length; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		sb.append(solution(d, budget) + "");
		System.out.print(sb);
	}
	
	public static int solution(int[] d, int budget) {
	      int answer = 0;
	      
	      Arrays.sort(d);

	      for(int i = 0; i < d.length; i++) {
	    	  budget -= d[i];
	    	  if(budget < 0) break;
	    	  answer++;
	      }
	      return answer;
	  }
}