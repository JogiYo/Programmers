package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// Programmers Level 3 : Jewelry shopping(2020 KAKAO Internship)
// Using HashSet, HashMap. not for loop
public class Level3_25 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] gems = br.readLine().split(", ");
		
		int[] ans = new int[2];
		
		ans = solution(gems);
		for(int i = 0; i < 2; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.print(sb);
	}
	
	public static int[] solution(String[] gems) {
		int[] answer = new int[2];
        
		Queue<String> qu = new LinkedList<String>();
		HashSet<String> hs = new HashSet<String>();
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
        int start_idx = 0;
        int length = 100001;
		// To save the number of types of gems.
        for(int i = 0; i < gems.length; i++) {
        	hs.add(gems[i]);
        }
		
        int start = 0;
        for(int i = 0; i < gems.length; i++) {
        	// This is the case with and without gems in the HashMap.
        	if(!hm.containsKey(gems[i])) {
        		hm.put(gems[i], 1);
        	}
        	else hm.put(gems[i], hm.get(gems[i])+1);
        	
        	qu.add(gems[i]);
        	
        	// If the number of first gems in the queue exceeds 1,
        	// start_idx is updated and subtracted from queue.
        	while(true) {
        		String temp = qu.peek();
        		if(hm.get(temp) > 1) {
        			qu.poll();
        			hm.put(temp, hm.get(temp)-1);
        			start_idx++;
        		}
        		else break;
        	}
        	
        	// If the jewels in the current queue include all jewels 
        	// and the newly obtained section is less than the length of the current section, 
        	// the start value, which is the final starting point value, is updated with length.
        	if(hm.size() == hs.size() && length > qu.size()) {
        		start = start_idx;
        		length = qu.size();
        	}
        }
        
        answer[0] = start + 1;
        answer[1] = start + length;
		return answer;
    }
}