package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// Programmers Level 2 : Ramen Factory
// Category : Heap (Using PriorityQueue)
public class Level2_24 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int stock = Integer.parseInt(br.readLine());
		String[] input_1 = br.readLine().split(", ");
		String[] input_2 = br.readLine().split(", ");
		int[] dates = new int[input_1.length];
		int[] supplies = new int[input_2.length];
		
		for(int i = 0; i < dates.length; i++) {
			dates[i] = Integer.parseInt(input_1[i]);
			supplies[i] = Integer.parseInt(input_2[i]);
		}
		
		int k = Integer.parseInt(br.readLine());
		
		sb.append(solution(stock, dates, supplies, k) + "");
		System.out.print(sb);
	}
	
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // Flour is used from today's day 0 and examines to the amount available on day k-1.
        int idx = 0;
        for(int i = 0; i < k; i++) {
        	// When flour is fed, add to the queue.
        	if(idx < dates.length && i == dates[idx]) {
        		pq.add(supplies[idx++]);
        	}
        	
        	// When flour is needed, it is supplied with the largest flour available.
        	if(stock == 0) {
        		stock += pq.poll();
        		answer++;
        	}
        	
        	stock--;
        }
        return answer;
    }
}