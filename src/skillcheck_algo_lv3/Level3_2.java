package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : Thanks giving day traffic
// important to convert time into seconds
public class Level3_2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		String[] lines = new String[n];
		
		for(int i = 0; i < n; i++) {
			lines[i] = br.readLine();
		}
		
		sb.append(solution(lines) + "");
		System.out.print(sb);
	}
	
	public static int solution(String[] lines) {
		int answer = 0;
		int traffic = 0;
		
		float[] start_time = new float[lines.length];
		float[] end_time = new float[lines.length];
		
		// convert time into seconds
		for(int i = 0; i < lines.length; i++) {
			String[] str = lines[i].split(" ");
			String[] time_str = str[1].split(":");
			int time_hour = Integer.parseInt(time_str[0]);
			int time_minute = Integer.parseInt(time_str[1]);
			float time_second = Float.parseFloat(time_str[2]);
			// End_time = T (Response Time)
			end_time[i] = time_hour*3600 + time_minute*60 + time_second;
			float T = Float.parseFloat(str[2].replace("s", ""));
			start_time[i] = end_time[i] - T + 0.001f;
		}
		
		for(int i = 0; i < lines.length; i++) {
			// Based on start time
			for(int j = 0; j < lines.length; j++) {
				if((start_time[i] >= start_time[j] && start_time[i] <= end_time[j])
						|| (start_time[i] + 0.999f >= start_time[j] && start_time[i] + 0.999f <= end_time[j])
						|| (start_time[i] <= start_time[j] && start_time[i] + 0.999f >= end_time[j])) {
					traffic++;
				}
			}
			
			if(traffic > answer) answer = traffic;
			traffic = 0;
			
			//// Based on end time
			for(int j = 0; j < lines.length; j++) {
				if((end_time[i] >= start_time[j] && end_time[i] <= end_time[j])
						|| (end_time[i] + 0.999f >= start_time[j] && end_time[i] + 0.999f <= end_time[j])
						|| (end_time[i] + 0.999f >= start_time[j] && end_time[i] <= end_time[j])) {
					traffic++;
				}
			}
			
			if(traffic > answer) answer = traffic;
			traffic = 0;
		}
		
		return answer;
    }
}