package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// Programmers Level 3 : Immigration
// using binary search
public class Level3_18 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(", ");
		int[] times = new int[input.length];
		
		for(int i = 0; i < times.length; i++) {
			times[i] = Integer.parseInt(input[i]);
		}
		
		sb.append(solution(n, times) + " ");
		System.out.print(sb);
	}
	
	public static long solution(int n, int[] times) {
        long answer = 0;
        // Total time required for immigration
        // left : minimum, right : maximum 
        long left = 0, mid = 0, sum = 0;
        Arrays.sort(times);
        // The times array is of type int, so it needs casting
        long right = (long)n * times[times.length-1];
        answer = right;
        
        // Finding out if the sum of the number of jobs processed 
        // at each immigration desk is N
        while(left <= right) {
        	sum = 0;
        	mid = (left + right) / 2;
        	for(int i : times) {
        		sum += mid / i;
        	}
        	
        	if(sum >= n) {
        		if(mid <= answer) answer = mid;
        		right = mid - 1;
        	}
        	else left = mid + 1;
        }
        
        return answer;
    }
}