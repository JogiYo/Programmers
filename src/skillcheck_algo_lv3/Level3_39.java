package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// Programmers Level 3 : Shuttle Bus
// using Priority Queue and Convert time to minute.
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
        // Sort the crew arrival times in ascending order.
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
        // Converts the first time the bus arrives in minutes. 9:00
        int bus_time = 540;
        int corn = 0; // corn bus ride time
        // Count the number of bus trips
        while(n-- > 0) {
        	int accept_pass = m; // Initialize the maximum capacity
        	int time = 0; // Last crew's time
        	
        	while(!pq.isEmpty()) {
        		if(pq.peek() <= bus_time && accept_pass > 0) {
        			accept_pass--;
        			time = pq.poll();
        		}
        		else break;
        	}
        	
        	if(n > 0) {
        		if(pq.isEmpty()) {
        			corn = bus_time + (n * t); // Last bus time
        			break;
        		}
        		
        		bus_time += t;
        	}
        	// if Last Bus
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