package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// programmers, skill_check Lv2 : carpet problem
// Search to find the appropriate value.
public class Level2_2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int brown = Integer.parseInt(input[0]);
		int red = Integer.parseInt(input[1]);
		
		int[] answer = solution(brown, red);
		sb.append("[");
		for(int i = 0; i < answer.length-1; i++) {
			sb.append(answer[i] + ",");
		}
		sb.append(answer[answer.length-1] + "]");
		System.out.print(sb);
	}
	
	public static int[] solution(int brown, int red) {
		int width = 0;
		int height = 0;
		
		for(int i = 1; i <= red/2 + 1; i++) {
			width = i;
			if(red%i == 0) {
				height = red/width;
				if(2*width + 2*height + 4 == brown) break;
			}
		}
		
		int[] answer = {Math.max(width, height)+2, Math.min(width, height)+2};
		return answer;
	}
}