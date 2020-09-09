package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// Programmers Level 3 : Immigration
// 
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
        long left = 0, mid = 0, sum = 0;
        Arrays.sort(times);
        long right = times.length * times[times.length-1];
        answer = right;
        
        while(left <= right) {
        	sum = 0;
        	mid = (left + right) / 2;
        	for(int i : times) {
        		sum += mid / i;
        	}
        }
        
        return answer;
    }
}