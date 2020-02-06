package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : Thanks giving day traffic
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
		double S, T, section_start, section_end;
		
		for(int i = 0; i < lines.length; i++) {
			String[] str = lines[i].split(" ");
			String[] time_str = str[1].split(":");
			double time_hour = Double.parseDouble(time_str[0]);
			double time_minute = Double.parseDouble(time_str[1]);
			double time_second = Double.parseDouble(time_str[2]);
			
			S = (int)time_hour*3600 + (int)time_minute*60 + time_second;
			T = Double.parseDouble(str[2].replace("s", ""));
			
			section_start = S - T + 0.001;
			section_end = section_start + 0.999;
		
			for(int j = i; j < lines.length; j++) {
				str = lines[j].split(" ");
				time_str = str[1].split(":");
				time_hour = Double.parseDouble(time_str[0]);
				time_minute = Double.parseDouble(time_str[1]);
				time_second = Double.parseDouble(time_str[2]);
				
				S = (int)time_hour*3600 + (int)time_minute*60 + time_second;
				T = Double.parseDouble(str[2].replace("s", "")) - 0.001;
				double start_time = S - T + 0.001;
				double end_time = S;
				
				if(section_start <= start_time || end_time <= section_end) traffic++;
				else break;
			}
			
			if(answer < traffic) {
				answer = traffic;
				traffic = 0;
			}
		}
		
		return answer;
    }
}