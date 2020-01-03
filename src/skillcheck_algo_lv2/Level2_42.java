package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Estimated Round
public class Level2_42 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(",");
		int[] list = new int[3];
		
		for(int i = 0; i < 3; i++) {
			list[i] = Integer.parseInt(input[i]);
		}
		sb.append(solution(list[0], list[1], list[2]) + "");
		System.out.print(sb);
	}
	
	public static int solution(int n, int a, int b) {
        int answer = 0;
        // The time when A and B become the same is the round when they meet.
        while(a != b) {
        	a = (a+1) / 2;
        	b = (b+1) / 2;
        	answer++;
        }
        return answer;
    }	
}