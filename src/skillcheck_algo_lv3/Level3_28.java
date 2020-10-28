package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : Best set
// There are times when intuition is necessary.
public class Level3_28 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int n = Integer.parseInt(input[0]);
		int s = Integer.parseInt(input[1]);
 		int[] result = solution(n, s);
 		
 		sb.append(result[0]);
 		for(int i = 1; i < n; i++) {
 			sb.append(", " + result[i]);
 		}
		System.out.print(sb);
	}
	
	public static int[] solution(int n, int s) {
        if(n > s) return new int[] {-1}; 
		int[] answer = new int[n];
		// If the elements are close to s/n, the maximum product is obtained.
		// ex) s = 9, n = 3 -> {3,3,3} is maximum product.
		// ex) s = 11, n = 3 -> {3,4,4} is maximum product.
		if(s%n == 0) {
			for(int i = 0; i < n; i++) {
				answer[i] = s / n;
			}
		}
		// If S does not divide by n, there will be a remainder, 
		// and you can return it by putting +1 at the end of the array that returns the remaining range.
		else {
			int remain = s % n;
			int idx = n - remain;
			for(int i = 0; i < idx; i++) answer[i] = s / n;
			for(int i = idx; i < n; i++) answer[i] = (s / n) + 1;
		}
        return answer;
    }
}