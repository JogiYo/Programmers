package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// Programmers Level 1 : Pick two number and add (Monthly Code Challenge Season 1)
// using arrays.sort
public class Level1_37 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int[] numbers = new int[input.length];
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		int[] result = solution(numbers);
		for(int i = 0; i < result.length; i++) {
			sb.append(result[i] + " ");
		}
		System.out.print(sb);
	}
	
	public static int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < numbers.length - 1; i++) {
        	for(int j = i+1; j < numbers.length; j++) {
        		int num = numbers[i] + numbers[j];
        		if(!list.contains(num)) list.add(num);
        	}
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
}
