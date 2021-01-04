package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        int answer = 0;
        int s_idx = 0;
        int pos = 1;
        
        while(pos <= n) {
        	if(s_idx < stations.length && pos >= stations[s_idx] - w) {
        		pos = stations[s_idx] + w + 1;
        		s_idx++;
        	}
        	else {
        		answer++;
        		pos += (w*2) + 1;
        	}
        }
        return answer;
    }
}