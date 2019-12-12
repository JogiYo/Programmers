package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// Programmers Level 2 : Camouflage (Same as the BOJ 9375 problem)
// Using HashMap
public class Level2_22 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int len = Integer.parseInt(input[0]);
		String[][] clothes = new String[len][2];
		
		for(int i = 0; i < len; i++) {
			clothes[i] = br.readLine().split(", ");
		}
		
		sb.append(solution(clothes) + "");
		System.out.print(sb);
	}
	
	public static int solution(String[][] clothes) {
        int answer = 1;   
        HashMap<String, Integer> map = new HashMap<>();
        
        // If it's the same type of clothes, increase it by 1; 
        // if not, insert it with Count 1.
        for(int i = 0; i < clothes.length; i++) {
        	if(map.containsKey(clothes[i][1])) {
        		map.replace(clothes[i][1], map.get(clothes[i][1])+1);
        	}
        	else {
        		map.put(clothes[i][1], 1);
        	}
        }
        
        // All possible cases are (a+1)*(b+1)*(c+1)*...*(n+1) - 1
        // The reason for subtracting 1 is that you have to wear more than one outfit.
        for(int val : map.values() ) {
        	answer *= (val+1);
        }
        
        return answer-1;
    }
}