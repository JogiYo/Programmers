package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : Pop the balloon
public class Level3_21 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(",");
		int[] a = new int[input.length];
		
		for(int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(input[i]);
		}
		
		sb.append(solution(a) + "");
		System.out.print(sb);
	}
	
	public static int solution(int[] a) {
        int answer = 0;
        int left = 1000000001, right = 1000000001;
        // 1.If the end of the number excluding both ends is less than the end excluding it,
        //   the number can remain until the end.
        
        // 2. After designating both ends as left and right, if the middle end is smaller than the end, 
        //    the middle end may be the end according to the original rule.
        for(int i = 0; i < a.length; i++) {
        	if(a[i] < left) {
        		left = a[i];
        		answer++;
        	}
        	
        	if(a[a.length-1-i] < right) {
        		right = a[a.length-1-i];
        		answer++;
        	}
        	
        	// However, if left and right are the same in the reduced result compared at both ends, 
        	// it is counted as overlapping, so it is calculated and returned in return.
        	if(left == right) break;
        }
        
        if(left == right) answer -= 1;
        return answer;
    }
}