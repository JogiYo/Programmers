package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// Programmers Level 3 : budget
// using Binary search
// loop
public class Level3_10_other {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int[] budgets = new int[input.length];
		
		for(int i = 0; i < input.length; i++) {
			budgets[i] = Integer.parseInt(input[i]);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		sb.append(solution(budgets, M) + "");
		System.out.print(sb);
	}
	
	public static int solution(int[] budgets, int M) {
		Arrays.sort(budgets);
        int left = 0; 
        int right = budgets[budgets.length - 1];
        while(left <= right) {
            int mid = (left + right) / 2;
            
            int sum = 0;
            for(int budget : budgets) {
            	if(budget > mid) {
            		sum += mid;
            	}
            	else {
            		sum += budget;
            	}
        	}
            if(sum > M) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }
}
