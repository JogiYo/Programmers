package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Programmers Level 2 : Ponketmon
// Using List, may use a HashSet.
public class Level2_30 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int[] num = new int[input.length];
		
		for(int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(input[i]);
		}
		sb.append(solution(num) + "");
		System.out.print(sb);
	}
	
	public static int solution(int[] nums) {
        int len = nums.length/2;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
        	if(!list.contains(nums[i])) {
        		if(list.size() == len) return list.size();
        		else list.add(nums[i]);
        	}
        }
        
        return list.size();
    }
}