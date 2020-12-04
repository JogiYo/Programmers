package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// Programmers Level 3 : Crossing the stepping stone
// using binary search
public class Level3_37 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int[] stones = new int[input.length];
		
		for(int i = 0; i < stones.length; ++i) {
			stones[i] = Integer.parseInt(input[i]);
		}
		
		int k = Integer.parseInt(br.readLine());
		
		sb.append(solution(stones, k) + "");
		System.out.print(sb);
	}
	
	public static int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = Arrays.stream(stones).max().getAsInt();
        int mid = 0;
        
        while(left <= right) {
        	mid = (left + right)/2;
        	int count = 0; // variable that tells you how many consecutive arrays have zero values.
        	boolean flag = true;
        	
        	for(int i = 0; i < stones.length; i++) {
        		int cur = stones[i] - mid;
        		if(cur >= 0) count = 0;
        		else count++;
        		// When 'count' equals k, the loop is stopped because no more bridges can be crossed.
        		if(count >= k) {
        			flag = false;
        			break;
        		}
        	}
        	
        	if(flag) {
        		left = mid + 1;
        		answer = answer > mid ? answer : mid;
        	}
        	else right = mid - 1;
        }
        return answer;
    }
}