package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// Programmers Level 2 : printer
// Using Queue and iterator
public class Level2_11 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int[] priorities = new int[input.length];
		for(int i = 0; i < input.length; i++) {
			priorities[i] = Integer.parseInt(input[i]);
		}
		
		int location = Integer.parseInt(br.readLine());
		
		sb.append(solution(priorities, location));
		System.out.print(sb);
	}
	
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Pair> queue = new LinkedList<Pair>();
        Iterator<Pair> iter = null;
        
        for(int i = 0; i < priorities.length; i++) {
        	queue.offer(new Pair(i, priorities[i]));
        }
        
        // Condition
        // 1. Pop the frontmost document (J) from the print queue.
        // 2. If there is any document of greater importance than J in the remaining print queues,
        //    put J at the end of the queue.
        // 3. Otherwise, print J.
        while(!queue.isEmpty()) {
        	Pair temp = queue.poll();
        	boolean bigger = false;
        	// Iterator for search
        	iter = queue.iterator();
        	
        	while(iter.hasNext()) {
        		if(temp.priority < iter.next().priority) {
        			bigger = true;
        			break;
        		}
        	}
        	
        	if(bigger) {
        		queue.offer(temp);
        	}
        	else {
        		if(temp.location == location) {
        			answer++;
        			break;
        		}
        		answer++;
        	}
        }
        
        return answer;
    }
	
	static class Pair {
		int location;
		int priority;
		
		public Pair(int location, int priority) {
			super();
			this.location = location;
			this.priority = priority;
		}
	}
}