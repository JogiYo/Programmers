package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Level3_39 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int n = Integer.parseInt(input[0]);
		int t = Integer.parseInt(input[1]);
		int m = Integer.parseInt(input[2]);
		
		String[] timetable = br.readLine().split(", ");
		
		sb.append(solution(n, t, m, timetable));
		System.out.print(sb);
	}

	public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
        });
        
        for(String table : timetable) {
        	int time = Integer.parseInt(table.substring(0,2))*60 + Integer.parseInt(table.substring(3));
        	pq.offer(time);
        }
        
        int bus_time = 540;
        int corn = 0;
        
        while(n-- > 0) {
        	int accept_pass = m;
        	int time = 0;
        	
        	while(!pq.isEmpty()) {
        		if(pq.peek() <= bus_time && accept_pass > 0) {
        			accept_pass--;
        			time = pq.poll();
        		}
        		else break;
        	}
        	
        	if(n > 0) {
        		if(pq.isEmpty()) {
        			corn = bus_time + ((n+1) * t);
        			break;
        		}
        		
        		bus_time += t;
        	}
        	else {
        		if(accept_pass > 0) corn = bus_time;
        		else corn = time-1;
        		break;
        	}
        }
        
        answer = String.format("%02d", corn/60) + ":" + String.format("%02d", corn%60);
        return answer;
    }
}