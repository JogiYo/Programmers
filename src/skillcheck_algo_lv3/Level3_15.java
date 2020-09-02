package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
// Programmers Level 3 : Disk Controller
// heap
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
        int answer = 0;
        int count = 0; // task count
        
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
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
            	if(o1[1] >= o2[1]) return 1;
            	else return -1;
            }
        });
        
        int jobIdx = 0;
        int recent_end = 0;
        while(count < jobs.length) {
        	while(jobIdx < jobs.length && jobs[jobIdx][0] <= recent_end) {
        		pq.add(jobs[jobIdx++]);
        	}
        	
        	if(pq.isEmpty()) {
        		
        	}
        }
        
        return answer;
    }
}