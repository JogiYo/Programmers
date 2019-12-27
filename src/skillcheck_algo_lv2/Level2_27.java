package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Programmers Level 2: Take a group photo(2017 KAKAO CODE)
// Using Permutation and Brute force
public class Level2_27 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		String[] data = br.readLine().split(", ");
		
		sb.append(solution(n, data) + "");
		System.out.print(sb);
	}
	
	// List the number of all cases using the performance.
	public static int solution(int n, String[] data) {
        int answer = 0;
        
        char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        ArrayList<String> arr = new ArrayList<>();
        
        perm(arr, friends, 0, 8, 8);
        
        String[][] cond = new String[n][5];
        
        for(int i = 0; i < n; i++) {
        	String[] input = data[i].split("");
        	for(int j = 0; j < 5; j++) {
        		cond[i][j] = input[j];
        	}
        }
        
        // The possible number of people between the two is important.
        // If the conditions are not met, break the loop.
        // If the conditions are met, do +1 in the answer.
        for(int i = 0; i < arr.size(); i++) {
        	boolean flag = true;
        	for(int j = 0; j < n; j++) {
        		// 'distance' is a variable that tells how many people there are between two people.
        		int distance = Math.abs(arr.get(i).indexOf(cond[j][0]) - arr.get(i).indexOf(cond[j][2])) - 1;
        		
        		if(cond[j][3].equals("=") && distance != Integer.parseInt(cond[j][4])) {
        			flag = false;
        			break;
        		}
        		else if(cond[j][3].equals(">") && distance <= Integer.parseInt(cond[j][4])) {
        			flag = false;
        			break;
        		}
        		else if(cond[j][3].equals("<") && distance >= Integer.parseInt(cond[j][4])) {
        			flag = false;
        			break;
        		}
        	}
        	if(flag) answer++;
        }
        
        return answer;
    }

	private static void perm(ArrayList<String> arr, char[] friends, int depth, int n, int r) {
		if(depth == r) {
			StringBuilder st = new StringBuilder();
			for(int i = 0; i < r; i++) st.append(friends[i]);
			arr.add(String.valueOf(st));
		}
		
		for(int i = depth; i < n; i++) {
			swap(friends, depth, i);
			perm(arr, friends, depth + 1, n, r);
			swap(friends, depth, i);
		}
	}

	private static void swap(char[] friends, int depth, int i) {
		char temp = friends[depth];
		friends[depth] = friends[i];
		friends[i] = temp;
	}
}