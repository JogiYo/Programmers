package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// Programmers Level 2 : Candidate Key (2019 KAKAO BLIND RECRUITMENT)
// Using Bit Mask
public class Level2_47 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int row = Integer.parseInt(input[0]);
		int col = Integer.parseInt(input[1]);
		String[][] relation = new String[row][col];
		
		for(int i = 0; i < row; i++) {
			String[] split = br.readLine().split(",");
			for(int j = 0; j < col; j++) {
				relation[i][j] = split[j];
			}
		}
		
		sb.append(solution(relation) + "");
		System.out.print(sb);
	}
	
	public static int solution(String[][] relation) {
        int n = relation.length;
        int m = relation[0].length;
        List<Integer> answer = new ArrayList<>();
        
        // From 1 to the full set (1 << m) -1
        // ex) m = 4, 1 to 2^4-1 (0001 ~ 1111)
        for(int i = 1; i <=(1<<m)-1; i++) {
        	Set<String> set = new HashSet<>();
        	
        	for(int j = 0; j < n; j++) {
        		StringBuilder sb = new StringBuilder();
        		for(int k = 0; k < m; k++) {
        			if(( i & (1<<k)) > 0) {
        				// If integer k is included in bit mask i
        				sb.append(relation[j][k]);
        			}
        		}
        		set.add(sb.toString());
        	}
        	// Check for Uniqueness and Minimality
        	if(set.size() == n && check(answer,i)) {
        		answer.add(i);
        	}
        }
        
        return answer.size();
    }
	// Check for Minimality
	private static boolean check(List<Integer> answer, int current) {
		for(int i = 0; i < answer.size(); i++) {
			if((answer.get(i) & current) == answer.get(i)) {
				return false;
			}
		}
		return  true;
	}
}