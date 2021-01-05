package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : Base Station Installation
// using greedy algorithm
public class Level3_41 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(", ");
		int[] stations = new int[input.length];
		int w = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < input.length; ++i) {
			stations[i] = Integer.parseInt(input[i]);
		}
		sb.append(solution(n, stations, w) + "");
		System.out.print(sb);
	}
	
	public static int solution(int n, int[] stations, int w) {
        int answer = 0;	// Number of stations to be installed
        int s_idx = 0;	// station index
        int pos = 1;    // current location
        
        while(pos <= n) {
        	// Check if the current position is within the radio wave range (w) 
        	// of the existing base stations (stations[s_idx])
        	
        	// If it is within the range of the existing base station.
        	// Since it is a radio wave range, there is no need to install a base station.
        	if(s_idx < stations.length && pos >= stations[s_idx] - w) {
        		pos = stations[s_idx] + w + 1;	// next position
        		s_idx++;	// Index +1 to find the next installed base station
        	}
        	else {
        		answer++;	// install 1 station
        		// Maximum radio wave range caused by base station installation
        		pos += (w*2) + 1; // Left Radio Range(w) + Base Station Installation (1) + Right Radio Range(w)
        	}
        }
        return answer;
    }
}