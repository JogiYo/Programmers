package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Programmers Level 2 : Make Prime Number
// Using combination(brute force)
public class Level2_39 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(",");
		int[] nums = new int[input.length];
		
		for(int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(input[i]);
		}
		
		sb.append(solution(nums) + "");
		System.out.print(sb);
	}
	
	public static int solution(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        ArrayList<Integer> list = new ArrayList<>();
        // nCr -> nC3
        combination(nums, visited, list, 0, nums.length, 3);
        // size is a number of prime number case
        return list.size();
    }

	private static void combination(int[] nums, boolean[] visited, ArrayList<Integer> list, int start, int n, int r) {
		if(r == 0) {
			int value = 0;
			for(int i = 0; i < n; i++) {
				if(visited[i] == true) {
					value += nums[i];
				}
			}
			
			if(isPrime(value)) list.add(value);
		}
		else {
			for(int i = start; i < n; i++) {
				visited[i] = true;
				combination(nums, visited, list, i+1, n, r-1);
				visited[i] = false;
			}
		}
	}

	private static boolean isPrime(int value) {
		if(value <= 1) return false;
		
		for(int i = 2; i <= Math.sqrt(value); i++) {
			if(value % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}