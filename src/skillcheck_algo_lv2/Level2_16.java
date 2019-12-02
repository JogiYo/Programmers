package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Joy Stick
// Greedy Algorithm
public class Level2_16 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		sb.append(solution(br.readLine()) + "");
		System.out.print(sb);
	}
	
	public static int solution(String name) {
		int answer = 0;
		int len = name.length();
		// Check in which direction you are going fast.
		int tmp = 0;
		// turn(initial value : Maximum distance)
		int turn = len-1;
		
		// ASCII code :  'A' -> 65,  'Z' -> 90
		for(int i = 0; i < len; i++) {
			// Number of moves up and down in each alphabet
			tmp += Math.min(name.charAt(i) - 65, 91 - name.charAt(i));
			
			// next character
			int next = i+1;
			// Move right until it encounters a letter other than 'A'
			while(next < len && name.charAt(next) == 'A') next++;
			// i + len - next : The number of times to move left until you encounter a letter other than A.
			// Math.min(i, len - next) : 
			// Compare the lesser of the current progress index and the nearest non-A index behind it.
			turn = Math.min(turn, i + len - next + Math.min(i, len-next));
		}
		
		tmp += turn;
		answer = tmp;
		
		return answer;
	}
}