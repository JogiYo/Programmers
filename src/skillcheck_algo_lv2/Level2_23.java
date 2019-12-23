package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Target Number
// Category DFS and BFS (Using DFS)
public class Level2_23 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int[] numbers = new int[input.length];
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		
		int target = Integer.parseInt(br.readLine());
		
		sb.append(solution(numbers, target) + "");
		System.out.print(sb);
	}
	
	public static int solution(int[] numbers, int target) {
        int answer = 0;   
    
        answer = dfs(numbers, target, 0 , 0);
 
        return answer;
    }

	// Consider a Binary Tree
	private static int dfs(int[] numbers, int target, int depth, int sum) {
		// Compare the sum to the target at the end node.
		if(depth == numbers.length) {
			return sum == target ? 1 : 0;
		}
		// example : numbers = {1, 1, 1, 1, 1}
		// {0} -> {{1}, {-1}} -> {{1+1}, {1-1}, {-1+1}, {-1-1}}....
		// -> {{1+1+1+1+1}, ... , {-1-1-1-1-1}}
		// Consider adding and subtracting in this way.
		else {
			return dfs(numbers, target, depth+1, sum + numbers[depth])
					+ dfs(numbers, target, depth+1, sum - numbers[depth]);
		}
	}
}