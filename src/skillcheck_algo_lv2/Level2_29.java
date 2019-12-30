package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// Programmers Level 2 : Numerical baseball
// Using Brute Force
public class Level2_29 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		int[][] baseball = new int[n][3];
		
		while(n-- > 0) {
			String[] input = br.readLine().split(", ");
			
			for(int  i = 0; i < 3; i++) {
				baseball[n][i] = Integer.parseInt(input[i]);
			}
		}
		
		sb.append(solution(baseball) + "");
		System.out.print(sb);
	}
	
	public static int solution(int[][] baseball) {
        int answer = 0;
        Stack<String> stk = new Stack<>();
        
        // Add a non-redundant number to the stack.
        for(int i = 1; i < 10; i++) {
        	for(int j = 1; j < 10; j++) {
        		for(int k = 1; k < 10; k++) {
        			if(i != j && j != k && i != k) stk.add(String.valueOf(100*i + 10*j + k));
        		}
        	}
        }
        
        boolean flag = true;
        // brute force
        // If you want to know the numbers that meet the conditions, make a list.
        // ArrayList<Integer> list = new ArrayList<>();
        // ball = getBall - strike; Since all the numbers contained are counted, subtract the number of strikes
        while(!stk.isEmpty()) {
        	String num = stk.pop();
        	for(int i = 0; i < baseball.length; i++) {
        		int strike = getStrike(num, String.valueOf(baseball[i][0]));
        		int ball =  getBall(num, String.valueOf(baseball[i][0])) - strike;
        		
        		if(strike != baseball[i][1] || ball != baseball[i][2]) {
        			flag = false;
        			break;
        		}
        	}
        	// if(flag) list.add(num);
        	if(flag) answer++;
        	flag = true;
        }
        
        return answer;
    }
	// Strike should be in the same position.
	private static int getStrike(String num, String target_num) {
		int count = 0;
		for(int i = 0; i < target_num.length(); i++) {
			count = num.charAt(i) == target_num.charAt(i) ? count+1 : count;
		}
		return count;
	}
	// A ball counts if it contains a corresponding number.
	private static int getBall(String num, String target_num) {
		int count = 0;
		for(int i = 0; i < target_num.length(); i++) {
			count = num.contains(String.valueOf(target_num.charAt(i))) ? count+1 : count;
		}
		return count;
	}
}