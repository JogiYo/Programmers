package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
// Programmers Level 3 : Disk Controller
// heap, using Priority queue, shortest job first(SJF) scheduling.
public class Level3_15 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		int[][] jobs = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(", ");
			jobs[i][0] = Integer.parseInt(input[0]);
			jobs[i][1] = Integer.parseInt(input[1]);
		}
		sb.append(solution(jobs) + "");
		
		System.out.print(sb);
	}
	
	public static int solution(int[][] jobs) {
        int total_time = 0; // Sum of time from request to termination
        int count = 0; // task count
        
        // Ascending order
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
            	if(o1[0] > o2[0]) return 1;
            	else if(o1[0] == o2[0]) {
            		if(o1[1] >= o2[1]) return 1;
            		else return -1;
            	}
            	else return -1;
            }
        });
        
        // shortest job first, Priority was set as processing time.
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
            	if(o1[1] >= o2[1]) return 1;
            	else return -1;
            }
        });
        
        int jobIdx = 0;
        int recent_time = 0;
        while(count < jobs.length) {
        	while(jobIdx < jobs.length && jobs[jobIdx][0] <= recent_time) {
        		pq.add(jobs[jobIdx++]);
        	}
        	
        	if(pq.isEmpty()) {
        		recent_time = jobs[jobIdx][0];
        	}
        	else {
        		int[] temp = pq.poll();
        		// Time from request to termination (recent_time + temp[1] - temp[0])
        		total_time += recent_time + temp[1] - temp[0];
        		recent_time += temp[1];
        		count++;
        	}
        }
        
        int answer = total_time / jobs.length;
        return answer;
    }
}