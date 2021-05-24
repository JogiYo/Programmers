package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : 2 or less different bits(Monthly Code Challenge Season 2)
public class Level2_62 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(", ");
		long[] numbers = new long[input.length];
		
		for(int i = 0; i < numbers.length; ++i) {
			numbers[i] = Long.parseLong(input[i]);
		}
		
		long[] result = solution(numbers);
		sb.append(result[0] + "");
		for(int i = 1; i < result.length; ++i) {
			sb.append(", " + result[i]);
		}
		System.out.print(sb);
	}
	
	public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; ++i) {
        	String bit_str = "0" + Long.toBinaryString(numbers[i]);
        	// When it is even, only the lowest position 0 is replaced.
        	// In fact, the last digit is 0, so you only need to do +1.
        	if(numbers[i] % 2 == 0) answer[i] = numbers[i] + 1;
        	// When it is odd
        	// Search for "01", which appears first from the back.
        	// And if you change this part to "10", it becomes the smallest value that can be made by changing only 2 bits.
        	else {
        		int last_idx = bit_str.lastIndexOf("0");
        		int first_idx = bit_str.indexOf("1", last_idx);
        		
        		bit_str = bit_str.substring(0, last_idx) + "10" + bit_str.substring(first_idx+1);
        		answer[i] = Long.parseLong(bit_str, 2);
        	}
        }
        
        return answer;
    }
}