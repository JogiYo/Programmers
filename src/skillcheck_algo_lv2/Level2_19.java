package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// Programmers Level 2 : More spicy
// Category : Heap  -> Using Priority Queue
public class Level2_19 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int[] scoville = new int[input.length];
		
		for(int i = 0; i < scoville.length; i++) {
			scoville[i] = Integer.parseInt(input[i]);
		}
		
		int k = Integer.parseInt(br.readLine());
		sb.append(solution(scoville, k) + "");
		System.out.print(sb);
	}
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        // If the sort criteria is descending, use Collections.reversOrder
        // ex)  PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reversOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i : scoville) {
        	pq.offer(i);
        }
        
        while(pq.peek() <= K) {
        	if(pq.size() == 1) return -1;
        	
        	int a = pq.poll();
        	int b = pq.poll();
        	
        	pq.offer(a+(b*2));
        	answer++;
        }
        
        return answer;
	}
}