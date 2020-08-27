package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Pressing Keypad (2020 KAKAO Internship)
// using a conditional sentence
public class Level1_36 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input1 = br.readLine().split(", ");
		int[] numbers = new int[input1.length];
		String hand = br.readLine();
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(input1[i]);
		}
		sb.append(solution(numbers, hand) + "");
		
		System.out.print(sb);
	}
	
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        
        int left_row = 3;
        int left_col = 0;
        int right_row = 3;
        int right_col = 2;
        
        for(int i = 0 ; i < numbers.length; i++) {
        	int num = numbers[i];
        	if(num == 0) num = 11;
        	if(num % 3 == 1) {
        		left_row = num / 3;
        		left_col = 0;
        		answer += "L";
        	}
        	else if(num % 3 == 0) {
        		right_row = (num / 3) - 1;
        		right_col = 2;
        		answer += "R";
        	}
        	else {
        		int num_row = num / 3;
        		int num_col = 1;
        		int left_dist = Math.abs(left_row - num_row) + Math.abs(left_col - num_col);
        		int right_dist = Math.abs(right_row - num_row) + Math.abs(right_col - num_col);
        		
        		if(left_dist < right_dist) {
        			left_row = num_row;
        			left_col = num_col;
        			answer += "L";
        		}
        		else if(left_dist == right_dist) {
        			if(hand.equals("right")) {
        				right_row = num_row;
            			right_col = num_col;
            			answer += "R";
        			}
        			else {
        				left_row = num_row;
            			left_col = num_col;
            			answer += "L";
        			}
        		}
        		else {
        			right_row = num_row;
        			right_col = num_col;
        			answer += "R";
        		}
        	}
        }
        return answer;
    }
}