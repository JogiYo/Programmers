package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : String compression (2020 KAKAO Open recruitment)
// using substring
// substring(start) -> split string from start index to end index.
// substring(start, end) -> split string from start index to end-1 index.
public class Level1_31 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		sb.append(solution(input));
		System.out.print(sb);
	}
	
	public static int solution(String s) {
        if(s.length() == 1) return 1;
		int answer = 1001;
		int index = (s.length() / 2) + 1;
		
		// i = index = String unit length
		for(int i = index; i > 0; i--) {
			String print = "";
			String comp = "";
			int count = 1;
			// Split strings to compare
			for(int j = 0; j < s.length(); j += i) {
				String cur = "";
				if(j + i > s.length()) cur = s.substring(j);
				else cur = s.substring(j, j+i);
				
				if(comp.isEmpty()) {
					comp = cur;
					continue;
				}
				
				if(!comp.equals(cur)) {
					if(j + i >= s.length()) {
						print += cur;
					}
					if(count > 1) {
						print += Integer.toString(count) + comp;
					}
					else {
						print += comp;
					}
					comp = cur;
					count = 1;
				}
				// comp = cur : When strings are equal
				else {
					count++;
					if(j + i >= s.length()) {
						print += Integer.toString(count) + cur;
					}
				}
			}
			
			answer = Math.min(answer, print.length());
		}
        
        return answer;
    }
}