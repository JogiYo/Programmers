package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// Programmers Level 3 : Dual priority queue
// using priority queue.
public class Level3_19 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] operations = br.readLine().split(",");
		
		int[] result = solution(operations);
		sb.append(result[0] + " " + result[1]);
		System.out.print(sb);
	}
	
	public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(String op : operations) {
        	char oper = op.charAt(0);
        	String[] input = op.split(" ");
        	int num = Integer.parseInt(input[1]);
        	
        	if(oper == 'I') {
        		pq.offer(num);
        	}
        	else {
        		if(!pq.isEmpty()) {
        			if(num == -1) {
        				pq.poll();
        			}
        			else {
        				PriorityQueue<Integer> temp_qu = new PriorityQueue<>();
        				int size = pq.size()-1;
        				for(int i = 0; i < size; i++) {
        					temp_qu.add(pq.poll());
        				}
        				pq = temp_qu;
        			}
        		}
        	}
        }
        
        if(pq.size() == 1) {
        	answer[0] = answer[1] = pq.poll();
        }
        else if(pq.size() > 1) {
        	answer[1] = pq.poll();
        	int size = pq.size()-1;
        	for(int i = 0; i < size; i++) {
        		pq.poll();
        	}
        	answer[0] = pq.poll();
        }
        return answer;
    }
}