package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : Express as N (Using dfs)
public class Level3_4_dfs {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int number = Integer.parseInt(input[1]);
		
		sb.append(solution(N, number) + "");
		System.out.print(sb);
	}
	
	static int answer = -1;
	
	public static int solution(int N, int number) {
		if(N == number) return 1;
		
		dfs(N, number, 0 ,0);
		return answer;
    }

	// Run with dfs incrementing the count of N
	// Store the value and verify that it is equal to number
	private static void dfs(int N, int number, int count, int prev) {
		int temp_N = N;
		if(count > 8) {
			answer = -1;
			return;
		}
		
		if(number == prev) {
			if(answer == -1 || answer > count) {
				answer = count;
			}
			return;
		}
		
		for(int i = 0; i < 8-count; i++) {
			dfs(N, number, count+i+1, prev + temp_N);
			dfs(N, number, count+i+1, prev - temp_N);
			dfs(N, number, count+i+1, prev * temp_N);
			dfs(N, number, count+i+1, prev / temp_N);
			
			temp_N = temp_N*10 + N;
		}
	}
}