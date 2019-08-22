package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class check_lv1_3 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int x = Integer.parseInt(br.readLine());
		sb.append(solution(x) + "");
		System.out.print(sb);
	}
	
	public static boolean solution(int x) {
		 boolean answer = true;
	      int sum = 0;
	      int temp = x;
	      
	      while(temp != 0) {
	          sum += temp%10;
	          temp /= 10;
	      } 
	      
	      if(x % sum != 0) answer = false; 
	      return answer;
	  }
}