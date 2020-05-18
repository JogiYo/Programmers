package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Level3_6 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		int[][] computers = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(", ");
			for(int j = 0; j < input.length; j++) {
				computers[i][j] = Integer.parseInt(input[j]);
			}
		}
		sb.append(solution(n, computers) + "");
		System.out.print(sb);
	}
	
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        
        for(int i = 0; i < computers.length; i++) {
        	for(int j = i; j < computers[0].length; j++) {
        		if(computers[i][j] == 0) answer++;
        	}
        }
        return answer;
    }
}
