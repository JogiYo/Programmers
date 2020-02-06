package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Level3_1_recursive {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		int[] ans = solution(n);
		
		for(int i = 0; i < ans.length; i++) {
			sb.append(ans[i] + " ");
		}
		
		System.out.print(sb);
	}
	
	public static int[] solution(int n) {
		if(n == 1) return new int[] {0};
		int[] temp = solution(n-1);
		int[] answer = new int[temp.length*2 + 1];
		
		for(int i = 0; i < answer.length; i++) {
			if(i < temp.length) answer[i] = temp[i];
			else if(i == temp.length) answer[i] = 0;
			else answer[i] = temp[answer.length-1-i] == 1 ? 0 : 1;
		}
		return answer;
    }
}