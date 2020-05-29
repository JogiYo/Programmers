package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Level3_10 {
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
        int answer = 0;
        int max = 0;
        
        for(int budget : budgets) {
        	max = Math.max(budget, max);
        }
        
        int left = 0;
        int right = max;
        
        while(left < right) {
        	int mid = (left + right) / 2;
        	
        	long sum = 0;
        	for(int budget : budgets) {
        		if(budget > mid) {
        			sum += mid;
        		}
        		else {
        			sum += budget;
        		}
        	}
        	
        	if(sum > M) {
        		right = mid - 1;
        	}
        	else {
        		left = mid + 1;
        		answer = Math.max(answer, mid);
        	}
        }
        
        return answer;
    }
}