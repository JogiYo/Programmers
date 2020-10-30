package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// Programmers Level 3 : Overtime index
// using PriorityQueue
public class Level3_29 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
 		String[] input = br.readLine().split(", ");
 		int[] works = new int[input.length];
 		
 		for(int i = 0; i < works.length; i++) {
 			works[i] = Integer.parseInt(input[i]);
 		}
 		
 		sb.append(solution(n, works) + "");
		System.out.print(sb);
	}
	
	public static long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < works.length; i++) {
        	pq.offer(works[i]);
        }
        // Subtract 1 from the largest task every hour.
        // ex) n =4, works{4, 3, 3} -> 3, 3, 3 -> 3, 3, 2 -> 3, 2, 2 -> 2, 2, 2
        // This way, the overtime index is minimal.
        for(int i = 0; i < n; i++) {
        	if(pq.isEmpty()) break;
        	int num = pq.poll();
        	if(num != 1) pq.offer(num-1);
        }
        
        while(!pq.isEmpty()) {
        	answer += Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}
