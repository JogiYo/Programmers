package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// Programmers Level 3 : Travel route
// DFS, BFS  using DFS
public class Level3_16 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		String[][] tickets = new String[n][2];
		
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(", ");
			tickets[i][0] = input[0];
			tickets[i][1] = input[1];
		}
		
		String[] result = solution(tickets);
		
		for(int i = 0; i < result.length; i++) {
			if(i == result.length - 1) {
				sb.append(result[i]);
			}
			else {
				sb.append(result[i] + ", ");
			}
		}
		
		System.out.print(sb);
	}
	
	static ArrayList<String> arr = new ArrayList<String>();
	static String route = "";
	static boolean[] visit;
	
	public static String[] solution(String[][] tickets) {
        String[] answer;
        
        for(int i = 0; i < tickets.length; i++) {
        	visit = new boolean[tickets.length];
        	// Start with "ICN". (DFS)
        	if(tickets[i][0].equals("ICN")) {
        		route = tickets[i][0] + ", ";
        		visit[i] = true;
        		dfs(tickets, tickets[i][1], 1);
        	}
        }
        
        // Routes can have multiple routes and are sorted alphabetically
        Collections.sort(arr);
        answer = arr.get(0).split(", ");
        
        return answer;
    }

	private static void dfs(String[][] tickets, String dst, int count) {
		route += dst + ", ";
		// When all tickets have been used
		if(count == tickets.length) {
			arr.add(route);
			return;
		}
		
		for(int i = 0; i < tickets.length; i++) {
			String start = tickets[i][0];
			String end = tickets[i][1];
			
			if(start.equals(dst) && !visit[i]) {
				visit[i] = true;
				dfs(tickets, end, count+1);
				// In addition to the previous route, 
				// you can choose another route in the middle, 
				// so when the DFS call ends, you need to subtract the current visit location from the visit and route.
				visit[i] = false;
				route = route.substring(0, route.length()-5);
			}
		}
	}
}