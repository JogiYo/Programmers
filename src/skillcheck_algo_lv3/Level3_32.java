package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Programmers Level 3 : How to line up
// Find an efficient way
public class Level3_32 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int n = Integer.parseInt(input[0]);
		long k = Long.parseLong(input[1]);
		
		int[] result = solution(n, k);
		
		for(int i = 0; i < result.length; i++) {
			if(i == 0) sb.append(result[i]);
			else sb.append(", " + result[i]);
		}
		System.out.print(sb);
	}
	// Using permutation causes a timeout.
	// Find a way to find a number in a specific place.
	public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        long facto = 1;
        for(int i = 1; i <= n; i++) {
        	list.add(i);
        	facto *= i;
        }
        k--; // k starts from 0
        
        int idx = 0;
        while(n > 0) {
        	facto /= n;  // ex) (1, 2, 3), find 5th. facto = 6/3 = 2  
        	answer[idx++] = list.get((int)(k/facto)); // k/facto = 4/2 = 2 -> 3
        	list.remove((int)(k/facto));
        	k %= facto;
        	n--;
        }
        return answer;
    }
}